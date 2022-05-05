<%-- 
    Document   : CriacaoAtendimentoCliente
    Created on : 06/03/2022, 14:08:25
    Author     : Emanu
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${user == null}" >
    <c:redirect url="ClienteServlet"></c:redirect>
</c:if>
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
                <a href="${url}/ClienteServlet?to=home">
                 <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
                </a>
                <a href="${url}/ClienteServlet?to=update"><button class="btn btn-light w-100 m-2 ">Alterar Dados</button></a><br/>
                <a href="${url}/ClienteServlet?to=listar"><button class="btn btn-light  w-100 m-2 ">Listar Atendimentos</button></a><br/>
                <a href="${url}/ClienteServlet?to=newForm"><button class="btn btn-light w-100 m-2 ">Criar Atendimento</button></a><br/>
                <a href="${url}/LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <h1>Olá ${user.nick}, crie seu atendimento abaixo:</h1>
            <form action="${url}/ClienteServlet?to=newAtendimento" method="post">
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
                        <option> ${produto.nome} </option>
                    </c:forEach>
                   
               </select>
              <label class="my-2" for="descricao">Descrição atendimento:</label><br/>
              <textarea class="form-control" name="descricao" rows="10" cols="30" ></textarea>
              <br><br><input type="submit" class="btn btn-primary" value="CRIAR ATENDIMENTO">
            </form>
        </div>
        <footer class="bg-light text-center text-lg-start bottom-0 left-0 right-0 w-100 pt-2">
                <p style="margin-left:50px">${config.info}</p>
        </footer>
    </body>
</html>
