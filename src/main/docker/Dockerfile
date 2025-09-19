# Use an official Java runtime as a parent image
FROM amazoncorretto:21.0.4-alpine3.18

LABEL org.opencontainers.image.authors="jacopo@sabatini.it"

COPY target/exercises-0.0.1-SNAPSHOT.jar application.jar

# Espone la porta su cui gira l'app (ad es. 8080)
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "application.jar"]