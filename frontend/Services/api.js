import axios from 'axios';

const API = axios.create({
 baseURL: 'http://localhost:8080',
 headers: {
    'Content-Type': 'application/json',
  }, // Spring Boot backend
});

export default API; 