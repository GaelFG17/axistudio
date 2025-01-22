import requests

url = "http://127.0.0.1:5000/generar_qr"
data = {"email": "maria.gome@mail.com"}

response = requests.post(url, json=data)

if response.status_code == 201:
    print(f"QR generado correctamente. Ruta del archivo: {response.json()['qr_path']}")
else:
    print(f"Error: {response.json()['error']}")
