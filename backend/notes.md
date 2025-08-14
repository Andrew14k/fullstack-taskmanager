# Java Spring Boot

## Compliation/Execution
- For Maven: **./mvnw spring-boot:run**, pom.xml used for maven
- For Gradle: **./gradlew bootRun**, build.gradle used for gradle

## Spring Boot Fundamentals & REST API Development Basics
- Main goal of spring boot is spring boot is to quickly create spring-baed applications without requiring developers to write the same boilerplate configuration again and again
- Spring framework -> spring boot
- Spring boot:
1. Spring boot starters
2. Spring boot auto-configuration
3. Externalised Configuration
4. Spring boot actuator
5. Easy-to-use embedded servlet container support
- Spring framework is a very popular java framework for building web applications
1. Dependency injection
2. Easy to use but powerful database transaction management capabilities
3. Good Integration  with other java frameworks like JPA/Hiberanate/ORM/Struts/JSF
4. Web MVC framework for building web applications
- Spring boot automatically configures the configurations based on the jar dependencies that we add to our project

#### Spring Starters
- pre-configured with most commonly used library dependencies so you dont have to search and configure them manually
- spring-boot-starter-web adds all these libraries but also configures the commonly registered beans like ResourceHandlers, MessageSource, DisplatcherServlet etc
#### Spring Boot Auto-Configuration
- attempts to automatically configure Spring application based on the jar dependencies you have added to the project
- Spring boot asssume you are trying to build a SpringMVC-based web application and automatically tries to register Spring beans if not already registered
#### Externalised Configuration
- Spring boot provides good support to externalise the configuration dependent on the different environments
- for example, we typically deploy spring applications in different environment such as production, testing and development environments
#### Spring Boot Actuator
- provides a wide variety of production ready features without requiring developers to write much code
- can use spring boot actuator provided REST APIs to view the application within congiruation details, and can also use these actuator APIs to view the application URL mappings, environment details and configuration parameter values
- offers a lot of rest end-points that can be used as production ready features
#### Embedded servlet Container Support
- Spring boot allows you to create a jar file out of the spring application and then you can deploy that jar file in an embedded servlet container

## Annotations
- **@Controller** is used to make a java class as a spring MVC controller
- **@ResponseBody** tells a controller that the object returned is automatically serialised into JSON and passed back into the HttpResponse object
- **@RestController** combines Controller and ResponseBody
- **@GetMapping** to map HTTP GET requests onto specific handler methods
-  **@PostMapping** to map HTTP POST requests onto specific handler methods
- **@PutMapping** to map HTTP PUT requests onto specific handler methods
- **@DeleteMapping**to map HTTP DELETE requests onto specific handler methods
- **@PathVariable** used on method argument to bind it to the value of a URI template variable
- **@RequestParam** to extract query parameters, from parameters, and even files from the request
- **@RequestBody** is responsible for retrieving the HTTP request body and automatically converting it to the java object . Internally it uses spring provided HttpMessageConverter to conver JSON into java object
- **@ResponseStatus** to send a http status in the response (eg 200, 201 etc)
 **@RequestMapping** defines base URL for all http requests, defined at the class level with @RestController
 - **@SpringBootApplication** is used to define a Spring Boot application, combining several annotations such as Configuration, EnableAutoConfiguration and ComponentScan
 - **@Entity** specifies a class has a JPA entity
 - **@Table** specifies table details
 - **@CrossOrigin("*")** - all clients can be able to access these REST APIs

## ResponseEntity Class
- represents the whole http response, status code, headers, and body. This can be used to fully configure the http response
- to use it, we have to return it from the endpoint, spring does the rest
- ResponseEntity is a generic type, so we can use any type as the response body

#### Java Beans
- in the context of Spring, a java bean is any object that is instantiated, assembled, and managed by the spring inversion of control (IoC) container. 
- beans are building blocks of a spring application, created and wired automatically by the framework based on configuration metadata such as annotations or XML
- a bean is any java object whose lifecycle (creation, configuration, destruction) is handled by the spring container
- they can have dependencies injected
- when you define a class and tell Spring to manage it, that class becomes a Spring bean—and Spring handles its creation, dependencies, and lifecycle throughout your application

## Data Transfer Object (DTO) Pattern
- widely used design pattern to transfer the data between client and server
1. client creates a DTO object  
2. client will send that DTO object in the HTTP request 
3. server will extract the data object and use the data object
4. server will create a DTO object and send the DTO object in the response of the rest API
5. client and server both can use the DTO object to transfer the data between client and server
- Advantages of DTO pattern:
1. reduces the number of remote calls
2. server can send only the required data to the client - server does not send the whole entity or domain object to the client, so server uses DTO to transfer only the required amount of data to the client

## Thre-layer Architecture
- organises codebase and separates concerns
- promotes modularisation, maintainability and scalability by dividing the application into 3 distinct layers
- **Postman <--> Presentation Layer <--> Service Layer <--> DAO Layer <--> DB**
1. **Presentation Layer** / Model layer / Controller layer / Web layer
2. **Service Layer** 
3. **Data Access Object (DAO) Layer** / Respository layer / Persistence layer

## Spring Dependencies to Use
- **Spring Web (Web)** -  build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container
- **Spring Data JPA (SQL)** - Persist data in SQL stores Java Persistence API using Spring Data and Hibernate
- **MySQL Driver (SQL)** - MySQL JDBC driver
- **Lombok (Dev Tools)** - Java annotation library which helps to reduce boilerplate code

## MySQL Configuration
- create database in MySQL Workbench
- use application.properties file to install the database connection
```properties
spring.application.name=backend
spring.datasource.url=jdbc:mysql://localhost:3306/tms
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
```
- write SQL statements is possible now through the hibernate dialect inclusion. Updates databasse tables automatically using ddl-auto

## ModelMapper
- external library used for converting/mapping between JPA entity and DTO

## Spring Security
- framework that provides authentication, authorisation and protection against common attacks
- first-class support for securing both web and reactive applications - the de-facto standard for securing spring-based applications
- used to secure web applications, REST APIs and microservices 