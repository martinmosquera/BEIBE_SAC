<%-- 
    Document   : PortalUser
    Created on : 8 de mar de 2022, 00:01:44
    Author     : dell
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${user == null}" >
    <c:redirect url="../ClienteServlet?to=login">
        <c:param name="msg" value="Requerido fazer Login para acessar" />
    </c:redirect> 
</c:if>
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
        <link href="${url}/assets/css/style.css" rel="stylesheet" type="text/css">
        
    </head>
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
                <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
                <a href="../ClienteServlet?to=update"><button class="btn btn-light w-100 m-2 ">Alterar Dados</button></a><br/>
                <a href="../ClienteServlet?to=listar"><button class="btn btn-light  w-100 m-2 ">Listar Atendimentos</button></a><br/>
                <a href="../ClienteServlet?to=newForm"><button class="btn btn-light w-100 m-2 ">Criar Atendimento</button></a><br/>
                <a href="../LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <div class="row">
                <h1>Benvind@ ${user.nick}</h1>
            </div>
            <span>${msg}</span>
            <div class="row justify-content-around">
                <div class="d-flex">
                    <div class="flex-2">
                        <h3>Dados Cadastrados</h3>
                        <ul class="list-group">
                            <li class="list-group-item">Nome : ${user.nome}</li>
                            <li class="list-group-item">Email : ${user.email}</li>
                            <li class="list-group-item">CPF : ${user.cpf}</li>
                            <li class="list-group-item">Rua : ${user.rua}</li>
                            <li class="list-group-item">Num : ${user.num}</li>
                            <li class="list-group-item">Complemento : ${user.complemento}</li>
                            <li class="list-group-item">Bairro : ${user.bairro}</li>
                            <li class="list-group-item">CEP : ${user.cep}</li>
                            <li class="list-group-item">Cidade : ${user.cidade}</li>
                            <li class="list-group-item">Estado : ${user.estado}</li>
                            <li class="list-group-item">Telefone : ${user.telefone}</li>

                        </ul>
                    </div>
                </div>
            </div>                 
        </div>
        <footer class="bg-light text-center text-lg-start bottom-0 left-0 right-0 w-100 pt-2">
                <p style="margin-left:50px">${config.info}</p>
        </footer>                            
    </body>
</html>
