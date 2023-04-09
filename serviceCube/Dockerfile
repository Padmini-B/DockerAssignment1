FROM openjdk:17
EXPOSE 8082
ADD target/*.jar cube-docker.jar 
ENTRYPOINT ["java","-jar","/cube-docker.jar"]