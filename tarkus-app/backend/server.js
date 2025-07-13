const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const db = require('./db');
const usersRoutes = require('./routes/users');
const path = require('path');

const app = express();
const PORT = 3000;

// Middleware
app.use(cors());
app.use(bodyParser.json());

// Rutas de API
app.use('/api/users', usersRoutes);

// Servir frontend desde carpeta frontend
app.use(express.static(path.join(__dirname, '..', 'frontend')));

app.listen(PORT, () => {
  console.log(`🚀 Servidor backend corriendo en http://localhost:${PORT}`);
});
