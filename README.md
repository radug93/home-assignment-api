# home-assignment-api

## Requirements
Java 11

## How to run it:
```mvn spring-boot:run```

## Endpoints

The endpoints can be imported in Postman via this [file](src/main/resources/home-assignment%20.postman_collection.json)

## Extra libraries
Lombok

Mapstruct

H2

## Assignment requirements (Links)
[Basic endpoints](src/main/java/com/example/homeassignmentapi/controller/ProductController.java)

[Authentication](src/main/java/com/example/homeassignmentapi/config/SpringSecurity.java)

[Error handling](src/main/java/com/example/homeassignmentapi/exception/handlers/ProductExceptionController.java)

[Logging](src/main/resources/application.yml) + ProductService

[Unit Tests](src/test/java/com/example/homeassignmentapi/ProductServiceTests.java)

[Java 9+ features](src/main/java/com/example/homeassignmentapi/service/ProductService.java) (Interface private methods + String.IsBlank)




