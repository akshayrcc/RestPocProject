# REST Poc Project

## Endpoint details:

- GET /api/customers - returns the list of all customers in the CSV file.
  e.g. `http://localhost:8091/api/customers`

- GET /api/customers/{customerId} - returns a single customer by ID.
  e.g. `http://localhost:8091/api/customers/1Ef7b82A4CAAD10`

## Additionals

- Unit tests that cover the core logic.
- Docker Image Builder Script

## Steps to run local jar

1. Maven Build Command: `mvn clean install`
2. Run Jar Command: `java -jar target/RestPocProject-0.0.1-SNAPSHOT.jar`

## Steps to build docker image & spin docker container

1. `mvn clean package`
2. `docker build -t restpocproject`
3. `docker run -p 8091:8091 restpocproject`

## Steps to monitor, stop Docker container & delete docker image

1. `docker ps`
2. `docker stop <container_id>`
3. `docker rm <container_id>`
4. `docker images`
5. `docker rmi restpocproject`
