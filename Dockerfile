# Use an official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container (you need to build the project first using Maven or Gradle)
COPY target/weather-dashboard.jar /app/weather-dashboard.jar

# Expose port 8080 to access the application
EXPOSE 8080

# Command to run the application when the container starts
CMD ["java", "-jar", "weather-dashboard.jar"]