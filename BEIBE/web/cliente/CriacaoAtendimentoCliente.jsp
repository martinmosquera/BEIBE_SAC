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
    </head>
    <body>
        <jsp:useBean id="user" class="users.Cliente" scope="session" />
        <div>
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
