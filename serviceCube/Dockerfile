FROM openjdk:17 as buildstage
EXPOSE 8082
COPY target/*.jar cube-docker.jar
ENTRYPOINT ["java","-jar","/cube-docker.jar"]