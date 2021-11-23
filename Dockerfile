#FROM openjdk:8-jdk-alpine
FROM openjdk:13-jdk-alpine3.10
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]