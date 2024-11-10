FROM openjdk:17-slim
EXPOSE 8009
ADD target/Cart-0.0.1-SNAPSHOT.jar cart.jar
ENTRYPOINT ["java", "-jar", "cart.jar"]