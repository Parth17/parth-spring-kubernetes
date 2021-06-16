#
# Build stage
#
FROM maven:3.5-jdk-8 AS build
COPY src /home/app/parth-spring-kubernetes/demo-frontend/src
COPY pom.xml /home/app/parth-spring-kubernetes/demo-frontend
RUN mvn -f /home/app/parth-spring-kubernetes/demo-frontend/pom.xml clean package


#
# Package stage
#
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY --from=build /home/app/parth-spring-kubernetes/demo-frontend/target/demo-frontend-1.0-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]
