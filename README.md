# Login

Crear la imagen para el contenedor del front:
docker build -t angular-app . 

correr el contenedor:
docker run -d -p 3000:80 --name angular-container angular-app

