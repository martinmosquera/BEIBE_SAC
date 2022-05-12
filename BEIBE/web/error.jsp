<%-- 
    Document   : error
    Created on : 12 de mai de 2022, 01:08:55
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BEIBE | Erro</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${url}/assets/css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body class="container mt-5">
        <h1>Ops! Tivemos um problema</h1>
        <p>${msg}</p>
        <p>${pageContext.exception}</p>
        <a class="btn btn-primary" href="${url}/ClienteServlet?to=homeP">Voltar a página inicial</a>
        <footer class="bg-light text-center text-lg-start bottom-0 left-0 right-0 w-100 pt-2">
                <p style="margin-left:50px">${config.info}</p>
        </footer>
    </body>
    
</html>

