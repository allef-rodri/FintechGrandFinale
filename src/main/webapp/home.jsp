<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Anonymous+Pro:ital,wght@0,400;0,700;1,400;1,700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="./css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="d-flex flex-column min-vh-100 flex-fill">
    <nav class="navbar bg-primary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img class=" btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample"
                     src="./images/Frame%202.svg" alt="Logo" width="30" height="24"
                     class="d-inline-block align-text-top">
            </a>
            <img src="./images/home.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
            <img src="./images/Ellipse%205.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
        </div>
        <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample"
             aria-labelledby="offcanvasExampleLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasExampleLabel">Offcanvas</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <div>
                    Some text as placeholder. In real life you can have the elements you have chosen. Like, text,
                    images, lists, etc.
                </div>
                <div class="dropdown mt-3">
                    <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown">
                        Dropdown button
                    </button>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="logout">Sair</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
    <!-- Conteúdo principal da página -->
    <div class="conteudo d-flex align-items-center flex-column px-3 mt-5">
        <h2>Valor economizado</h2>
        <h2 class="valor-economizado mt-3">R$: ****</h2>
        <p>Este é o conteúdo da página. Se o conteúdo for pequeno, o rodapé ficará no fundo da tela.</p>
        <p>Adicione mais conteúdo aqui para testar o comportamento do rodapé.</p>
    </div>

    <!-- Rodapé -->
    <footer class="bg-primary text-center py-1 mt-auto">
        <p>
            <img src="./images/Component%204.png" alt="">
        </p>
    </footer>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>