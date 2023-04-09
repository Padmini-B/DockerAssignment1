FROM openjdk:17 as buildstage
WORKDIR /metrics-docker

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN chmod +x mvnw
RUN ./mvnw package
COPY target/*.jar metrics-docker.jar

FROM openjdk:17
COPY --from=buildstage /metrics-docker/metrics-docker.jar .
ENTRYPOINT ["java","-jar","/metrics-docker.jar"]