import React, { useEffect, useState } from 'react';
import API from '../Services/api';

function CourseList() {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    API.get('/courses').then(res => setCourses(res.data));
  }, []);

  return (
    <ul>
      {courses.map(course => (
        <li key={course.id}>
          {course.name} - Rs {course.fee}
        </li>
      ))}
    </ul>
  );
}

export default CourseList;