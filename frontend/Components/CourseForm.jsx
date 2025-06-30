import React, { useState } from 'react';
import API from '../Services/api';

function CourseForm() {
  const [name, setName] = useState('');
  const [fee, setFee] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await API.post('/courses', { name, fee });
      alert('Course created!');
        setName('');    //after successful creation, reset the form fields
        setFee('');

    } catch (err) {
       console.error(err);
      alert('Error creating course');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input placeholder="Course Name" value={name} onChange={e => setName(e.target.value)} />
      <input placeholder="Fee" value={fee} onChange={e => setFee(e.target.value)} type="number" />
      <button type="submit">Add Course</button>
    </form>
  );
}

export default CourseForm;