# dockerfile for Food service
FROM openjdk:17-jdk-slim
EXPOSE 8083
ADD target/Food-0.0.1-SNAPSHOT.jar food.jar
ENTRYPOINT ["java", "-jar", "food.jar"]
