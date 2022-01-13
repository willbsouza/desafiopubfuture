<h2>Desafio PubFuture</h2>

<ul>
    <li>IDE Utilizada: IntelliJ IDEA Community Edition 2021.2.3;</li>
    <li>Projeto Inicial criado com Spring Initializr;</li>
    <li>Depências utilizadas: SpringBoot Web, Data JPA, DevTools, MySQL, H2;</li>
    <li>Perfis Application.properties: Development com H2, Production com MySQL;</li>
    <li>CRUD completo utilizando a arquitetura REST e dividido em camadas: Entities, Controller, Service, Repository;</li>
    <li>Utilizado o Postman para realizar testes dos endpoints e métodos GET, POST, PUT e DELETE;</li>
</ul>
<h3>Endpoint /contas:</h3>

<ol>
    <li>Listar Contas -> Método GET</li>
    <li>Listar uma Conta por ID -> Método GET com @PathVariable /{id}</li>
    <li>Salvar Conta -> Método POST com @RequestBody</li>
    <li>Atualizar Conta -> Método PUT com @PathVariable /{id} e com @RequestBody</li>
    <li>Deletar Conta -> Método DELETE com @PathVariable /{id}</li>
    <li>Transferir Saldo entre Contas -> Método PUT /transferencia com @RequestParam passando os parâmetros idOrigem, idDestino e valor</li>
    <li>Calcular Saldo Total das Contas -> Método GET /total</li>
</ol>

<h3>Endpoint /despesas:</h3>

<ol>
    <li>Listar Despesas -> Método GET</li>
    <li>Listar uma Despesa por ID -> Método GET com @PathVariable /{id}</li>
    <li>Salvar Despesa -> Método POST com @RequestBody</li>
    <li>Atualizar Despesa -> Método PUT com @PathVariable /{id} e com @RequestBody</li>
    <li>Deletar Despesa -> Método DELETE com @PathVariable /{id}</li>
    <li>Calcular Saldo Total das Despesas -> Método GET /total</li>
    <li>Filtrar Despesas por Data -> Método GET /filtrodata com @RequestParam passando os parâmetros dataInicial e dataFinal</li>
    <li>Filtrar Despesas por Tipo -> Método GET /filtrotipo com @RequestParam passando o parâmetro tipoDespesa</li>
</ol>

<h3>Endpoint /receitas:</h3>
<ol>
    <li>Listar Receitas -> Método GET</li>
    <li>Listar uma Receita por ID -> Método GET com @PathVariable /{id}</li>
    <li>Salvar Receita -> Método POST com @RequestBody</li>
    <li>Atualizar Receita -> Método PUT com @PathVariable /{id} e com @RequestBody</li>
    <li>Deletar Receita -> Método DELETE com @PathVariable /{id}</li>
    <li>Calcular Saldo Total das Receitas -> Método GET /total</li>
    <li>Filtrar Receitas por Data -> Método GET /filtrodata com @RequestParam passando os parâmetros dataInicial e dataFinal</li>
    <li>Filtrar Receitas por Tipo -> Método GET /filtrotipo com @RequestParam passando o parâmetro tipoReceita</li>
</ol>
