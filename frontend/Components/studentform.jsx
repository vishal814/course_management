
import React, { useState } from 'react';
import API from '../Services/api';

function StudentForm() {
  const [name, setName] = useState('');
  const [dob, setDob] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await API.post('/students', { name, dob });
      alert('Student created!');
    } catch (err) {
      alert('Error creating student');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input placeholder="Student Name" value={name} onChange={e => setName(e.target.value)} />
      <input type="date" value={dob} onChange={e => setDob(e.target.value)} />
      <button type="submit">Add Student</button>
    </form>
  );
}
export default StudentForm;