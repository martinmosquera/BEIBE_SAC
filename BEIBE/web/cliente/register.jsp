<%-- 
    Document   : register
    Created on : 5 de mar de 2022, 17:20:38
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>Registrar</title>
        <link rel="shortcut icon" href="./assets/img/favicon.png"/>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./assets/css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="30" class="d-inline-block align-top" alt="">
            <a href="../" class="navbar-nav">Home</a>
            <a href="../sobre.jsp">Sobre</a>
            <a href="../login.jsp">Login</a>
        </nav>
        <div class="container mb-4">
            <div class="d-flex align-items-center justify-content-center">
                <form class="col-8 form-group" method="post" action="../RegisterServlet">
                    <div class="form-group mb-2">
                        <label for="nick">Nick Name:</label>
                        <input class="form-control" type="text" name="nick" placeholder="Nick Name">
                    </div>
                    <div class="form-group mb-2">
                        <label for="nome">Nome Completo:</label>
                        <input class="form-control" type="text" name="nome" placeholder="Nome">
                    </div>
                    <div class="form-group mb-2">
                        <label for="cpf">CPF:</label>
                        <input class="form-control" type="text" name="cpf" placeholder="CPF">
                    </div>
                    <div class="form-group mb-2">
                        <label for="email">Email:</label>
                        <input class="form-control" type="email" name="email" placeholder="Email">
                    </div>
                    <div class="form-group mb-2">
                        <label for="rua">Endereço - Rua:</label>
                        <input class="form-control" type="text" name="rua" placeholder="Rua">
                    </div>
                    <div class="form-group mb-2">
                        <label for="num">Numero:</label>
                        <input class="form-control" type="text" name="num" placeholder="Numero">
                    </div>
                    <div class="form-group mb-2">
                        <label for="comple">Complemento:</label>
                        <input class="form-control" type="text" name="comple" placeholder="Complemento">
                    </div>
                    <div class="form-group mb-2">
                        <label for="bairro">Bairro:</label>
                        <input class="form-control" type="text" name="bairro" placeholder="Bairro">
                    </div>
                    <div class="form-group mb-2">
                        <label for="cep">CEP:</label>
                        <input class="form-control" type="text" name="cep" placeholder="CEP">
                    </div>
                    <div class="form-group mb-2">
                        <label for="cidade">Cidade:</label>
                        <input class="form-control" type="text" name="cidade" placeholder="Cidade">
                    </div>
                    <div class="form-group mb-2">
                        <label for="estado">Estado:</label>
                        <input class="form-control" type="text" name="estado" placeholder="Estado">
                    </div>
                    <div class="form-group mb-2">
                        <label for="tel">Telefone:</label>
                        <input class="form-control" type="text" name="tel" placeholder="Telefone">
                    </div>
                    <div class="form-group mb-2">
                        <label for="senha">Password</label>
                        <input class="form-control" type="password" name="senha" placeholder="Senha">
                    </div>
                    <hr>
                    <div class="form-group mb-2 col-2">
                        <input type="submit" class="form-control btn-primary" value="Registrar">
                    </div>
                </form>
            </div>
           
        </div>
    </body>
</html>

