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
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
                <a href="PortalUser.jsp">
                 <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
                </a>
                <a href="AlteracaoDadosCliente.jsp"><button class="btn btn-light w-100 m-2 ">Alterar Dados</button></a><br/>
                <a href="ListaAtendimentosCliente.jsp"><button class="btn btn-light  w-100 m-2 ">Listar Atendimentos</button></a><br/>
                <a href="CriacaoAtendimentoCliente.jsp"><button class="btn btn-light w-100 m-2 ">Criar Atendimento</button></a><br/>
                <a href="../LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <jsp:useBean id="user" class="users.Cliente" scope="session" />
        <div class="container">
            <h1>Olá <jsp:getProperty name="user" property="nick" />, crie seu atendimento abaixo:</h1>
            <form action="../CriaAtendimento" method="post">
              <label for="type">Tipo de atendimento:</label><br><br>
               <select  class="form-select" id="type" name="type">
                   <option>Reclamação</option>
                   <option>Sugestão</option>
                   <option>Criticas</option>
                   <option>Problemas</option>
               </select>
              <label class="my-2" for="produto">Selecione o produto:</label></br>
              <select class="form-select" id="produto" name="produto">
                    <c:forEach items="${produtos}" var="produto">
                        <option> ${produto.getNome()} </option>
                    </c:forEach>
                   
               </select>
              <label class="my-2" for="descricao">Descrição atendimento:</label><br/>
              <textarea class="form-control" name="descricao" rows="10" cols="30"></textarea>
              <br><br><input type="submit" class="btn btn-primary" value="CRIAR ATENDIMENTO">
            </form>
        </div>
            
    </body>
</html>
