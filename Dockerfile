FROM openjdk:17-jdk-slim
MAINTAINER vrushank2103@gmail.com
COPY target/student-server-0.0.1-SNAPSHOT.jar student-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/student-server-0.0.1-SNAPSHOT.jar"]