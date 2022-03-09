<%-- 
    Document   : ListaAtendimentosCliente
    Created on : 06/03/2022, 13:52:35
    Author     : Emanu
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atendimentos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./assets/css/style.css" rel="stylesheet" type="text/css">
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
                
                <a href="PortalUser.jsp">
                 <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
                </a>
                <a href="AlteracaoDadosCliente.jsp"><button class="btn btn-light w-100 m-2 ">Alterar Dados</button></a><br/>
                <a href="ListaAtendimentosCliente.jsp"><button class="btn btn-light  w-100 m-2 ">Listar Atendimentos</button></a><br/>
                <a href="CriacaoAtendimentoCliente.jsp"><button class="btn btn-light w-100 m-2 ">Criar Atendimento</button></a><br/>
                <a href="../LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <h1>Seus Atendimentos:</h1>
            <table>
              <tr>
                <th>Atendimento</th>
                <th>Data abertura</th>
                <th>Tipo</th>
                <th>Status</th>
                <th>Descricao</th>
              </tr>
              <c:forEach items="${atendimentos}" var="atendimento">
                <tr>
                  <th> ${atendimento.getId()} </th>
                  <th> ${atendimento.getDatatime()} </th>
                  <th> ${atendimento.getType()} </th>
                  <th> ${atendimento.getStatus()} </th>
                  <th> ${atendimento.getDescricao()} </th>
                 </tr>
               </c:forEach>
              
            </table>
        <hr>
        </div>
        
    </body>
</html>
