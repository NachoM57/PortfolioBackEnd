FROM amazoncorretto:1.8-alpine-jdk 
MAINTAINER nacho
COPY target/nacho-0.0.1-SNAPSHOT.jar  nacho-app.jar
ENTRYPOINT ["java","-jar","/nacho-app.jar"]