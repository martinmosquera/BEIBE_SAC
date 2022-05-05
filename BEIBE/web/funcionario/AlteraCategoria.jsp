<%-- 
    Document   : AlteraCategoria
    Created on : 4 de mai de 2022, 21:26:58
    Author     : dell
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${user == null}" >
    <c:redirect url="${url}ClienteServlet"></c:redirect>
</c:if>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Altera Categoria</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
                <a href="PortalFuncionario.jsp">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
                </a>
                <a href="${url}/FuncionarioServlet?to=listar"><button class="btn btn-light">Listar Todos</button></a><br/>
                <a href="${url}/FuncionarioServlet?to=gCategoria"><button class="btn btn-light">Gerenciar Categorias</button></a><br/>
                <a href="CadastroProduto.jsp"><button class="btn btn-light">Gerenciar Produtos</button></a><br/>
                <a href="${url}/LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <h1>Altera Categoria</h1>
                <form class="col-8 form-group" method="post" action="${url}/FuncionarioServlet?to=updateCat">
                    <div class="form-group mb-2">
                        <label for="nome">Nome:</label>
                        <input hidden="text" value="${categoria.id}" name="id">
                        <input class="form-control" type="text" name="nome" value="${categoria.nome}" required maxlength="100">
                    </div>
                    <div class="form-group mb-2">
                        <input type="submit" value="Atualizarr" class="btn btn-primary" >
                    </div>
                </form>
        </div>
    </body>
</html>
