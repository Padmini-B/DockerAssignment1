FROM openjdk:17
EXPOSE 8083
COPY target/*.jar fibonacci-docker.jar
ENTRYPOINT ["java","-jar","/fibonacci-docker.jar"]