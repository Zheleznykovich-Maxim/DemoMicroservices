FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/user-gateway-service-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
