FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8081 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
