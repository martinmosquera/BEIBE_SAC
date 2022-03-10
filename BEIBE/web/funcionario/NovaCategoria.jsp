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
        <title>Nova Categoria</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
                <a href="PortalFuncionario.jsp">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
                </a>
                <a href="TodosAtendimentosFuncionario.jsp"><button class="btn btn-light">Listar Todos</button></a><br/>
                <a href="CadastroCategorias.jsp"><button class="btn btn-light">Gerenciar Categorias</button></a><br/>
                <a href="CadastroProduto.jsp"><button class="btn btn-light">Gerenciar Produtos</button></a><br/>
                <a href="../LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <h1>Nova Categoria</h1>
                <form class="col-8 form-group" method="post" action="../CreateCategoria">
                    <div class="form-group mb-2">
                        <label for="nick">Nome:</label>
                        <input class="form-control" type="text" name="nick" placeholder="Nome categoria">
                    </div>
                    <div class="form-group mb-2">
                        <input type="submit" value="Adicionar" class="btn btn-primary" >
                    </div>
                </form>
        </div>
    </body>
</html>
