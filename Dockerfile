FROM openjdk:8-jdk-alpine

USER root

# Application port is always 8080.
EXPOSE 8080

# Management port is always 8081.
EXPOSE 8081

# Create dedicated user and group to run the application.
RUN adduser -D -u 1000 family_tree_api

USER 1000

COPY target/family-tree-api.jar /family-tree-api.jar

ENTRYPOINT ["java","-jar","/family-tree-api.jar"]