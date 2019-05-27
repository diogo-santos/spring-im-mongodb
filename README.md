# Spring Microservice Mongodb
Demo project for RESTful Spring Boot with MongoDb

## What you'll need
Java 1.8

Maven 3.0+

## Instructions
Import the project from GitHub

Run spring-ms-mongodb app
```
mvn clean package && java -jar target/spring-ms-mongodb-0.0.1.jar
```
## Test the App
Now that the app is running, visit http://localhost:8080/staff in order to see all staff members

To Find a staff member by name

http GET http://localhost:8080/staff/find  {"firstName": "Queen","lastName": "King"}

![Print](https://github.com/diogo-santos/spring-ms-mongodb/blob/master/findByName.png)
