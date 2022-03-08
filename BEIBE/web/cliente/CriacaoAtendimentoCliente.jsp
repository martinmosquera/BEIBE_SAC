<%-- 
    Document   : CriacaoAtendimentoCliente
    Created on : 06/03/2022, 14:08:25
    Author     : Emanu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criação Atendimento</title>       
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./assets/css/style.css" rel="stylesheet" type="text/css">
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
            <form action="CriaAtendimento" method="post">
              <label for="type">Tipo de atendimento:</label><br><br>
               <select id="tipo" name="tipo">
                   <option>Reclamação</option>
                   <option>Sugestão</option>
                   <option>Criticas</option>
                   <option>Problemas</option>
               </select>
              <br><br><label for="produto">Selecione o produto:</label><br><br>
               <select id="produto" name="produto">
                   <option>Produto1</option>
                   <option>Produto2</option>
                   <option>Produto3</option>
                   <option>Produto4</option>
               </select>
              <br><br><label for="fname">Descrição atendimento:</label><br><br>
              <textarea name="mensagem" rows="10" cols="30"></textarea>
              <br><br><input type="submit" value="CRIAR ATENDIMENTO">
            </form>
        </div>
    </body>
</html>
