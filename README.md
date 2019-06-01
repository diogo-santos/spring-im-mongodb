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
