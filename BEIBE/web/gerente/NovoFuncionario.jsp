<%-- 
    Document   : NovoProduto
    Created on : Mar 9, 2022, 7:41:04 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Funcionário</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
                <a href="PortalGerente.jsp">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
                </a>
                <a href="TodosAtendimentosGerente.jsp"><button class="btn btn-light">Listar Todos</button></a><br/>
                <a href="CadastroFuncionarios.jsp"><button class="btn btn-light">Gerenciar funcionários</button></a><br/>
                <a href="Relatorios.jsp"><button class="btn btn-light">Relatórios</button></a><br/>
                <a href="../LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <h1>Novo Funcionário</h1>
                <form class="col-8 form-group" method="post" action="../RegisterServlet">
                    <div class="form-group mb-2">
                        <label for="nick">Nome:</label>
                        <input class="form-control" type="text" name="nick" placeholder="Nome">
                    </div>
                    <div class="form-group mb-2">
                        <label for="peso">Cargo</label>
                        <input class="form-control" type="text" name="peso" placeholder="Cargo">
                    </div>
                    <div class="form-group mb-2">
                        <label for="peso">CPF</label>
                        <input class="form-control" type="text" name="peso" placeholder="CPF">
                    </div>
                   <div class="form-group mb-2">
                        <label for="peso">Email</label>
                        <input class="form-control" type="text" name="peso" placeholder="Email">
                    </div>
                    <div class="form-group mb-2">
                        <a href="CadastroFuncionarios.jsp" class="btn btn-primary" >Adicionar</a>
                    </div>
                </form>
        </div>
    </body>
</html>
