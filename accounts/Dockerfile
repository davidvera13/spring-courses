FROM eclipse-temurin:25-jdk-alpine AS builder

# Use adduser (lighter alternative to useradd)
RUN adduser --home /home/appuser --disabled-password appuser
USER appuser

WORKDIR /opt/app
# copy required files
COPY ./.mvn/ ./.mvn
COPY ./mvnw ./mvnw
COPY ./pom.xml ./pom.xml

RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install -DskipTests


FROM eclipse-temurin:25-jre-alpine

# https://specs.opencontainers.org/image-spec/annotations/
LABEL "org.opencontainers.image.authors"="David Vera"
LABEL "org.opencontainers.image.created"="2025-06-15T15:00:00+01:00"
LABEL "org.opencontainers.image.authors"="david.vera@9online.fr"
LABEL "org.opencontainers.image.version"="0.0.2-SNAPSHOT"
LABEL "org.opencontainers.image.title"="Accounts Microservice"
LABEL "org.opencontainers.image.description"="Microservice for managing Accounts"

# Use adduser (lighter alternative to useradd)
RUN adduser --home /home/appuser --disabled-password appuser
USER appuser

WORKDIR /opt/app

COPY --from=builder /opt/app/target/accounts.jar /opt/app/accounts.jar

ENTRYPOINT ["java", "-jar", "/opt/app/accounts.jar"]