# Working Condition (Frontend + Backend)

## 1) Start MySQL
Create database:
```sql
CREATE DATABASE placement_system;
```

Update credentials in:
- `backend/src/main/resources/application.properties`

## 2) Start Backend
Open a terminal in this folder:
- `.../AI-Enhanced Student Placement.../backend`

Run:
```bat
mvn clean package
mvn spring-boot:run
```
Backend: http://localhost:8080

## 3) Open Frontend
Open file:
- `frontend/index.html`

Frontend calls backend at `/api` (http://localhost:8080/api).

### Quick Test (Browser)
1. Go to **Student** tab
2. Create a student
3. Go to eligibility and check with min CGPA
4. Create a company
5. Add placement
6. Analytics -> Load Stats

