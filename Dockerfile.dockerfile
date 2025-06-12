# Використовує офіційний образ Java 17
FROM openjdk:17-jdk-slim

# Встановлює робочу директорію
WORKDIR /app

# Копіює Maven Wrapper і pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Копіює вихідний код
COPY src src

# Будує проєкт
RUN ./mvnw clean install -DskipTests

# Копіює скомпільований .jar
RUN cp target/*.jar app.jar

# Запускає додаток
ENTRYPOINT ["java", "-jar", "app.jar"]