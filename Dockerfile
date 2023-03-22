FROM amazoncorretto:11-alpine-jdk 
MAINTAINER Ignacio
COPY target/nacho-0.0.1-SNAPSHOT  nacho-app.jar
ENTRYPOINT ["java","-jar","/nacho-app.jar"]