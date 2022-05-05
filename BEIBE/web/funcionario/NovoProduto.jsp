<%-- 
    Document   : NovoProduto
    Created on : Mar 9, 2022, 7:41:04 PM
    Author     : lucas
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
        <title>Novo Produto</title>
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
            <h1>Novo Produto</h1>
                <form class="col-8 form-group" method="post" action="../CreateProduto">
                    <div class="form-group mb-2">
                        <label for="nick">Nome:</label>
                        <input class="form-control" type="text" name="nick" placeholder="Nome" required maxlength="100">
                    </div>
                    <div class="form-group mb-2">
                        <label for="category">Categoria:</label>
                        <input class="form-control" type="text" name="category" placeholder="Nome categoria" required maxlength="100">
                    </div>
                    <div class="form-group mb-2">
                        <label for="peso">Peso:</label>
                        <input class="form-control" type="text" name="peso" placeholder="Peso (g)" required maxlength="100">
                    </div>
                    <div class="form-group mb-2">
                        <a href="CadastroProduto.jsp" class="btn btn-primary" >Adicionar</a>
                    </div>
                </form>
        </div>
    </body>
    <footer class="bg-light text-center text-lg-start  bottom-0 left-0 right-0 w-100 pt-2">
            <p style="margin-left:50px">${config.info}</p>
        </footer>
</html>
