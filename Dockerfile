# -----------------------------
# Stage 1: Build the application
# -----------------------------
    FROM maven:3.9.6-eclipse-temurin-17 AS build

    # Set working directory inside container
    WORKDIR /app
    
    # Copy Maven configuration and source code
    COPY pom.xml .
    COPY src ./src
    
    # Build the Spring Boot application (skip tests for speed)
    RUN mvn clean package -DskipTests
    
    # Build stage: compile Spring Boot application using Maven
    # Run stage: execute lightweight JDK runtime
    
    # -----------------------------
    # Stage 2: Run the application
    # -----------------------------
    FROM eclipse-temurin:17-jdk
    
    # Set working directory for runtime container
    WORKDIR /app
    
    # Copy the generated JAR file from build stage
    COPY --from=build /app/target/*.jar app.jar
    
    # Expose application port
    EXPOSE 8080
    
    # Start the application
    ENTRYPOINT ["java", "-jar", "app.jar"]