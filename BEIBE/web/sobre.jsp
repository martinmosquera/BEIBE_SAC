<%-- 
    Document   : sobre
    Created on : 5 de mar de 2022, 17:08:15
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>Sobre</title>
        <link rel="shortcut icon" href="./assets/img/favicon.png"/>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./assets/css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="30" class="d-inline-block align-top" alt="">
            <a href="ClienteServlet?to=home" class="navbar-nav">Home</a>
            <a href="ClienteServlet?to=sobre">Sobre</a>
            <a href="ClienteServlet?to=login">Login</a>
        </nav>
        <div class="container">
         
            <h1>Beauty Embuste Indústria de Beleza e Estética</h1>
            <p>A BEIBE é uma empresa de Embelezamento Artificial, voltada ao público jovem e adulto que quer fazer a diferença no mundo.</p>
            <p>A Embuste é a marca de beleza preferida dos brasileiros (Fonte: Embuste Estatística, 2018). Todos os nossos produtos tocam sua beleza. É assim que a marca transforma momentos simples em momentos embusteiros há menos de 0 anos.</p>
        </div>
        <footer class="bg-light text-center text-lg-start bottom-0 left-0 right-0 w-100 pt-2">
                <p style="margin-left:50px">${config.info}</p>
        </footer>
    </body>
</html>
