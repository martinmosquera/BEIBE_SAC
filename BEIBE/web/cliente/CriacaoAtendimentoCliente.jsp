<%-- 
    Document   : CriacaoAtendimentoCliente
    Created on : 06/03/2022, 14:08:25
    Author     : Emanu
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criação Atendimento</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <jsp:useBean id="user" class="users.Cliente" scope="session" />
        <div class="container">
            <h1>Olá <jsp:getProperty name="user" property="nick" />, crie seu atendimento abaixo:</h1>
            <form action="../CriaAtendimento" method="post">
              <label for="type">Tipo de atendimento:</label><br><br>
               <select id="type" name="type">
                   <option>Reclamação</option>
                   <option>Sugestão</option>
                   <option>Criticas</option>
                   <option>Problemas</option>
               </select>
              <br><br><label for="produto">Selecione o produto:</label><br><br>
               <select id="produto" name="produto">
                    <c:forEach items="${produtos}" var="produto">
                        <option> ${produto.getNome()} </option>
                    </c:forEach>
                   
               </select>
              <br><br><label for="descricao">Descrição atendimento:</label><br><br>
              <textarea name="descricao" rows="10" cols="30"></textarea>
              <br><br><input type="submit" value="CRIAR ATENDIMENTO">
            </form>
            <a href="PortalUser.jsp"><button class="btn-primary">Home</button></a>
        </div>
            
    </body>
</html>
