# Use an official Java runtime as a parent image
FROM amazoncorretto:21.0.4-alpine3.18

MAINTAINER Jacopo Sabatini

ARG JAR_FILE=*.jar

COPY ${JAR_FILE} application.jar

# Espone la porta su cui gira l'app (ad es. 8080)
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "application.jar"]