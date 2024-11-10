<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Anonymous+Pro:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="./css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div id="login">
    <div class="container text-white">
        <div id="login-row" class="d-flex flex-column align-items-center justify-content-center vh-100">
            <img class="login-logo" src="./images/Component%204.png" alt="Logo Economuito">
            <div id="login-column">
                <div id="login-box" class="col-md-12">
                    <form id="login-form" class="form" action="login" method="post">
                        <h3 class="text-center">Login</h3>
                        <div class="form-group">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="basic-addon13"><i class="bi bi-person-fill"></i></span>
                                </div>
                                <input type="email"  name="email" class="form-control login-input" placeholder="Usuário" aria-label="Usuário">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="basic-addon1"><i class="bi bi-lock-fill"></i></span>
                                </div>
                                <input type="password" name="senha" class="form-control login-input" placeholder="Senha" aria-label="Senha">
                            </div>
                        </div>
                        <div class="d-flex flex-column justify-content-center align-items-center">
                            <input class="btn px-5 text-white" type="submit" value="Login">
                            <a class="link mt-2 text-white" href="./cadastro_usuarios.jsp">Novo Cadastro</a>
                            <c:if test="${not empty erro}">
                                <p style="color:red;">${erro}</p>
                            </c:if>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>