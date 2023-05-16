FROM amazoncorreto:11-alpine-jdk
ADD MAINTAINER EZD
COPY target/portfolio-0.0.1-SNAPSHOT ezd-app.jar
ENTRYPOINT ["java","-jar","/ezd-app.jar"]
