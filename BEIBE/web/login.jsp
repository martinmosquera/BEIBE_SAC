<%-- 
    Document   : login
    Created on : 5 de mar de 2022, 17:11:42
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>Login</title>
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
                <form class="col-5 form-group" method="post" action="LoginServlet">
                    <div class="form-group">
                        <label for="user">Login</label>
                        <input class="form-control" type="text" name="user" placeholder="Usuario">
                    </div>
                    <div class="form-group">
                        <label for="pass">Password</label>
                        <input class="form-control" type="password" name="pass" placeholder="Senha">
                    </div>
                    <hr>
                    <div class="form-group col-2">
                        <input type="submit" class="form-control btn-primary" value="Entrar">
                    </div>
                </form>
                <a href="cliente/register.jsp">Faz teu Registro</a>
            </div>
        </div>
        <footer class="row justify-content-center">
            <div class="col-2">
                <p >Rua do Embuste, 1313</p>
                <p>Curitiba, PR, 13131-313</p>
                <p>(41) 9 1313-1313</p>
            </div>
        </footer>
    </body>
</html>

