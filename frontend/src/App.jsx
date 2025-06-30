import { useState } from 'react'
        


import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import CourseForm from '../Components/CourseForm';
import CourseList from '../Components/CourseList';
import EnrollmentForm from '../Components/EnrollmentForm';
import Stats from '../Components/Stats';
import StudentForm from '../Components/studentform';





function App() {
  

  return (
    <>
     <BrowserRouter>
       <nav style={{position: 'fixed',
      top: 0,
      left: 0,
      right: 0,
      backgroundColor: '#f0f0f0',
      padding: '1rem',
      display: 'flex',
      gap: '1rem',
      justifyContent: 'center',
      boxShadow: '0 2px 5px rgba(0,0,0,0.1)',
      zIndex: 1000 }}>

         <Link to="/">Courses</Link>
         <Link to="/add-course">Add Course</Link>
         <Link to="/add-student">Add Student</Link>
       <Link to="/enroll">Enroll Student</Link>
         <Link to="/stats">Stats</Link>
     </nav>

       <Routes>
         <Route path="/" element={<CourseList />} />
         <Route path="/add-course" element={<CourseForm />} />
         <Route path="/add-student" element={<StudentForm />} />
         <Route path="/enroll" element={<EnrollmentForm />} />
         <Route path="/stats" element={<Stats />} />
        
       </Routes>
     </BrowserRouter>

    </>
  )
}

export default App
