FROM openjdk:17 as buildstage
WORKDIR /fibonacci-docker

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN chmod +x mvnw
RUN ./mvnw package
COPY target/*.jar fibonacci-docker.jar

FROM openjdk:17
COPY --from=buildstage /fibonacci-docker/fibonacci-docker.jar .
ENTRYPOINT ["java","-jar","/fibonacci-docker.jar"]
