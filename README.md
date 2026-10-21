# Spring Boot 3 + Java 21 + MySQL — CRUD

## Requirements
- JDK 21
- Maven 3.9+
- MySQL 8+ (running on localhost:3306)

## Setup
1. `src/main/resources/application.properties` mein MySQL username/password change karein.
2. Database `crud_db` apne aap ban jayega (`createDatabaseIfNotExist=true`).
   Manual banana ho to: `CREATE DATABASE crud_db;`
3. Run:
   ```
   mvn spring-boot:run
   ```
   Server: http://localhost:8080

## API Endpoints
| Method | URL | Kaam |
|--------|-----|------|
| POST   | /api/employees | Naya employee banao |
| GET    | /api/employees | Sab employees (optional `?department=IT`) |
| GET    | /api/employees/{id} | Ek employee |
| PUT    | /api/employees/{id} | Update |
| DELETE | /api/employees/{id} | Delete |

## curl examples
```bash
# Create
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{"name":"Rahul","email":"rahul@example.com","department":"IT","salary":50000}'

# Get all
curl http://localhost:8080/api/employees

# Get one
curl http://localhost:8080/api/employees/1

# Update
curl -X PUT http://localhost:8080/api/employees/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Rahul Sharma","email":"rahul@example.com","department":"HR","salary":60000}'

# Delete
curl -X DELETE http://localhost:8080/api/employees/1
```
