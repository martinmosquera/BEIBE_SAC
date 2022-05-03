<%-- 
    Document   : error.jsp
    Created on : May 3, 2022, 7:36:51 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BEIBE | Erro</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./assets/css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body class="container mt-5">
        <c:if test="${empty msg or empty page}">
            <jsp:forward page="./index.html"/>
        </c:if>
        <h1>Ops! Tivemos um problema</h1>
        <p>${msg}</p>
        <a class="btn btn-primary" href="${page}">Voltar a página inicial</a>
    </body>
</html>