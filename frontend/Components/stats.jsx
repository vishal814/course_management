import React, { useEffect, useState } from 'react';
import API from '../Services/api';

function Stats() {
  const [studentStats, setStudentStats] = useState([]);
  const [feeStats, setFeeStats] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchStats = async () => {
      try {
        const [studentsRes, feesRes] = await Promise.all([
          API.get('/enrollments/stats/students'),
          API.get('/enrollments/stats/fees')
        ]);
        setStudentStats(studentsRes.data);
        setFeeStats(feesRes.data);
      } catch (err) {
        console.error("Failed to fetch stats:", err);
      } finally {
        setLoading(false);
      }
    };

    fetchStats();
  }, []);

  if (loading) return <div>Loading statistics...</div>;

  return (
    <div style={{ padding: '1rem' }}>
      <div style={{ marginBottom: '2rem' }}>
        <h2>Course-wise Student Count</h2>
        <ul>
          {studentStats.map((stat, index) => (
            <li key={index}>
              <strong>{stat.courseName}</strong>: {stat.studentCount} students
            </li>
          ))}
        </ul>
      </div>

      <div>
        <h2>Total Fee Collected Per Course</h2>
        <ul>
          {feeStats.map((stat, index) => (
            <li key={index}>
              <strong>{stat.courseName}</strong>: ₹{stat.totalFee}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default Stats;