FROM gradle:8.5-jdk17
WORKDIR /app

COPY build/libs/payment-service-*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
