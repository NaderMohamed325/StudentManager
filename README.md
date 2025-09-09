# StudentManager

A simple CRUD web application for managing academic entities (e.g., Students and Schools). It exposes RESTful endpoints
backed by Spring MVC and Spring Data JPA, uses Jakarta namespaces, and leverages Lombok to reduce boilerplate.

## Features

- Create, read, update, and delete core entities
    - Students
    - Schools
- RESTful JSON APIs
- Layered architecture (controller, service, repository, entity, dto)
- Spring Data JPA repositories for persistence
- Jakarta EE annotations/imports
- Lombok for DTOs/entities
- Ready to run via Maven Wrapper

## Tech Stack

- Java 24
- Spring Boot (Spring MVC, Spring Data JPA)
- Jakarta EE (jakarta.* imports)
- Lombok
- Maven (with Maven Wrapper)

## Project Structure

- src/main/java/com.nader.studentmanager
    - controller — REST controllers
    - service — business logic
        - dto — request/response DTOs (e.g., AddSchoolDto)
    - repository — Spring Data JPA repositories
    - entity — JPA entities
    - AppConfig — application-level configuration
    - StudentManagerApplication — Spring Boot entry point
- src/main/resources
    - application.properties — application configuration
    - templates, static — optional web assets

## Prerequisites

- JDK 24
- Maven (optional, Maven Wrapper provided)
- A database (H2, PostgreSQL, MySQL, etc.). Configure in application.properties.

## Getting Started

1) Clone the repository

```
bash
git clone <your-repo-url>
cd StudentManager
```

2) Configure the database

Edit src/main/resources/application.properties to match your environment.

Example: H2 (in-memory, dev friendly)

```
properties
spring.datasource.url=jdbc:h2:mem:studentdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.jpa.show-sql=true
```

Example: PostgreSQL

```
properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

3) Build and run

Using Maven Wrapper:

```
bash
./mvnw clean spring-boot:run
```

Or build a jar:

```
bash
./mvnw clean package
java -jar target/*.jar
```

The app starts on http://localhost:8080 by default.

## API Overview

Base URL: http://localhost:8080

Note: Paths may differ if customized. The following illustrates common CRUD patterns used in this project structure.

- Schools
    - GET /api/schools — list all schools
    - GET /api/schools/{id} — get a school by id
    - POST /api/schools — create a new school
        - Example request body (using AddSchoolDto-like shape):
      ```json
      {
        "name": "Engineering School",
        "address": "123 University Ave"
      }
      ```
    - PUT /api/schools/{id} — update an existing school
    - DELETE /api/schools/{id} — delete a school

- Students
    - GET /api/students — list all students
    - GET /api/students/{id} — get a student by id
    - POST /api/students — create a new student
      ```json
      {
        "firstName": "Nader",
        "lastName": "Ali",
        "email": "nader.ali@example.com",
        "schoolId": 1
      }
      ```
    - PUT /api/students/{id} — update an existing student
    - DELETE /api/students/{id} — delete a student

Example cURL (create a school):

```
bash
curl -X POST http://localhost:8080/api/schools \
-H "Content-Type: application/json" \
-d '{
"name": "Engineering School",
"address": "123 University Ave"
}'
```

Example cURL (list students):

```
bash
curl http://localhost:8080/api/students
```

## Testing

Run unit/integration tests:

```
bash
./mvnw test
```

## Configuration Notes

- Server port: change with

```
properties
server.port=8090
```

- JPA schema generation:

```
properties
spring.jpa.hibernate.ddl-auto=update
```

Use update/create-drop cautiously in production. Prefer migrations (e.g., Flyway/Liquibase) for real deployments.

- Logging:

```
properties
logging.level.org.springframework=INFO
logging.level.com.nader.studentmanager=DEBUG
```

## Troubleshooting

- Port 8080 already in use
    - Change server.port in application.properties
- Database connection failures
    - Verify URL/credentials/driver on your machine
    - Ensure DB server is running and accessible
- Missing Lombok annotations during build
    - Enable annotation processing in your IDE
    - Ensure Lombok dependency is present in pom.xml

## Contributing

1) Fork the repo
2) Create your feature branch
3) Commit your changes with clear messages
4) Open a pull request

## License

Specify your license here (e.g., MIT, Apache-2.0).

## Maintainers


