FROM maven:3.8.2-jdk-17

WORKDIR /ui-docker
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run
