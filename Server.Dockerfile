FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app
COPY Server/pom.xml .
COPY Server .
RUN mvn clean install -DskipTests

CMD ["mvn", "spring-boot:run"]