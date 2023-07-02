# Backend - Base image with Amazon Corretto and Maven
FROM amazoncorretto:17 AS backend
# Set the working directory
WORKDIR /app
# Copy Application JAR into Docker image
COPY target/oracle-backend-1.0-SNAPSHOT.jar /app/oracle-backend.jar
# Copy config.yml file into Docker image
COPY config.yml /app/config.yml
# Expose Port 8080
EXPOSE 8080
# Run Dropwizard application inside docker image
CMD ["java", "-jar", "/app/oracle-backend.jar", "server", "config.yml"]


