FROM amazoncorretto:17-alpine-jdk 
MAINTAINER NM
COPY target/nacho-0.0.1-SNAPSHOT.jar nacho-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/nacho-app.jar"]