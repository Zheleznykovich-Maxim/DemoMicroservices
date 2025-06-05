FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/user-gateway-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082  # или другой порт, если у тебя указан в конфиге

ENTRYPOINT ["java", "-jar", "app.jar"]
