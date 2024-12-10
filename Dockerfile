# Usar una imagen base de Maven con Java 11 preinstalado (o la versión que necesites)
FROM maven:3.9.4 AS build

# Configurar el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos de la aplicación al contenedor
COPY pom.xml .
COPY src ./src

# Construir el proyecto con Maven
RUN mvn clean package -DskipTests

# Usar una imagen ligera de OpenJDK para ejecutar la aplicación
FROM openjdk:21-jdk-slim

# Configurar el directorio de trabajo para la aplicación
WORKDIR /app

# Copiar el JAR generado desde la etapa de construcción
COPY --from=build /app/target/costumer-0.0.1-SNAPSHOT.jar /app/costumer-0.0.1-SNAPSHOT.jar

# Definir el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/costumer-0.0.1-SNAPSHOT.jar"]

# Exponer el puerto en el que se ejecutará el servicio
EXPOSE 8080
