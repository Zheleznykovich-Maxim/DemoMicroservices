FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/installment-service-*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
