# Dockerfile for Ingredient service
FROM openjdk:17-jdk-slim
EXPOSE 8084
ADD target/Ingredient-0.0.1-SNAPSHOT.jar ingredient.jar
ENTRYPOINT ["java", "-jar", "ingredient.jar"]
