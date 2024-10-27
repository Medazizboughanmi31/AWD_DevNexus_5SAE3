FROM openjdk:17-jdk-slim
EXPOSE 8021
ADD target/Ticket-0.0.1-SNAPSHOT.jar Ticket.jar
ENTRYPOINT ["java", "-jar", "Ticket.jar"]