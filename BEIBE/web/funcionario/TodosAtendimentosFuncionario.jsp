<%-- 
    Document   : TodosAtendimentosFuncionario
    Created on : 06/03/2022, 15:07:23
    Author     : Emanu
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>Todos Atendimentos</title>
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
              tr:nth-child(even){
              background-color: #DCECE2;
            }
        </style> 
    </head>
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
            <a href="PortalFuncionario.jsp">
               <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
            </a>
            <a href="TodosAtendimentosFuncionario.jsp"><button class="btn btn-light">Listar Todos</button></a><br/>
            <a href="CadastroCategorias.jsp"><button class="btn btn-light">Gerenciar Categorias</button></a><br/>
            <a href="../CadastroProduto.jsp"><button class="btn btn-light">Gerenciar Produtos</button></a><br/>
            <a href="../LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <h1>Todos os atendimentos</h1>
           
            <br><table>
              <tr>
                <th>#ID</th>
                <th>DATA</th>
                <th>TIPO</th>
                <th>STATUS</th>
                <th>DESCRIÇÃO</th>
                <th> OPÇÃO </th>
              </tr>
               <c:forEach items="${atendimentosTotal}" var="atendimento">
                <tr>
                  <th> Atendimento ${atendimento.getId()} </th>
                  <th> ${atendimento.getDatatime()} </th>
                  <th> ${atendimento.getType()} </th>
                  <th> ${atendimento.getStatus()} </th>
                  <th> ${atendimento.getDescricao()} </th>
                  <td><a href="ResolucaoAtendimento.jsp"><button class="btn btn-secondary" type="button">Resolver</button></a></td>
                 </tr>
               </c:forEach>
              
            </table>
        </div>
    </body>
</html>
