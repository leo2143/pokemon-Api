# IMAGEN BASE CON JDK Y MAVEN
FROM maven:3.9.6-eclipse-temurin-21 AS build

# EXPONER PUERTO
EXPOSE 8080

# CARPETA DE TRABAJO
WORKDIR /root

# COPIAR ARCHIVOS NECESARIOS PARA MAVEN
COPY ./pom.xml ./

# DESCARGAR DEPENDENCIAS SIN COMPILAR
RUN mvn dependency:go-offline

# COPIAR EL CÓDIGO FUENTE
COPY ./src ./src

# COMPILAR LA APLICACIÓN
RUN mvn clean install -DskipTests

# ---------------------------
# SEGUNDA ETAPA: IMAGEN MÁS LIGERA
# ---------------------------
FROM eclipse-temurin:21.0.3_9-jdk

WORKDIR /root

# COPIAR SOLO EL JAR COMPILADO
COPY --from=build /root/target/*.jar app.jar

# EXPONER EL PUERTO
EXPOSE 8080

# EJECUTAR LA APLICACIÓN
ENTRYPOINT ["java", "-jar", "app.jar"]
