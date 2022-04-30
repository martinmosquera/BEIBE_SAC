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
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
                <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
                <a href="AlteracaoDadosCliente.jsp"><button class="btn btn-light w-100 m-2 ">Alterar Dados</button></a><br/>
                <a href="ListaAtendimentosCliente.jsp"><button class="btn btn-light  w-100 m-2 ">Listar Atendimentos</button></a><br/>
                <a href="CriacaoAtendimentoCliente.jsp"><button class="btn btn-light w-100 m-2 ">Criar Atendimento</button></a><br/>
                <a href="../LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <div class="row">
                <jsp:useBean id="user" class="api.Model.users.Cliente" scope="session" />
                <h1>Benvind@ <jsp:getProperty name="user" property="nick"/></h1>
            </div>
            <span><% request.getAttribute("msg"); %></span>
            <div class="row justify-content-around">
                <div class="d-flex">
                    <div class="flex-2">
                        <h3>Dados Cadastrados</h3>
                        <ul class="list-group">
                            <li class="list-group-item">Nome : <jsp:getProperty name="user" property="nome"/></li>
                            <li class="list-group-item">Email : <jsp:getProperty name="user" property="email"/></li>
                            <li class="list-group-item">CPF : <jsp:getProperty name="user" property="cpf"/></li>
                            <li class="list-group-item">Rua : <jsp:getProperty name="user" property="rua"/></li>
                            <li class="list-group-item">Num : <jsp:getProperty name="user" property="num"/></li>
                            <li class="list-group-item">Complemento : <jsp:getProperty name="user" property="complemento"/></li>
                            <li class="list-group-item">Bairro : <jsp:getProperty name="user" property="bairro"/></li>
                            <li class="list-group-item">CEP : <jsp:getProperty name="user" property="cep"/></li>
                            <li class="list-group-item">Cidade : <jsp:getProperty name="user" property="cidade"/></li>
                            <li class="list-group-item">Estado : <jsp:getProperty name="user" property="estado"/></li>
                            <li class="list-group-item">Telefone : <jsp:getProperty name="user" property="telefone"/></li>

                        </ul>
                    </div>
                </div>
            </div>                 
        </div>
    </body>
</html>
