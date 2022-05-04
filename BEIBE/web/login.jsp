<%-- 
    Document   : login
    Created on : 5 de mar de 2022, 17:11:42
    Author     : dell
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="30" class="d-inline-block align-top" alt="">
            <a href="./" class="navbar-nav">Home</a>
            <a href="sobre.jsp">Sobre</a>
            <a href="login.jsp">Login</a>
        </nav>
        <div class="container">
            <div class="d-flex align-items-center justify-content-center w-100">
                <form class="form-group" method="post" action="LoginServlet">
                    <div class="form-group mb-2">
                        <label for="user">Login</label>
                        <input class="form-control" type="text" name="user" placeholder="Usuario">
                    </div>
                    <div class="form-group mb-2">
                        <label for="pass">Password</label>
                        <input class="form-control" type="password" name="pass" placeholder="Senha">
                    </div>
                    <a href="cliente/register.jsp">Faz teu Registro</a>
                    <hr>
                    <div class="form-group">
                        <input type="submit" class="form-control btn-primary" value="Entrar">
                    </div>
                    <c:if test="${msg != \"\"}" >
                        <div class="text-danger form-group"> ${msg}</div>
                    </c:if>
                </form>
                
            </div>
        </div>
        <footer class="bg-light text-center text-lg-start position-absolute bottom-0 left-0 right-0 w-100 pt-2">
                <p style="margin-left:50px">Rua do Embuste, 1313 - Curitiba, PR, 13131-313 | (41) 9 1313-1313</p>
        </footer>
    </body>
</html>

