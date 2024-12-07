# Dockerfile
FROM openjdk:21-jdk-slim

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:resolve

# Copy the source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

RUN ls -al target/

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/TaskManager-0.0.1-SNAPSHOT.jar"]