import React, { useState, useEffect } from 'react';
import API from '../Services/api';

function EnrollmentForm() {
  const [students, setStudents] = useState([]);
  const [courses, setCourses] = useState([]);
  const [selectedStudent, setSelectedStudent] = useState('');
  const [selectedCourse, setSelectedCourse] = useState('');

  useEffect(() => {
    API.get('/students')
      .then(res => setStudents(res.data))
      .catch(err => console.error("Failed to fetch students:", err));

    API.get('/courses')
      .then(res => setCourses(res.data))
      .catch(err => console.error("Failed to fetch courses:", err));
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!selectedStudent || !selectedCourse) {
      alert('Please select both a student and a course.');
      return;
    }
    try {
      await API.post('/enrollments', null, {
        params: { studentId: selectedStudent, courseId: selectedCourse }
      });
      alert('Enrollment successful!');
    } catch (err) {
      alert('Enrollment failed.');
      console.error(err);
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ maxWidth: '400px', margin: '0 auto' }}>
      <h3>Enroll a Student</h3>
      
      <div style={{ marginBottom: '1rem' }}>
        <label style={{ display: 'block', marginBottom: '0.5rem' }}>Select Student:</label>
        <select 
          value={selectedStudent} 
          onChange={e => setSelectedStudent(e.target.value)}
          style={{ width: '100%', padding: '0.5rem' }}
        >
          <option value="">-- Select a student --</option>
          {students.map(student => (
            <option key={student.id} value={student.id}>
              {student.name}
            </option>
          ))}
        </select>
      </div>

      <div style={{ marginBottom: '1rem' }}>
        <label style={{ display: 'block', marginBottom: '0.5rem' }}>Select Course:</label>
        <select 
          value={selectedCourse} 
          onChange={e => setSelectedCourse(e.target.value)}
          style={{ width: '100%', padding: '0.5rem' }}
        >
          <option value="">-- Select a course --</option>
          {courses.map(course => (
            <option key={course.id} value={course.id}>
              {course.name} (₹{course.fee})
            </option>
          ))}
        </select>
      </div>

      <button 
        type="submit" 
        style={{
          padding: '0.5rem 1rem',
          backgroundColor: '#4CAF50',
          color: 'white',
          border: 'none',
          borderRadius: '4px',
          cursor: 'pointer'
        }}
      >
        Enroll
      </button>
    </form>
  );
}

export default EnrollmentForm;