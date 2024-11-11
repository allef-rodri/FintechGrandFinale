<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lexend:wght@100..900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/style.css">
</head>

<body>

<!-- Modal -->
<div class="modal fade" id="produtoModal" tabindex="-1" aria-labelledby="produtoModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content form-container">
            <div class="modal-header">
                <h5 class="modal-title form-title" id="produtoModalLabel">Cadastrar Transação</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="atualizarSaldoConta" method="post">
                    <!-- Campo "Tipo" com seletor com opção oculta -->
                    <div class="mb-3">
                        <label for="tipo" class="form-label">Tipo</label>
                        <select class="form-select" name="tipoTransacao" id="tipo">
                            <option value="" disabled selected hidden>Selecione uma opção</option>
                            <option value="2">Despesas</option>
                            <option value="1">Receitas</option>
                            <option value="3">Investimentos</option>
                        </select>
                    </div>


                    <!-- Campo "Item" com limite de caracteres -->
                    <div class="mb-3">
                        <label for="item" class="form-label">Item</label>
                        <input type="text" name="item" class="form-control" id="item" placeholder="Digite o nome do item"
                               maxlength="40">
                    </div>

                    <!-- Campo "Valor" -->
                    <div class="mb-3">
                        <label for="valor" class="form-label">Valor (R$)</label>
                        <input type="number" name="valor" class="form-control" id="valor" placeholder="Digite o valor do produto"
                               step="0.01">
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <input id="btnSalvar" type="submit" class="btn btn-custom" value="Salvar">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid d-flex flex-column vh-100 p-0">
    <nav class="fixed-top navbar px-4">
        <a href="#">
            <img class="img-menu" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample"
                 src="./images/Frame%202.svg" alt="Logo" width="30" height="24"
                 class="d-inline-block align-text-top">
        </a>
        <img class="img-home" src="./images/home.svg" alt="Logo" width="30" height="24"
             class="d-inline-block align-text-top">
        <img class="img-user" src="./images/Ellipse%205.svg" alt="Logo" width="30" height="24"
             class="d-inline-block align-text-top">
        <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample"
             aria-labelledby="offcanvasExampleLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasExampleLabel">Menu</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <div class="mt-3">
                    <ul class="list-unstyled">
                        <li>
                            <button class="btn btn-primary menu-btn px-5 text-white" data-bs-toggle="modal"
                                    data-bs-target="#produtoModal">Novo Registro
                            </button>
                        </li>
                        <li><a class="mt-4 btn btn-primary menu-btn px-5 text-white" href="logout">Sair</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
    <div class="conteudo-container d-flex flex-column align-items-center text-center">
        <div class="conteudo-header">
            <c:if test="${not empty  conta.getSaldo()}">
                <h4 class="valor-economizado my-5">Saldo R$: ${conta.getSaldo()}</h4>
            </c:if>
            <h5 class="mt-3">Histórico</h5>

            <c:if test="${not empty erro}">
                <p style="color:red;">${erro}</p>
            </c:if>
        </div>
        <div class="container-fluid">
            <div class="table-responsive rounded">
                <c:if test="${not empty transacoes }">
                    <table>
                        <thead>
                        <tr>
                            <th class="py-2">TIPO</th>
                            <th class="py-2">ITEM</th>
                            <th class="py-2">VALOR</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${transacoes}" var="transacao">
                            <tr>
                                <td class="p-2">
                                    <c:choose>
                                        <c:when test="${transacao.getIdTipoTranasacao() == 1}">
                                            Receita
                                        </c:when>
                                        <c:when test="${transacao.getIdTipoTranasacao() == 2}">
                                            Despesa
                                        </c:when>
                                        <c:when test="${transacao.getIdTipoTranasacao() == 3}">
                                            Investimento
                                        </c:when>
                                        <c:otherwise>
                                            ${transacao.getIdTipoTransacao()}
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td class="p-2">${transacao.getDsTransacao()}</td>
                                <td class="p-2">R$${transacao.getValor()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>

                <c:if test="${empty transacoes }">
                    <h1>Não há transações disponíveis.</h1>
                </c:if>
            </div>
        </div>
    </div>
</div>
<footer class="fixed-bottom w-100 py-4 d-flex align-items-center justify-content-center">
    <img class="img-footer" src="./images/Component%204.png" alt="">
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous">
</script>


<script>
    var btnSalver = document.getElementById("btnSalvar");
    btnSalver.addEventListener("click", ()=>{
        btnSalver.setAttribute("disable");
    })
</script>

</body>

</html>