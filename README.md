# Basic Template Spring Web Application

This application is built using Spring Boot (Java), and it is a basic Spring Web Application where the user can create, retrieve, update, and delete Notes.

## Components

The project follows the MCS (Model-Controller-Service) architecture, which separates the application into three main components:

- **MCS Architecture**:
  - `Model`: Responsible for managing the data and the business logic. In this project, the `Note` model represents the structure of a note.

  - `Controller`: Manages the flow of data between the Model and external requests. In the backend, the `NoteController` handles HTTP requests and interacts with the `NoteService` to process data.

  - `Service`: Contains the "business" logic and acts as an intermediary between the Controller and the Model. In this project, the `NoteService` processes data and communicates with the `NoteRepository`.

## REST API Endpoints

The following REST API endpoints are available in the application:

1. `GET /home` - Retrieves all notes
2. `POST /add` - Creates a new note
3. `GET /{id}` - Fetches a single note by its ID
4. `PUT /{id}` - Modifies the details of a note by its ID
5. `DELETE /{id}` - Deletes a note by its ID

A note in the application has the following attributes:

- **ID:** A unique identifier for the note
- **Title:** The title of the note
- **Content:** The content of the note
- **Tags:** The tags associated with the note
- **Date_Created:** The date when the note was created
- **Last_Modified:** The date when the note was last edited

## MongoDB Configuration

Before running the application, make sure to configure the MongoDB credentials. Rename the `.env.template` file in the src/main/resources directory to `.env` and replace the placeholder values with your actual MongoDB credentials:


*MONGO_Db="`your_database_name`"*

*MONGO_User="`your_username`"*

*MONGO_Pass="`your_password`"*

*MONGO_Cluster="`your_cluster_connection_string`"*

## Running the Application

The project is a standard Maven project. To run it from the command line, type `mvnw` (Windows) or `./mvnw` (Mac & Linux), then open http://localhost:8080 in your browser.
**(Please note that the actual port may vary; refer to the logs in the terminal during runtime for the correct port)**

## Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#web)

## Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
