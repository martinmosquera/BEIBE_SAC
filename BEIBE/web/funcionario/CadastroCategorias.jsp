<%-- 
    Document   : CadastroCategorias
    Created on : 06/03/2022, 15:46:06
    Author     : Emanu
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>Cadastrar Categorias</title>
        <style>
            table{
              border-collapse: collapse;
              width: 100%;
            }
            td,th{
              border: 1px solid #dddddd;
              text-align: left;
              padding: 8px;
            }
        </style>   
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
            <a href="${url}/FuncionarioServlet?to=showNewCat">
                <br><button type="submit" class="btn btn-primary">Adicionar nova categoria</button>
            </a>
            <h1>Todas as categorias</h1>
            <table>
              <tr>
                <th>Nome Categoria</th>
                <th>Alterar</th>
                <th>Remover</th>
              </tr>
              
              <c:forEach var="c" items="${categorias}">
                <tr><th>${c.nome}</th>
                <td><a href="${url}/FuncionarioServlet?to=showFormUC&id=${c.id}"><button class="btn btn-primary" type=\"button\" >Alterar</button></a></td>
                <td><a href="${url}/FuncionarioServlet?to=deleteCat&id=${c.id}"><button class="btn btn-danger" type=\"button\" >Remover</button></a></td></tr>
              </c:forEach>

            </table>
        </div>
    </body>
    <footer class="bg-light text-center text-lg-start  bottom-0 left-0 right-0 w-100 pt-2">
            <p style="margin-left:50px">${config.info}</p>
        </footer>
</html>
