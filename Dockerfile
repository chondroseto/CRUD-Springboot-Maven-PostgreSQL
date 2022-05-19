FROM openjdk:8-jdk-alpine

MAINTAINER enigmacamp.com

LABEL author = "Seto Nur"

COPY target/learn-spring-0.0.1-SNAPSHOT.jar enigmashop-service-1.0.jar

EXPOSE 9000

ENTRYPOINT ["java","-jar","enigmashop-service-1.0.jar"]