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
- [Contributing](#contributing)
- [License](#license)

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

3. JWT secret configuration can be added in the application.yml file:
	```jwt:
		secret: your-256-bit-secret
		expiration: 3600000  # 1 hour in milliseconds```

4. Run the application:
	```mvn spring-boot:run
	The application will be running at http://localhost:8080.```


5. Project Structure
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




