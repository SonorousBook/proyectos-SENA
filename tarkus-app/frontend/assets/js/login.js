const form = document.getElementById('loginForm');
const errorMsg = document.getElementById('loginError');

form.addEventListener('submit', async (e) => {
  e.preventDefault();

  const username = document.getElementById('username').value.trim();
  const password = document.getElementById('password').value.trim();

  try {
    const res = await fetch('http://localhost:3000/api/users/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ username, password })
    });

    const data = await res.json();

    if (data.success) {
      // ✅ Guardar con la misma clave usada en home.html
      localStorage.setItem('usuario', JSON.stringify(data.user));
      // Redirigir al dashboard
      window.location.href = 'home.html';
    } else {
      showError(data.message || '❌ Credenciales inválidas.');
    }
  } catch (err) {
    showError('❌ Error al conectar con el servidor');
  }
});

function showError(msg) {
  errorMsg.textContent = msg;
  errorMsg.classList.remove('hidden');
}
