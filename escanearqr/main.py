import cv2
from datetime import datetime
import mysql.connector

# Configuración de la base de datos
def get_db_connection():
    return mysql.connector.connect(
        host="localhost",
        user="root",  # Tu usuario
        password="example",  # Tu contraseña
        database="mydatabase"  # Tu base de datos
    )

def leer_y_procesar_qr():
    try:
        # Inicializar la cámara
        cap = cv2.VideoCapture(0)
        detector = cv2.QRCodeDetector()

        print("Apunte la cámara hacia el código QR")

        while True:
            ret, frame = cap.read()
            if not ret:
                continue

            # Detectar y decodificar el código QR
            qr_content, _, _ = detector.detectAndDecode(frame)

            if qr_content:
                print("Código QR detectado")

                # Procesar el contenido del QR
                lines = qr_content.split('\n')
                email_line = next((line for line in lines if line.startswith("Email:")), None)
                fecha_caducidad_line = next((line for line in lines if line.startswith("Fecha de caducidad:")), None)

                if not email_line or not fecha_caducidad_line:
                    print("El código QR no contiene los datos esperados")
                    continue

                email = email_line.split("Email: ")[1].strip()
                fecha_caducidad = fecha_caducidad_line.split("Fecha de caducidad: ")[1].strip()

                # Validar la caducidad
                fecha_caducidad_datetime = datetime.strptime(fecha_caducidad, '%Y-%m-%d %H:%M:%S')
                if datetime.now() > fecha_caducidad_datetime:
                    print("El código QR ha caducado")
                    continue

                # Registrar la entrada o salida
                connection = get_db_connection()
                cursor = connection.cursor()

                select_query = "SELECT hora_entrada, hora_salida FROM empleados WHERE email = %s"
                cursor.execute(select_query, (email,))
                result = cursor.fetchone()

                if not result:
                    print(f"Empleado con email {email} no encontrado")
                    continue

                hora_entrada, hora_salida = result

                if not hora_entrada or (hora_entrada and hora_salida):
                    # Registrar hora de entrada
                    update_query = "UPDATE empleados SET hora_entrada = NOW(), hora_salida = NULL WHERE email = %s"
                    cursor.execute(update_query, (email,))
                    connection.commit()
                    action = 'Entrada registrada'
                else:
                    # Registrar hora de salida
                    update_query = "UPDATE empleados SET hora_salida = NOW() WHERE email = %s"
                    cursor.execute(update_query, (email,))
                    connection.commit()
                    action = 'Salida registrada'

                cursor.close()
                connection.close()

                print(f"{action} para {email}")

            # Mostrar el cuadro de la cámara
            cv2.imshow('Escaneando QR', frame)

            # Salir con la tecla 'q'
            if cv2.waitKey(1) & 0xFF == ord('q'):
                break

        cap.release()
        cv2.destroyAllWindows()

    except Exception as e:
        print(f"Error: {str(e)}")

if __name__ == '__main__':
    leer_y_procesar_qr()
