# TODO - AI-Enhanced Student Placement System (Maven)

## Step 1: Project scaffold
- Generate a complete Spring Boot (Maven) project structure
- Add core dependencies (Spring Web, Spring Data JPA, MySQL, validation, mail)

## Step 2: Domain model + schema
- Create entities: Student, Company, Skill, Resume, PortfolioProject, Placement, Interview, CodingAssessment, MockInterview
- Add database schema/migrations (Flyway preferred)

## Step 3: Data access layer
- Repositories for all entities

## Step 4: Services (core features)
- GPA eligibility check
- Skill tracking
- Resume upload handling (store path in DB)
- Interview scheduling
- Mock interview + coding assessment workflow
- Placement tracking

## Step 5: Analytics + dashboard
- Aggregate metrics endpoints

## Step 6: Email notifications
- Implement email service + templates

## Step 7: Controllers + API
- REST endpoints for admin/company/student flows

## Step 8: Security (basic)
- Add simple role-based access (optional JWT if required)

## Step 9: Local run instructions
- Provide application.properties examples
- Add sample curl/postman collection

