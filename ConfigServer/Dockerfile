FROM openjdk:17-jdk-slim
EXPOSE 8001
ADD target/ConfigServer-0.0.1-SNAPSHOT.jar ConfigServer.jar
ENTRYPOINT ["java", "-jar", "ConfigServer.jar"]