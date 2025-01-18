# Usar una imagen base con Java 11 (o la versión que tu aplicación use)
FROM openjdk:21

# Copiar el JAR de la aplicación dentro del contenedor
COPY target/costumer-0.0.1-SNAPSHOT.jar /app/costumer-0.0.1-SNAPSHOT.jar

# Definir el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/costumer-0.0.1-SNAPSHOT.jar"]

# Exponer el puerto en el que se ejecutará el servicio
EXPOSE 8080