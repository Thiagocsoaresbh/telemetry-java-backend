# FleetView Backend

A robust, real-time backend service for vehicle tracking and fleet management, built with Java Spring Boot and PostgreSQL.

## Overview

FleetView Backend provides the server-side foundation for the FleetView Live Tracker application. It offers RESTful APIs, WebSocket endpoints for real-time telemetry, and database integration for persistent vehicle and status data.

This backend is designed to integrate seamlessly with the React frontend, delivering low-latency updates and reliable data storage for fleet analytics.

## Technology Stack
### Backend

- Java 17 - Modern, stable JVM platform (LTS)
- Spring Boot 3.4 - Framework for REST APIs and dependency injection
- Spring Data JPA - Simplified ORM for database operations
- Spring WebSocket - Real-time communication channel
- PostgreSQL - Relational database for persistent storage
- H2 Database - In-memory database for local development and testing
- Lombok - Reduces boilerplate in Java classes
- Maven - Project and dependency management

### Infrastructure
- Docker Compose (optional) - Orchestration for backend and database containers

## Key Features

### RESTful API
Endpoints for managing vehicles, retrieving fleet data, and integrating telemetry information.

### Real-Time WebSocket
Broadcasts vehicle updates and events to connected frontend clients instantly.

### Database Integration
Uses PostgreSQL for production storage and H2 for development mode.

### Scalable Architecture
Built on Spring Boot with modular layers (Controller, Service, Repository).

### Cross-Origin Support
Preconfigured CORS for integration with the frontend running on localhost.

## Prerequisites

- Java 17 or higher
- Maven 3.9+
- PostgreSQL (local or cloud instance)
- Git

## Installation
### Clone the repository
git clone https://github.com/Thiagocsoaresbh/fleetview-backend.git
cd fleetview-backend

### Build the project
mvn clean install

### Run the server
mvn spring-boot:run


**The backend will be available at http://localhost:8000**

### Configuration
#### Database Configuration

Edit **src/main/resources/application.properties:**

spring.application.name=FleetView Backend
server.port=8000

## PostgreSQL

* spring.datasource.url=jdbc:postgresql://localhost:5432/fleetview
* spring.datasource.username=postgres
* spring.datasource.password=fleetpass
* spring.datasource.driver-class-name=org.postgresql.Driver
* spring.jpa.hibernate.ddl-auto=update
* spring.jpa.show-sql=true
* spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

## CORS
cors.allowed-origins=http://localhost:8080,http://localhost:5173

## WebSocket
websocket.endpoint=/ws
websocket.allowed-origins=http://localhost:8080,http://localhost:5173

* To create the database manually in PostgreSQL:

```
CREATE DATABASE fleetview;
CREATE USER fleetuser WITH PASSWORD 'fleetpass';
GRANT ALL PRIVILEGES ON DATABASE fleetview TO fleetuser;
```

## H2 (In-Memory) for Local Testing

To use H2 instead of PostgreSQL, comment out the PostgreSQL section and uncomment:

```
spring.datasource.url=jdbc:h2:mem:fleetview
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

## Project Structure

```
fleetview-backend/
├── src/
│   ├── main/
│   │   ├── java/com/fleetview/fleetview_backend/
│   │   │   ├── controller/       # REST controllers
│   │   │   ├── model/            # Entities and enums
│   │   │   ├── repository/       # JPA repositories
│   │   │   ├── service/          # Business logic
│   │   │   └── FleetviewBackendApplication.java  # Main entry point
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
├── pom.xml
└── README.md
```

#### API Endpoints

- Endpoint	| Method	| Description

``` bash
/api/vehicles	| *GET*	    | *Retrieve all vehicles*

/api/vehicles	| *POST*    | *Create a new vehicle*

/api/test	    | *GET*	    | *Verify server status*
```

* Example request (POST):

```
POST /api/vehicles
{
  "plate": "ABC-1234",
  "alias": "Truck 1",
  "model": "Volvo FH",
  "status": "MOVING"
}
```

* Example response:

```
{
  "id": 1,
  "plate": "ABC-1234",
  "alias": "Truck 1",
  "model": "Volvo FH",
  "status": "MOVING"
}
```

## Development
```
# Run in development mode
mvn spring-boot:run

# Rebuild project
mvn clean install

# Run tests
mvn test
```

* Access the running API at:
http://localhost:8000/api/vehicles

## Environment Variables

* For deployment, set:

DB_HOST=localhost
DB_PORT=5432
DB_NAME=fleetview
DB_USER=fleetuser
DB_PASSWORD=fleetpass
SERVER_PORT=8000

# Security Considerations

- Use environment variables for database credentials

- Enable HTTPS in production environments

- Configure CORS to allow only trusted origins

- Sanitize inputs for all POST/PUT endpoints

- Use WSS (WebSocket Secure) for production WebSocket connections

## Troubleshooting

### Database Connection Failed

- Ensure PostgreSQL is running
- Verify credentials in application.properties
- Test connection manually using psql

### Port Already in Use

- Check with sudo lsof -i :8000
- Stop any process occupying the port before running the app

## CORS Error

- Verify that the frontend origin matches allowed origins in properties

# License

MIT License - See LICENSE file for details.

# Contact

## Thiago Soares

- Project: *FleetView Backend*
- Twitter/X: [@thiagocsoares](https://x.com/thiagocsoares)