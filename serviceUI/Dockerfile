FROM openjdk:17
EXPOSE 7070
COPY target/*.jar ui-docker.jar
ENTRYPOINT ["java","-jar","/ui-docker.jar"]