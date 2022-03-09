<%-- 
    Document   : PortalUser
    Created on : 8 de mar de 2022, 00:01:44
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <base href="./" target="_self">
        <title>Portal Usuario</title>
        <link rel="shortcut icon" href="./assets/img/favicon.png"/>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./assets/css/style.css" rel="stylesheet" type="text/css">
        
    </head>
    <body class="container">
        
        <div class="row">
            <jsp:useBean id="user" class="users.Cliente" scope="session" />
            <h1>Benvind@ <jsp:getProperty name="user" property="nick"/></h1>
        </div>
        <span><% request.getAttribute("msg"); %></span>
        <div class="row justify-content-around">
            <div class="col-2">
                <h3>Menu</h3>
                <a href="AlteracaoDadosCliente.jsp"><button class="btn-primary">Alterar Dados</button></a><br/>
                <a href="CriacaoAtendimentoCliente.jsp"><button class="btn-primary">Criar Atendimento</button></a><br/>
                <a href="ListaAtendimentosCliente.jsp"><button class="btn-primary">Listar Atendimentos</button></a><br/>
                <a href="../LogoutServlet"><button class="btn-danger">Logout</button></a><br/>
            </div>
            <div class="col-6">
                <h3>Dados Cadastrados</h3>
                <p>Nome : <jsp:getProperty name="user" property="nome"/></p>
                <p>Email : <jsp:getProperty name="user" property="email"/></p>
                <p>CPF : <jsp:getProperty name="user" property="cpf"/></p>
                <p>Rua : <jsp:getProperty name="user" property="rua"/></p>
                <p>Num : <jsp:getProperty name="user" property="num"/></p>
                <p>Complemento : <jsp:getProperty name="user" property="complemento"/></p>
                <p>Bairro : <jsp:getProperty name="user" property="bairro"/></p>
                <p>CEP : <jsp:getProperty name="user" property="cep"/></p>
                <p>Cidade : <jsp:getProperty name="user" property="cidade"/></p>
                <p>Estado : <jsp:getProperty name="user" property="estado"/></p>
                <p>Telefone : <jsp:getProperty name="user" property="telefone"/></p>

            </div>
        </div>
    </body>
</html>
