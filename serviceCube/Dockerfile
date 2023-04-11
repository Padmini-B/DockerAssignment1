FROM openjdk:17 as buildstage
WORKDIR /cube-docker

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN chmod +x mvnw
RUN ./mvnw package
COPY target/*.jar cube-docker.jar

FROM openjdk:17
COPY --from=buildstage /cube-docker/cube-docker.jar .
ENTRYPOINT ["java","-jar","/cube-docker.jar"]
