const express = require('express');
const router = express.Router();
const db = require('../db');

// Ruta para login
router.post('/login', (req, res) => {
  const { username, password } = req.body;

  const sql = 'SELECT * FROM usuario WHERE nombreUsuario = ? AND contrasena = ?';
  db.query(sql, [username, password], (err, results) => {
    if (err) return res.status(500).send({ error: err });

    if (results.length > 0) {
        const user = results[0];
        res.json({
        success: true,
        user: {
        idUsuario: user.idUsuario,
        nombreUsuario: user.nombreUsuario,
        nombre: user.nombre,
        rol: user.rol
        }
        });
    } else {
        res.json({ success: false, message: 'Credenciales inválidas' });
        }
  });
});

// Ruta para agregar nuevo usuario
router.post('/add', (req, res) => {
  console.log("📥 Datos recibidos:", req.body); // <--- AGREGAR ESTO
  const { nombre, numeroIdentificacion, telefono, correoElectronico, rol } = req.body;
  const nombreUsuario = nombre.toLowerCase().replace(/\s/g, '') + Math.floor(Math.random() * 100);
  const contrasena = Math.random().toString(36).slice(-8);
  const estadoUsuario = 'Activo';

  const sql = `
    INSERT INTO usuario 
    (nombreUsuario, contrasena, rol, nombre, telefono, correoElectronico, numeroIdentificacion, estadoUsuario)
    VALUES (?, ?, ?, ?, ?, ?, ?, ?)
  `;

  db.query(
    sql,
    [nombreUsuario, contrasena, rol, nombre, telefono, correoElectronico, numeroIdentificacion, estadoUsuario],
    (err, result) => {
      if (err) return res.status(500).send({ error: err });

      res.json({
        success: true,
        usuarioCreado: nombreUsuario,
        contrasenaAsignada: contrasena
      });
    }
  );
});

module.exports = router;
