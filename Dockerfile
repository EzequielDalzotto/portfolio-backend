FROM amazoncorreto:11-alpine-jdk
MAINTAINER  MAINTAINER EZD
COPY target/portfolio-0.0.1-SNAPSHOT ezd-app.jar
ENTRYPOINT ["java","-jar","/ezd-app.jar"]
