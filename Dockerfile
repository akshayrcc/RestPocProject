# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the project JAR file into the container
COPY target/*.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8091

# Run the jar file
ENTRYPOINT ["java","-jar","/app/app.jar"]
