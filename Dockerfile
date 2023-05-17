FROM amazoncorretto:17-alpine-jdk
MAINTAINER EZD
COPY target/portfolio-0.0.1-SNAPSHOT.jar ezd-app.jar
ENTRYPOINT ["java","-jar","/ezd-app.jar"]
