# StudentHub - Spring Boot + MySQL Web Application

A beginner-friendly Student Management web application with Create, Read, Update and Delete (CRUD) operations.

## Technologies
- Java 17
- Spring Boot 3.4.5
- Spring MVC + Thymeleaf
- Spring Data JPA / Hibernate
- MySQL 8+
- Maven
- HTML and CSS

## Features
- View all students
- Add a student
- Edit student details
- Delete a student
- Form validation
- Duplicate email protection
- Responsive dashboard UI
- Automatic table creation/update through Hibernate

## Requirements
1. JDK 17 or later
2. MySQL Server 8 or later
3. Maven 3.6+ (or use the Maven wrapper if you add one)

## Setup

### 1. Create the database (optional)
Open MySQL Workbench and run:
```sql
CREATE DATABASE student_management;
```
The JDBC URL also has `createDatabaseIfNotExist=true`, so MySQL can create it if the configured user has permission.

### 2. Configure your MySQL password
Open:
`src/main/resources/application.properties`

Change:
```properties
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
```
Use your actual MySQL username and password. Do not commit real credentials to a public repository.

### 3. Run the application
Open a terminal in the folder containing `pom.xml` and run:
```bash
mvn spring-boot:run
```

### 4. Open in your browser
Visit:
http://localhost:8080

## Database table
Hibernate automatically creates/updates the `students` table with:
- id (auto-increment primary key)
- name
- email (unique)
- course

## Troubleshooting
- **Access denied for user**: check the MySQL username and password in `application.properties`.
- **Communications link failure**: make sure the MySQL service is running and port 3306 is available.
- **Unknown database**: create `student_management` in MySQL Workbench, then restart the app.
- **Port 8080 already in use**: change `server.port=8080` to another free port.

For a real deployment, use environment variables for credentials and set `spring.jpa.hibernate.ddl-auto=validate` with managed database migrations.
