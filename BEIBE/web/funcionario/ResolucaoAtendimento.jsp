<%-- 
    Document   : ResolucaoAtendimento
    Created on : 06/03/2022, 15:15:28
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
        <title>Resolução Atendimento</title>
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
            <a href="CadastroCategorias.jsp"><button class="btn btn-light">Gerenciar Categorias</button></a><br/>
            <a href="CadastroProduto.jsp"><button class="btn btn-light">Gerenciar Produtos</button></a><br/>
            <a href="${url}/LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <h1>Todos os atendimentos</h1>
        <div>
            <h1>Atendimento ${atendimento.id} </h1>
            <table>
                <tr>
                    <th>Inicio: ${atendimento.datatime}  | Fim ${atendimento.datatimef}</th>
                    <th>${atendimento.cliente.nome}</th>
                    <th></th>
                </tr>
                <tr>                    
                    <td>${atendimento.status}</td>
                </tr>
            </table>
            <table>
                <tr>
                    <th>${atendimento.produto.nome}</th>
                    <th>${atendimento.type}</th>
                </tr>
            </table>
            <table>
                <tr>
                    <th>Descrição Atendimento</th>
                </tr>
                <tr>
                    <td>L${atendimento.descricao}</td>
                </tr>
            </table>
            <h2>Resolução:</h2>
            <p>Descrição da resolução do atendimento:</p>
            <form action="${url}/FuncionarioServlet?to=resolve&id=${atendimento.id}" method="post">
                <textarea name="mensagem" rows="10" cols="30"></textarea>
                <br><br><input type="submit" value="ENCERRAR ATENDIMENTO">
            </form>
        </div>
    </body>
</html>
