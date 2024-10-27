FROM openjdk:17-jdk-slim
EXPOSE 8020
ADD target/Event-0.0.1-SNAPSHOT.jar Event.jar
ENTRYPOINT ["java", "-jar", "Event.jar"]