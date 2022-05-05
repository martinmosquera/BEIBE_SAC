<%-- 
    Document   : TodosAtendimentosFuncionario
    Created on : 06/03/2022, 15:07:23
    Author     : Emanu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>Todos Atendimentos</title>
        <style>
            table{
              border-collapse: collapse;
              width: 100%;
            }
            td,th{
              border: 1px solid #dddddd;
              text-align: left;
              padding: 8px;
            }
              tr:nth-child(even){
              background-color: #FFCCCC;
            }
        </style> 
    </head>
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
                <a href="PortalGerente.jsp">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
                </a>
                <a href="../LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <h1>Todos os atendimentos</h1>
            <div>
                <p style="background-color:#FFCCCC; max-width: 90px; padding: 4px">ATRASADO</p>
                <p style="background-color:#FFFF99; max-width: 90px; padding: 4px">EM DIA</p>
            </div>
            <br><table>
              <tr>
                <th>Atendimento</th>
                <th>Data abertura</th>
                <th>Status</th>
                <th>Ação</th>
              </tr>
              
              <c:forEach var="a" items="${atendimentos}">
                <tr>
                  <td>${a.descricao}</td>
                  <td><fmt:formatDate value="${a.data}" var="formattedData" pattern="dd/MM/yyyy"/></td>
                  <td>${a.status}</td>
                  <td><a class="btn btn-secondary" type="button" href="">Resolver</a></td>
                </tr>
              </c:forEach>
            </table>
        </div>
    </body>
</html>
