<%--
  Created by IntelliJ IDEA.
  User: rafae
  Date: 10/11/2024
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastro de Produtos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="./css/style_cadastro_produtos.css"> <!-- Link para o CSS externo -->
</head>
<body>

<!-- Botão para abrir o modal -->
<div class="container d-flex justify-content-center align-items-center min-vh-100">
  <button type="button" class="btn btn-custom" data-bs-toggle="modal" data-bs-target="#produtoModal">
    Cadastrar Produto
  </button>
</div>

<!-- Modal -->
<div class="modal fade" id="produtoModal" tabindex="-1" aria-labelledby="produtoModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content form-container">
      <div class="modal-header">
        <h5 class="modal-title form-title" id="produtoModalLabel">Cadastro de Produto</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form>
          <!-- Campo "Tipo" com seletor com opção oculta -->
          <div class="mb-3">
            <label for="tipo" class="form-label">Tipo</label>
            <select class="form-select" id="tipo">
              <option value="" disabled selected hidden>Selecione uma opção</option>
              <option value="despesas">Despesas</option>
              <option value="receitas">Receitas</option>
              <option value="investimentos">Investimentos</option>
            </select>
          </div>

          <!-- Campo "Item" com limite de caracteres -->
          <div class="mb-3">
            <label for="item" class="form-label">Item</label>
            <input type="text" class="form-control" id="item" placeholder="Digite o nome do item" maxlength="40">
          </div>

          <!-- Campo "Valor" -->
          <div class="mb-3">
            <label for="valor" class="form-label">Valor (R$)</label>
            <input type="number" class="form-control" id="valor" placeholder="Digite o valor do produto" step="0.01">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-custom">Salvar Produto</button>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

