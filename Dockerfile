FROM amazoncorretto:11-alpine-jdk 
MAINTAINER NM
COPY target/nacho-0.0.1-SNAPSHOT.jar  nacho-app.jar
ENTRYPOINT ["java","-jar","/nacho-app.jar"]