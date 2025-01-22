from flask import Flask, jsonify, request
import qrcode
import io
import base64
from datetime import datetime, timedelta

app = Flask(__name__)

@app.route('/generar_qr', methods=['POST'])
def generar_qr():
    try:
        data = request.get_json()
        email = data.get('email')
        
        if not email:
            return jsonify({'error': 'El email es obligatorio'}), 400

        # Calcular la fecha de caducidad (7 días desde ahora, por ejemplo)
        fecha_caducidad = (datetime.now() + timedelta(days=7)).strftime('%Y-%m-%d %H:%M:%S')

        # Generar el contenido del QR
        qr_content = f"Email: {email}\nFecha de caducidad: {fecha_caducidad}"

        # Generar el código QR en memoria
        qr = qrcode.make(qr_content)
        qr_io = io.BytesIO()
        qr.save(qr_io, format='PNG')
        qr_io.seek(0)

        # Convertir la imagen a base64
        qr_base64 = base64.b64encode(qr_io.read()).decode('utf-8')

        return jsonify({
            'message': 'QR generado correctamente',
            'qr_base64': qr_base64,
            'email': email,
            'fecha_caducidad': fecha_caducidad
        }), 201

    except Exception as e:
        return jsonify({'error': f'Error: {str(e)}'}), 500

if __name__ == '__main__':
    app.run(debug=True)
