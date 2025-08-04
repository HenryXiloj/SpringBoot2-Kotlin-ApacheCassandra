# Spring Boot Kotlin Cassandra CRUD API

A RESTful CRUD API built with Spring Boot, Kotlin, and Apache Cassandra for user management operations.

📘 Blog Post: [Spring Boot Kotlin Cassandra CRUD API](http://jarmx.blogspot.com/2021/11/spring-boot-kotlin-cassandra-crud-with.html)

## 🚀 Features

- **Spring Boot 2.5.6** with Kotlin support
- **Apache Cassandra** database integration
- **Spring Data Cassandra** for data access
- **RESTful API** endpoints for CRUD operations
- **Docker** support for Cassandra setup
- **Maven** build system

## 📋 API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/services/ws/users` | Get all users |
| POST | `/services/ws/save` | Create a new user |
| PUT | `/services/ws/update/{email}` | Update user by email |
| DELETE | `/services/ws/delete/{email}` | Delete user by email |

## 🛠 Technology Stack

- **Kotlin**: 1.5.31
- **Java**: 11
- **Spring Boot**: 2.5.6
- **Apache Cassandra**: 4.0.1
- **CQLsh**: 6.0.0
- **Maven**: 3.6.3
- **Docker**: For Cassandra container

## 📁 Project Structure

```
src/
├── main/
│   └── kotlin/
│       └── com/henry/
│           ├── controller/
│           │   └── UserController.kt
│           ├── model/
│           │   └── Users.kt
│           ├── repository/
│           │   └── UserRepository.kt
│           └── services/
│               ├── UserService.kt
│               └── impl/
│                   └── UserServiceImpl.kt
└── resources/
    └── application.yml
```

## 🔧 Prerequisites

- Java 11 or higher
- Maven 3.6+
- Docker (for Cassandra)
- IntelliJ IDEA (recommended)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/HenryXiloj/SpringBoot2-Kotlin-ApacheCassandra.git
cd SpringBoot2-Kotlin-ApacheCassandra
```

### 2. Set up Cassandra with Docker

#### Pull and run Cassandra container:
```bash
docker pull cassandra
docker run --name cassandra -p 127.0.0.1:9042:9042 -p 127.0.0.1:9160:9160 -d cassandra
```

#### Access Cassandra shell:
```bash
docker exec -it cassandra /bin/bash
cqlsh
```

#### Check datacenter name:
```cql
USE system;
SELECT data_center FROM local;
```

### 3. Create Database Schema

```cql
CREATE KEYSPACE test_keyspace WITH replication={'class':'SimpleStrategy', 'replication_factor':1};

USE test_keyspace;

CREATE TABLE users (
    email VARCHAR PRIMARY KEY,
    name VARCHAR,
    age INT
);
```

### 4. Configure Application

The application is configured via `application.yml`:

```yaml
server:
  servlet:
    context-path: /services
  port: 9000

spring:
  data:
    cassandra:
      keyspace-name: test_keyspace
      contact-points: localhost:9042
      local-datacenter: datacenter1
```

### 5. Build and Run

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:9000/services`

## 📝 Usage Examples

### Create a User
```bash
curl -X POST http://localhost:9000/services/ws/save \
  -H "Content-Type: application/json" \
  -d '{
    "email": "john@example.com",
    "name": "John Doe",
    "age": 30
  }'
```

### Get All Users
```bash
curl -X GET http://localhost:9000/services/ws/users
```

### Update a User
```bash
curl -X PUT http://localhost:9000/services/ws/update/john@example.com \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Smith",
    "age": 31
  }'
```

### Delete a User
```bash
curl -X DELETE http://localhost:9000/services/ws/delete/john@example.com
```

## 🏗 Architecture

### Data Model
```kotlin
@Table
data class Users(
    @PrimaryKey
    var email: String,
    var name: String,
    var age: Int
)
```

### Repository Layer
```kotlin
interface UserRepository : CassandraRepository<Users, String> {
    fun findByNameContaining(name: String?): List<Users?>?
}
```

### Service Layer
The service layer provides business logic with operations for:
- Finding all users
- Saving new users
- Updating existing users
- Deleting users
- Searching users by name

### Controller Layer
RESTful endpoints with proper HTTP status codes and CORS support for frontend integration.

## 🔍 Key Features

- **Email as Primary Key**: Uses email as the unique identifier for users
- **CORS Support**: Configured for frontend integration
- **Error Handling**: Proper HTTP status codes
- **Docker Support**: Easy Cassandra setup with Docker
- **Kotlin Data Classes**: Leverages Kotlin's concise syntax
- **Spring Data Integration**: Simplified database operations


## 📚 References

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data Cassandra](https://spring.io/projects/spring-data-cassandra)
- [Kotlin Documentation](https://kotlinlang.org/docs/)
- [Apache Cassandra](https://cassandra.apache.org/)



---

⭐ Star this repository if you found it helpful!
