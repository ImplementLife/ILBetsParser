FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app
COPY Bots/pom.xml .
COPY Bots .
RUN mvn clean install -DskipTests

CMD ["mvn", "spring-boot:run"]