<%--
  Created by IntelliJ IDEA.
  User: rafae
  Date: 09/11/2024
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastro de Usuário</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="./css/style_cadastro.css">
</head>
<body>

<div class="container d-flex justify-content-center align-items-center min-vh-100">
  <div class="col-md-6 form-container d-flex flex-column justify-content-center align-items-center">
    <h2 class="text-center form-title">Cadastro de Usuário</h2>
    <form action="cadastroUsuario" method="post">
      <div class="mb-3">
        <label for="name" class="form-label">Nome Completo</label>
        <input type="text" name="nome" class="form-control" id="name" placeholder="Digite seu nome completo">
      </div>
      <div class="mb-3">
        <label for="email" class="form-label">E-mail</label>
        <input type="email" name="email" class="form-control" id="email" placeholder="Digite seu e-mail">
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">Senha</label>
        <input type="password" name="senha" class="form-control" id="password" placeholder="Crie uma senha">
      </div>
      <div class="mb-3">
        <label for="confirmPassword" class="form-label">Confirme a Senha</label>
        <input type="password" name="confirmeSenha" class="form-control" id="confirmPassword" placeholder="Confirme sua senha">
      </div>
      <div class="d-grid">
        <button type="submit" class="btn btn-custom">Cadastrar</button>
      </div>
    </form>
    <c:if test="${not empty erro}">
      <p style="color:red;">${erro}</p>
    </c:if>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

