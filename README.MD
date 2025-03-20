# Auth-Service

Auth Service is a microservice for authentication and authorization using **JWT (JSON Web Tokens)** in a Spring Boot application. It provides user login, registration, and token validation features.

## Features

- User authentication via JWT
- Stateless authentication with Spring Security
- Password hashing with BCrypt
- Token validation in secured endpoints

## Technologies Used

- **Spring Boot** - Application framework
- **Spring Security** - Security configuration
- **JWT (io.jsonwebtoken)** - Token-based authentication
- **Gradle Kotlin DSL** - Build automation
- **Kotlin** - Application language
- **BCrypt** - Password hashing

## Installation

### 1.Prerequisites

- JDK 17+
- Gradle
- SpringBoot

## API Endpoints
### Authentication
- Login  
**Request Body:**  
```json
{
  "username": "user",
  "password": "password"
}
```
**Response Body:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

## Secured Endpoints

Use the JWT token in the Authorization header: Authorization Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...

## Security Configuration

- CSRF protection is disabled
```kotlin
(.csrf { it.disable() })
```  
- Stateless session management
```kotlin
(.sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) })
```
- JWT authentication filter is applied before the 
```kotlin
UsernamePasswordAuthenticationFilter
```
