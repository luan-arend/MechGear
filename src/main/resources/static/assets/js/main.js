document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('loginForm');
    const errorMessage = document.getElementById('errorMessage');
    const loginButton = loginForm.querySelector('button');
  
    loginForm.addEventListener('submit', async (e) => {
      e.preventDefault();
      
      const username = document.getElementById('username').value;
      const password = document.getElementById('password').value;
  
      // Simular loading
      loginButton.classList.add('loading');
      errorMessage.classList.remove('visible');
  
      // Simular uma chamada de API
      await new Promise(resolve => setTimeout(resolve, 1500));
  
      // Simulação de validação (apenas para demonstração)
      if (username === 'admin' && password === '123456') {
        console.log('Login bem-sucedido!');
        // Aqui você pode adicionar a lógica de redirecionamento
      } else {
        errorMessage.textContent = 'Usuário ou senha incorretos';
        errorMessage.classList.add('visible');
      }
  
      loginButton.classList.remove('loading');
    });
  });