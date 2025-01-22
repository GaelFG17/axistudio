FROM maven:3.9.4-eclipse-temurin-17 AS build

# Copiar los archivos del proyecto
COPY pom.xml /app/
COPY src /app/src/

# Establecer el directorio de trabajo
WORKDIR /app

# Construir el JAR
RUN mvn clean package -DskipTests

# Etapa 2: Imagen para ejecutar la aplicación
FROM openjdk:17

# Copiar el JAR generado desde la etapa de construcción
COPY --from=build /app/target/reporte-0.0.1-SNAPSHOT.jar /app/reporte-0.0.1-SNAPSHOT.jar

# Definir el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/reporte-0.0.1-SNAPSHOT.jar"]

# Exponer el puerto en el que se ejecutará el servicio
EXPOSE 8080
