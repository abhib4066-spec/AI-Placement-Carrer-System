# backend - Placement System (Spring Boot + MySQL)

## Prerequisites
- MySQL running
- Create DB: `placement_system`

## Configure
Edit `src/main/resources/application.properties`:
- `spring.datasource.username`
- `spring.datasource.password`

## Run
From `backend/`:
- `mvn clean package`
- `mvn spring-boot:run`

Backend will start at: http://localhost:8080

## API
- POST `/api/students`
- POST `/api/students/{studentId}/eligibility`
- POST `/api/companies`
- POST `/api/placements`
- GET  `/api/analytics/stats`

