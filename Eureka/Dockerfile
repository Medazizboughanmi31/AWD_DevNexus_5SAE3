FROM openjdk:17-jdk-slim
EXPOSE 8030
ADD target/Eureka-0.0.1-SNAPSHOT.jar Eureka.jar
ENTRYPOINT ["java", "-jar", "Eureka.jar"]