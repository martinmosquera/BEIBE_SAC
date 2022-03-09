<%-- 
    Document   : PortalFuncionario
    Created on : 8 de mar de 2022, 00:02:08
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Funcionario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div><a href="../LogoutServlet"><button class="btn-danger">Logout</button></a><br/></div>
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
        <a href="PortalFuncionario.jsp"><button class="btn-primary">Home</button></a>
        </div>
    </body>
</html>
