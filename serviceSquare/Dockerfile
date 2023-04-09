FROM openjdk:17 as buildstage
WORKDIR /square-docker

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN chmod +x mvnw
RUN ./mvnw package
COPY target/*.jar square-docker.jar

FROM openjdk:17
COPY --from=buildstage /square-docker/square-docker.jar .
ENTRYPOINT ["java","-jar","/square-docker.jar"]