FROM openjdk:17-jdk-slim
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline
COPY src src
RUN ./mvnw clean install -DskipTests
RUN cp target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]