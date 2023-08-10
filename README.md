# Basic Template Spring Web Application

This application is built using Spring Boot (Java), and it is a basic Spring Web Application where the user can create, retrieve, update, and delete Notes.

## Components

The application consists of the following main components:

- **NoteController:** This controller maps the HTTP requests to the appropriate handler methods.
- **NoteService:** This is the service layer that interacts with the NoteRepository and implements the business logic.
- **NoteRepository:** The data access layer that interacts with the database. (Not shown in the provided code)

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
