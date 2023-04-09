FROM openjdk:17
EXPOSE 8484
ADD target/*.jar metrics-docker.jar 
ENTRYPOINT ["java","-jar","/metrics-docker.jar"]