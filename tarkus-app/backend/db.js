const mysql = require('mysql2');

const db = mysql.createConnection({
  host: 'localhost',
  port: 3306,
  user: 'root',
  password: 'HALLOWEENf1r3w0rk*',
  database: 'technical_visit'
});

db.connect((err) => {
  if (err) {
    console.error('❌ Error en la conexión a MySQL:', err);
    return;
  }
  console.log('✅ Conexión exitosa a MySQL');
});

module.exports = db;
