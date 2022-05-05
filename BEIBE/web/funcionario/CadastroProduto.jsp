<%-- 
    Document   : CadastroProduto
    Created on : 06/03/2022, 16:14:31
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
        <title>Cadastrar produto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
                <a href="../LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <form action="NovoProduto.jsp">
                <br><a href="NovoProduto.jsp" class="btn btn-primary my-2">Adicionar novo produto</a>
            </form>
            <h1>Todos os produtos</h1>
            <table>
              <tr>
                <th>Nome</th>
                <th>Categoria</th>
                <th>Descrição</th>
                <th>Peso</th>
                <th>Alterar</th>
                <th>Remover</th>
              </tr>
              
             <c:forEach var="p" items="${produtos}">
                  <tr><th>${p.nome}</th>"
                  <th>${p.categoria.nome}</th>
                  <th>${p.descricao}</th>
                  <th>${p.peso}</th>
                  <td><a href=\"../UpdateProduto\"><button class=\"btn btn-secondary\" type=\"button\" key=\"${produto.id}\" >Alterar</button></a></td>
                  <td><a href=\"../DeleteProduto\"><button class=\"btn btn-secondary\" type=\"button\" key=\"${produto.id}\">Remover</button></a></td></tr>
              </c:forEach>
            
            </table>
        </div>
    </body>
    <footer class="bg-light text-center text-lg-start  bottom-0 left-0 right-0 w-100 pt-2">
            <p style="margin-left:50px">${config.info}</p>
        </footer>
</html>
