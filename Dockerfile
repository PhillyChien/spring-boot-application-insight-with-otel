# Build stage ------------------------------------------------------------
# Use an official Maven image as a builder
FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file
COPY pom.xml ./

# Copy the src folder
COPY src ./src

COPY applicationinsights.json ./applicationinsights.json

# Build the application
RUN mvn clean install -DskipTests

# Run stage ------------------------------------------------------------
# Use a smaller base image for the final stage
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the target folder to the working directory
COPY --from=builder /app/target/*.jar app.jar

# Download Application Insights Agent
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/* \
    && curl -L -O https://github.com/microsoft/ApplicationInsights-Java/releases/download/3.6.2/applicationinsights-agent-3.6.2.jar

# Copy the Application Insights configuration file
COPY applicationinsights.json applicationinsights.json

# Expose the port the app will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-javaagent:applicationinsights-agent-3.6.2.jar", "-jar", "app.jar"]