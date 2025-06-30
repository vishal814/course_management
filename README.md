# Course Management System
A full-stack web application to manage courses, students, and enrollments, built with *Spring Boot* (Java) for the backend and *React.js* for the frontend. This system also supports **course statistics, and a clean UI with **Tailwind CSS*.

---

## 🔧 Features

### Backend (Spring Boot)
- Add, list, and view courses
- Add and list students
- Enroll students in courses
- Get course-wise:
  - Number of students
  - Total fee collected
- REST APIs using Spring MVC & JPA
- MySQL database integration

  ### Frontend (React)
- View courses
- Add course
- Add student
- Enroll student (dropdowns for student/course)
- View course statistics
- Styled using Tailwind CSS

## Getting Started

###  Backend Setup

1. Clone the repo and open backend folder:
   ```bash
   cd course_management
2. Create a MySQL Database  
CREATE DATABASE course_management;
3 Add DB config in
application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/course_management
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
4 Run the backend
./mvnm spring-boot-run
#### Project Structure
course_management/
├── controllers/
├── models/
├── repositories/
├── services/
├── config/
├── application.properties
└── CourseManagementApplication.java

course-management-frontend/
├── src/
│   ├── components/
│   │   ├── CourseForm.jsx
│   │   ├── StudentForm.jsx
│   │   ├── EnrollmentForm.jsx
│   │   ├── Stats.jsx
│   │   └── CourseDetails.jsx
│   ├── App.js
│   └── api.js
├── tailwind.config.js
└── index.css  


API ENDPOINTS
for managing courses
GET /courses

Fetches a list of all available courses including their names and fees.

POST /courses
Allows the creation of a new course by accepting course name and fee in the request body.
for student 
GET /students
Returns a list of all registered students along with their basic details like name and date of birth.

POST /students
Adds a new student to the system by accepting their name and date of birth in the request body
for Enrollment 
Get /enrollments
returns a list of all student enrollment 
Get /enrollment/stats/students
Return the number of students enrolled in each course as a list of objects containing course name and student count 
Get enrollments/stats/fees
Return the total fee collected per course as a list of course names and corresponding fee totals 
