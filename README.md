# Family tree api

This project is a back end of the family tree project

## Run neo4j docker container
`docker run 
    --name neo4j 
    -p7474:7474 -p7687:7687 
    -d 
    -v $HOME/docker/neo4j/data:/data 
    -v $HOME/docker/neo4j/logs:/logs 
    -v $HOME/docker/neo4j/import:/var/lib/neo4j/import 
    -v $HOME/docker/neo4j/plugins:/plugins 
    --env NEO4J_AUTH=neo4j/neo4j 
    neo4j:latest`

## Generate jar file
Run `mvn clean install`

## Create docker image
Run `docker build -t commiter/family-tree-api . `

## Run docker image
Run `docker run -p 8080:8080 commiter/family-tree-api`

## Test your application 
Run `curl -X GET localhost:8080/api/members`