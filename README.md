# Family tree api

This project is a back end of the family tree project

## Run neo4j docker container
`docker run -d -p 7474:7474 neo4j:latest`

## Generate jar file
Run `mvn clean install`

## Create docker image
Run `docker build -t commiter/family-tree-api . `

## Run docker image
Run `docker run -p 8080:8080 commiter/family-tree-api`

## Test your application 
Run `curl -X GET localhost:8080/api/members`