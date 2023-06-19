# <ins>Marvel Service</ins>

### Description
> This application fetch half of the total of characters available through the Marvels API
> and the comics in which they appear and then exposes the characters and comics over an API.


## How To Run The Project
 1. **Create an account at [Marvel Developer Portal](https://developer.marvel.com/).**
 2. **Go to [Get a Key](https://developer.marvel.com/account)** and <ins>copy both public and private keys</ins>.
 3. Clone the project.
 4. Inside the project's directory:
    * If you have Maven installed in your machine run:
    ```shell
    mvn clean install && java -jar target/marvel-service-0.0.1-SNAPSHOT.jar \
    --MARVEL_PUBLIC_KEY='${MARVEL_PUBLIC_KEY}' --MARVEL_PRIVATE_KEY='${MARVEL_PRIVATE_KEY}'
    ```
    * If you DON'T have maven installed in your machine run:
    ```shell
    ./mvnw clean install && java -jar target/marvel-service-0.0.1-SNAPSHOT.jar \
    --MARVEL_PUBLIC_KEY='${MARVEL_PUBLIC_KEY}' --MARVEL_PRIVATE_KEY='${MARVEL_PRIVATE_KEY}'
    ```
    > Replace ${MARVEL_PUBLIC_KEY} and ${MARVEL_PRIVATE_KEY} with the ones you get from Marvel.


## How To Run The Tests
* If you want just to run the application tests you can do so by using this command:

    * If you have Maven installed in your machine run:
    ```shell
    mvn test 
    ```
    * If you DON'T have maven installed in your machine run:
    ```shell
    ./mvnw test
    ```
  
> #### About the tests:
  >> Inside the project you will find examples of **unit tests** for the controller adapter and service and also **integration tests** for the repository adapter.

### API Documentation:
The API documentation is available through the following URL once the project is running: http://localhost:9090/actuator/swagger-ui

## Technical Overview
   1. **The project follows a <ins>hexagonal architecture with DDD</ins>.**
   2. **Uses Swagger following API First for the documentation about the endpoints.**
   3. **To communicate with the Marvels API take advantage of Spring Cloud OpenFeign.**
   4. **Thanks to Spring Boot Actuator the Swagger port and any management tools can be moved to the one the developers team wants.** 

## To Be Done
   1. Increase the test coverage.
   2. Implements a Spring Batch tasklet or job to fetch Marvel characters.
   3. Control any errors coming from de Marvel API.
   4. Improve database query's to get a better performance fetching all comics and characters.