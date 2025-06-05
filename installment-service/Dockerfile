# Используем минимальный образ OpenJDK
FROM openjdk:17-jdk-slim

# Рабочая директория в контейнере
WORKDIR /app

# Копируем jar-файл в контейнер
COPY target/installment-service-0.0.1-SNAPSHOT.jar app.jar

# Указываем порт, если хочешь видеть его в docker ps
EXPOSE 8080

# Точка входа
ENTRYPOINT ["java", "-jar", "app.jar"]
