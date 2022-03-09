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
    <body class="container">
        <div>
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
        <a href="PortalUser.jsp"><button class="btn-primary">Home</button></a>
        </div>
        
    </body>
</html>
