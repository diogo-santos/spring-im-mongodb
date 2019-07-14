# Spring Boot with InMemory Mongodb
Demo project for Spring Boot with InMemory MongoDb

## What you'll need
Java 1.8

Maven 3.0+

## Instructions
Import the project from GitHub

Run spring-im-mongodb app
```
mvn clean package && java -jar target/spring-im-mongodb-0.0.1.jar
```
## Test the App
Now that the app is running, visit http://localhost:8080/staff in order to see all staff members

To Find a staff member by name

http GET http://localhost:8080/staff/find  {"firstName": "Queen","lastName": "King"}

## MongoDB Repository
Spring Data Repository interface allow you to perform various operations related to the Person Object. It gets these operations by extending MongoRepository, which in turn extends the PagingAndSortingRepository interface defined in Spring Data Commons

## Embedded Testing
It’s a good approach when we want to test if our application behaves accordingly when the code is working directly with the persistence layer

Unfortunately, using an embedded server cannot be considered as “full integration testing”; hence, if we want to run communication tests in the environment as close to the production as possible, a better solution is to use an environment container such as Docker
