FROM openjdk:17
EXPOSE 8181
ADD target/*.jar square-docker.jar 
ENTRYPOINT ["java","-jar","/square-docker.jar"]