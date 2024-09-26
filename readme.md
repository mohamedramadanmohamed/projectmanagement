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
├── README.md

	```


## Endpoints

### Project Endpoints

#### 1. Create a New Project
- **URL:** `/projects`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "projectName": "Project Name",
    "description": "Project Description",
    "startDate": "YYYY-MM-DD",
    "endDate": "YYYY-MM-DD",
    "budget": 1000.00,
    "owner": "Owner Name",
    "status": "In Progress"
  }```
  
  Response:
201 Created
json
Copy code
{
  "projectId": 1,
  "projectName": "Project Name",
  ...
}
2. Get All Projects
URL: /projects
Method: GET
Response:
200 OK
json
Copy code
[
  {
    "projectId": 1,
    "projectName": "Project Name",
    ...
  },
  ...
]
3. Get a Project by ID
URL: /projects/{id}
Method: GET
Response:
200 OK
json
Copy code
{
  "projectId": 1,
  "projectName": "Project Name",
  ...
}
404 Not Found if project does not exist.
4. Update a Project
URL: /projects/{id}
Method: PUT
Request Body:
json
Copy code
{
  "projectName": "Updated Project Name",
  "description": "Updated Description",
  "startDate": "YYYY-MM-DD",
  "endDate": "YYYY-MM-DD",
  "budget": 2000.00,
  "owner": "Updated Owner Name",
  "status": "Completed"
}
Response:
200 OK if updated successfully.
404 Not Found if project does not exist.
5. Delete a Project
URL: /projects/{id}
Method: DELETE
Response:
204 No Content if deleted successfully.
404 Not Found if project does not exist.
Task Endpoints
6. Create a New Task
URL: /tasks
Method: POST
Request Body:
json
Copy code
{
  "taskName": "Task Name",
  "description": "Task Description",
  "assignedTo": "User Name",
  "startDate": "YYYY-MM-DD",
  "endDate": "YYYY-MM-DD",
  "priority": "High",
  "status": "Open",
  "projectId": 1
}
Response:
201 Created
json
Copy code
{
  "taskId": 1,
  "taskName": "Task Name",
  ...
}
7. Get All Tasks
URL: /tasks
Method: GET
Response:
200 OK
json
Copy code
[
  {
    "taskId": 1,
    "taskName": "Task Name",
    ...
  },
  ...
]
8. Get a Task by ID
URL: /tasks/{id}
Method: GET
Response:
200 OK
json
Copy code
{
  "taskId": 1,
  "taskName": "Task Name",
  ...
}
404 Not Found if task does not exist.
9. Update a Task
URL: /tasks/{id}
Method: PUT
Request Body:
json
Copy code
{
  "taskName": "Updated Task Name",
  "description": "Updated Description",
  "assignedTo": "Updated User Name",
  "startDate": "YYYY-MM-DD",
  "endDate": "YYYY-MM-DD",
  "priority": "Medium",
  "status": "Completed",
  "projectId": 1
}
Response:
200 OK if updated successfully.
404 Not Found if task does not exist.
10. Delete a Task
URL: /tasks/{id}
Method: DELETE
Response:
204 No Content if deleted successfully.
404 Not Found if task does not exist.
User Endpoints
11. Create a New User
URL: /users
Method: POST
Request Body:
json
Copy code
{
  "username": "newuser",
  "password": "password123",
  "role": "MANAGER" // or "EMPLOYEE"
}
Response:
201 Created
json
Copy code
{
  "id": 1,
  "username": "newuser",
  ...
}
12. Get All Users
URL: /users
Method: GET
Response:
200 OK
json
Copy code
[
  {
    "id": 1,
    "username": "newuser",
    ...
  },
  ...
]
13. Get a User by ID
URL: /users/{id}
Method: GET
Response:
200 OK
json
Copy code
{
  "id": 1,
  "username": "newuser",
  ...
}
404 Not Found if user does not exist.
14. Update a User
URL: /users/{id}
Method: PUT
Request Body:
json
Copy code
{
  "username": "updateduser",
  "password": "newpassword123",
  "role": "EMPLOYEE"
}
Response:
200 OK if updated successfully.
404 Not Found if user does not exist.
15. Delete a User
URL: /users/{id}
Method: DELETE
Response:
204 No Content if deleted successfully.
404 Not Found if user does not exist.

