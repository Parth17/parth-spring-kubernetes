#
# Build stage
#
FROM maven:3.5-jdk-8 AS build
COPY src /home/app/parth-spring-kubernetes/demo-backend/src
COPY pom.xml /home/app/parth-spring-kubernetes/demo-backend
RUN mvn -f /home/app/parth-spring-kubernetes/demo-backend/pom.xml clean package


#
# Package stage
#
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY --from=build /home/app/parth-spring-kubernetes/demo-backend/target/demo-backend-0.0.1-SNAPSHOT.jar /usr/local/lib/demo1.jar
EXPOSE 8081
ENTRYPOINT ["nohup java","-jar","/usr/local/lib/demo1.jar &"]
