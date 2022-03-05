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
        <div class="container">
            <div class="menu row">
                <div>
                    <a href="./">Home</a>
                    <a href="sobre.jsp">Sobre</a>
                    <a href="login.jsp">Login</a>
                </div>
                
            </div>
            <hr>
            <div class="row">
                <form class="col-8 form-group" method="post" action="RegisterServlet">
                    <div class="form-group">
                        <label for="nick">Nick Name:</label>
                        <input class="form-control" type="text" name="nick" placeholder="Nick Name">
                    </div>
                    <div class="form-group">
                        <label for="name">Nome Completo:</label>
                        <input class="form-control" type="text" name="name" placeholder="Nome">
                    </div>
                    <div class="form-group">
                        <label for="cpf">CPF:</label>
                        <input class="form-control" type="text" name="cpf" placeholder="CPF">
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input class="form-control" type="email" name="email" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label for="endereco">Endereço - Rua:</label>
                        <input class="form-control" type="text" name="endereco" placeholder="Rua">
                    </div>
                    <div class="form-group">
                        <label for="num">Numero:</label>
                        <input class="form-control" type="text" name="num" placeholder="Numero">
                    </div>
                    <div class="form-group">
                        <label for="comple">Complemento:</label>
                        <input class="form-control" type="text" name="comple" placeholder="Complemento">
                    </div>
                    <div class="form-group">
                        <label for="bairro">Bairro:</label>
                        <input class="form-control" type="text" name="bairro" placeholder="Bairro">
                    </div>
                    <div class="form-group">
                        <label for="cep">CEP:</label>
                        <input class="form-control" type="text" name="cep" placeholder="CEP">
                    </div>
                    <div class="form-group">
                        <label for="cidade">Cidade:</label>
                        <input class="form-control" type="text" name="cidade" placeholder="Cidade">
                    </div>
                    <div class="form-group">
                        <label for="estado">Estado:</label>
                        <input class="form-control" type="text" name="estado" placeholder="Estado">
                    </div>
                    <div class="form-group">
                        <label for="tel">Telefone:</label>
                        <input class="form-control" type="text" name="tel" placeholder="Telefone">
                    </div>
                    <div class="form-group">
                        <label for="pass">Password</label>
                        <input class="form-control" type="password" name="pass" placeholder="Senha">
                    </div>
                    <hr>
                    <div class="form-group col-2">
                        <input type="submit" class="form-control btn-primary" value="Registrar">
                    </div>
                </form>
            </div>
           
        </div>
        <footer class="row justify-content-center">
            <div class="col-2">
                <p>Rua do Embuste, 1313</p>
                <p>Curitiba, PR, 13131-313</p>
                <p>(41) 9 1313-1313</p>
            </div>
        </footer>
    </body>
</html>

