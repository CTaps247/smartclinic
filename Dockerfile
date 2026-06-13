# ---------------------------------------

# Stage 1: Build the Spring Boot App

# ---------------------------------------

FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside container

WORKDIR /app

# Copy Maven configuration file

COPY pom.xml .

# Copy application source code

COPY src ./src

# Build the application (skip tests for faster CI builds)

RUN mvn clean package -DskipTests

# ---------------------------------------

# Stage 2: Run the Spring Boot App

# ---------------------------------------

FROM eclipse-temurin:17-jdk

# Set working directory for runtime container

WORKDIR /app

# Copy built JAR from build stage

COPY --from=build /app/target/*.jar app.jar

# Expose backend API port

EXPOSE 8080

# Start the Spring Boot application

ENTRYPOINT ["java", "-jar", "app.jar"]
