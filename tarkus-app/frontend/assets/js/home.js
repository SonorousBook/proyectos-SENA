// === FUNCIONES DE UTILIDAD ===

// Genera el calendario dinámicamente
function generarCalendario() {
  const hoy = new Date();
  const year = hoy.getFullYear();
  const month = hoy.getMonth();
  const day = hoy.getDate();

  const diasMes = new Date(year, month + 1, 0).getDate();
  const primerDia = new Date(year, month, 1).getDay();
  const nombresDias = ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'];

  let tabla = '<tr>' + nombresDias.map(d => `<td><b>${d}</b></td>`).join('') + '</tr><tr>';
  let diaContador = 1;

  for (let i = 0; i < primerDia; i++) tabla += '<td></td>';

  for (let i = primerDia; i < 7; i++) {
    const clase = (diaContador === day) ? 'today' : '';
    tabla += `<td class="${clase}">${diaContador}</td>`;
    diaContador++;
  }
  tabla += '</tr>';

  while (diaContador <= diasMes) {
    tabla += '<tr>';
    for (let i = 0; i < 7; i++) {
      if (diaContador > diasMes) {
        tabla += '<td></td>';
      } else {
        const clase = (diaContador === day) ? 'today' : '';
        tabla += `<td class="${clase}">${diaContador}</td>`;
      }
      diaContador++;
    }
    tabla += '</tr>';
  }

  document.getElementById('calendar-title').textContent =
    hoy.toLocaleDateString('es-CO', { month: 'long', year: 'numeric' });

  document.getElementById('calendar-body').innerHTML = tabla;
}

// Cierra sesión limpiando el localStorage
function cerrarSesion() {
  localStorage.clear();
  location.href = 'index.html';
}

// Muestra el modal de agregar usuario
function mostrarModal() {
  document.getElementById('modalAgregarUsuario').classList.remove('hidden');
}

// Oculta el modal y limpia el formulario
function cerrarModal() {
  document.getElementById('modalAgregarUsuario').classList.add('hidden');
  document.getElementById('formAgregarUsuario').reset();
  document.getElementById('respuestaCreacion').textContent = '';
  document.getElementById('btnCopiar').classList.add('hidden');
}

// Copia el mensaje de creación al portapapeles
function copiarContrasena() {
  const texto = document.getElementById('respuestaCreacion').textContent;
  navigator.clipboard.writeText(texto).then(() => {
    alert('Contraseña copiada al portapapeles');
  });
}

// Enviar datos del nuevo usuario al backend
async function crearUsuario(e) {
  e.preventDefault();

  const data = {
    nombre: document.getElementById('nombre').value,
    numeroIdentificacion: document.getElementById('numeroIdentificacion').value,
    telefono: document.getElementById('telefono').value,
    correoElectronico: document.getElementById('correoElectronico').value,
    rol: document.getElementById('rol').value
  };

  try {
    const response = await fetch('http://localhost:3000/api/users/add', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data)
    });

    const result = await response.json();

    if (result.success) {
      document.getElementById('respuestaCreacion').textContent =
        `✅ Usuario creado: ${result.usuarioCreado}, Contraseña: ${result.contrasenaAsignada}`;
      document.getElementById('btnCopiar').classList.remove('hidden');
    } else {
      document.getElementById('respuestaCreacion').textContent =
        `❌ Error: ${result.error || 'No se pudo crear el usuario'}`;
    }
  } catch (err) {
    document.getElementById('respuestaCreacion').textContent =
      `❌ Error en la solicitud: ${err.message}`;
  }
}

// === EVENTOS Y CONFIGURACIÓN INICIAL ===
document.addEventListener('DOMContentLoaded', () => {
  generarCalendario();

  const usuarioData = JSON.parse(localStorage.getItem('usuario'));

  // Verifica si hay datos de usuario en localStorage
  if (usuarioData) {
    document.getElementById('nombreUsuario').textContent = usuarioData.nombre;
    document.getElementById('nombreUsuarioCard').textContent = usuarioData.nombre;
    document.getElementById('rolUsuario').textContent = usuarioData.rol;

    // Deshabilitar botón de crear usuario si no es administrador
    if (usuarioData.rol !== 'Administrador') {
      const btnAgregar = document.getElementById('btnAgregarUsuario');
      btnAgregar.disabled = true;
      btnAgregar.style.opacity = 0.5;
      btnAgregar.style.cursor = 'not-allowed';
    }
  } else {
    // Si no hay sesión, redirige al login
    window.location.href = 'index.html';
    return;
  }

  // Eventos de botones
  document.getElementById('btnAgregarUsuario')?.addEventListener('click', mostrarModal);
  document.getElementById('formAgregarUsuario')?.addEventListener('submit', crearUsuario);
  document.getElementById('btnCancelar')?.addEventListener('click', cerrarModal);
  document.getElementById('btnCerrarSesion')?.addEventListener('click', cerrarSesion);
  document.getElementById('btnCopiar')?.addEventListener('click', copiarContrasena);
});
