FROM openjdk:17 as buildstage
WORKDIR /ui-docker

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN chmod +x mvnw
RUN ./mvnw package
COPY target/*.jar ui-docker.jar

FROM openjdk:17
COPY --from=buildstage /ui-docker/ui-docker.jar .
ENTRYPOINT ["java","-jar","/ui-docker.jar"]
