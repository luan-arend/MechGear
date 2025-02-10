document.addEventListener('DOMContentLoaded', function() {
  const loginForm = document.getElementById('loginForm');
  const errorMessage = document.getElementById('errorMessage');
  const loginButton = loginForm.querySelector('button');

  loginForm.addEventListener('submit', async (e) => {
      e.preventDefault();

      const username = document.getElementById('username').value;
      const password = document.getElementById('password').value;

      const dadosLogin = {
        username: username,
        password: password
    };

      // Simular loading
      loginButton.classList.add('loading');
      errorMessage.classList.remove('visible');

      try {
          // Chamada à API do backend
          const response = await fetch('http://localhost:8080/login', {
              method: 'POST',
              headers: {
                  'Content-Type': 'application/json',
              },
              body: JSON.stringify(dadosLogin),
          });

          const data = await response.json();

          if (response.ok) {
              // Login bem-sucedido
              console.log('Login bem-sucedido!', data);

              // Armazenar o token no localStorage
              localStorage.setItem('token', data.token);

              // Redirecionar para a página principal
              window.location.href = '/dashboard'; // Altere para a URL desejada
          } else {
              // Exibir mensagem de erro
              errorMessage.textContent = data.error || 'Erro ao fazer login';
              errorMessage.classList.add('visible');
          }
      } catch (error) {
          console.error('Erro na requisição:', error);
          errorMessage.textContent = 'Erro ao conectar ao servidor';
          errorMessage.classList.add('visible');
      } finally {
          // Remover loading
          loginButton.classList.remove('loading');
      }
  });
});