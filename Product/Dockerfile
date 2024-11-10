FROM openjdk:17-slim
EXPOSE 8008
ADD target/Product-0.0.1-SNAPSHOT.jar product.jar
ENTRYPOINT ["java", "-jar", "product.jar"]