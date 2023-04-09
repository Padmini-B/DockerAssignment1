FROM openjdk:17
EXPOSE 8282
ADD target/*.jar fibonacci-docker.jar 
ENTRYPOINT ["java","-jar","/fibonacci-docker.jar"]