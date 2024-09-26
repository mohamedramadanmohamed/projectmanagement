# Project Management API

This is a Spring Boot project for managing JWT authentication and project-related operations. The application uses Spring Security for JWT-based authentication and authorization.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [JWT Configuration](#jwt-configuration)
- [Handling JWT Errors](#handling-jwt-errors)
- [Endpoints](#endpoints)
- [Testing](#testing)

## Prerequisites

- Java 17+
- Maven 3.8+
- Spring Boot 3.3.4
- H2 DB (for data storage)

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/mohamedramadanmohamed/projectmanagement.git
   cd projectmanagement```

2. Install dependencies:
	```mvn clean install```

## handling-jwt-errors
JWT secret configuration can be added in the application.yml file:
	```jwt:
		secret: your-256-bit-secret
		expiration: 3600000  # 1 hour in milliseconds```

## running-the-application
Run the application:
	```mvn spring-boot:run
	The application will be running at http://localhost:8080.```

## project-structure

Project Structure
	```
	projectmanagement/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── opteam/
│   │   │           └── projectmanagement/
│   │   │               ├── controllers/
						├── models/
│   │   │               ├── repositories/
│   │   │               ├── services/
│   │   │               └── security/
						└── utils/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── opteam/
│       │           └── projectmanagement/
│       │               ├── controllers/
│       │               │   └── ProjectControllerTest.java
│       │               ├── models/
│       │               └── services/
						└── repository/
│       └── resources/
├── pom.xml
├── README.md```



## Endpoints

### Project Endpoints

#### 1. Create a New Project
- **URL:** `/projects`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "projectName": "Project Name",
    "description": "Description",
    "startDate": "YYYY-MM-DD",
    "endDate": "YYYY-MM-DD",
    "budget": 1000.0,
    "owner": "Owner Name",
    "status": "In Progress"
  }

2. Get All Projects
URL: /projects
Method: GET
3. Get a Project by ID
URL: /projects/{id}
Method: GET
4. Update a Project
URL: /projects/{id}
Method: PUT
Request Body:

{
  "projectName": "Updated Project Name",
  "description": "Updated Description",
  "startDate": "YYYY-MM-DD",
  "endDate": "YYYY-MM-DD",
  "budget": 1500.0,
  "owner": "Updated Owner Name",
  "status": "Completed"
}

5. Delete a Project
URL: /projects/{id}
Method: DELETE
Task Endpoints
1. Create a New Task
URL: /tasks
Method: POST

Request Body:

{
  "taskName": "Task Name",
  "description": "Description",
  "assignedTo": "Assigned User",
  "startDate": "YYYY-MM-DD",
  "endDate": "YYYY-MM-DD",
  "priority": "High",
  "status": "Pending",
  "project": {
    "projectId": 1
  }
}

2. Get All Tasks
URL: /tasks
Method: GET
3. Get a Task by ID
URL: /tasks/{id}
Method: GET
4. Update a Task
URL: /tasks/{id}
Method: PUT

{
  "taskName": "Updated Task Name",
  "description": "Updated Description",
  "assignedTo": "Updated User",
  "startDate": "YYYY-MM-DD",
  "endDate": "YYYY-MM-DD",
  "priority": "Medium",
  "status": "Completed"
}

5. Delete a Task
URL: /tasks/{id}
Method: DELETE
User Endpoints
1. Create a New User
URL: /users
Method: POST

Request Body:

{
  "username": "NewUser",
  "password": "UserPassword",
  "role": "EMPLOYEE"
}

2. Get All Users
URL: /users
Method: GET
3. Get a User by ID
URL: /users/{id}
Method: GET
4. Update a User
URL: /users/{id}
Method: PUT

Request Body:

{
  "username": "UpdatedUser",
  "password": "UpdatedPassword",
  "role": "MANAGER"
}

5. Delete a User
URL: /users/{id}
Method: DELETE```

## testing

Running Tests
To execute the test suite, run the following command in the terminal:

mvn test

Checking Test Coverage
To check test coverage, you can use a plugin like JaCoCo. Ensure you have the JaCoCo Maven plugin configured in your pom.xml, then run:
mvn clean test
