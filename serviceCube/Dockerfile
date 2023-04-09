FROM openjdk:17
EXPOSE 8383
ADD target/*.jar cube-docker.jar 
ENTRYPOINT ["java","-jar","/cube-docker.jar"]