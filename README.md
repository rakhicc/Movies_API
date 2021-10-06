# This project depicts the Spring Boot Example with Spring Data MongoDB

 - If you add some Unit Tests, you would start them with mvn clean test.

 - You can build the project with : mvn clean install -U.

 - To run the project, Choose the Spring Boot Application file (search for @SpringBootApplication). Right Click on the file (App.java) and Run as Java Application

 - the server get started on port 8082

# URLs

 - http://localhost:8082/movies/	:POST method is to insert movie information to database.
 - http://localhost:8082/movies/{name}	:GET	method to get movie information based on movie name.
 - http://localhost:8082/movies/	:GET	method retrieves all movies.
