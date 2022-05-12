<%-- 
    Document   : CadastroCategorias
    Created on : 06/03/2022, 15:46:06
    Author     : Emanu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>Gerenciar funcionários</title>
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
            <form action="NovoFuncionario.jsp">
                <br><button type="submit" class="btn btn-primary my-2">Adicionar novo funcionário</button>
            </form>
            <h1>Todos os Funcionários</h1>
            <table>
              <tr>
                <th>Nome</th>
                <th>Cargo</th>
                <th>Email</th>
                <th>Cpf</th>
                <th>Alterar</th>
                <th>Remover</th>
              </tr>
              
              <c:forEach var="f" items="${funcionarios}">
                <tr>
                  <td>${f.nome}</td>
                  <td>${f.cargo}</td>
                  <td>${f.email}</td>
                  <td>${f.cpf}</td>
                  <td><a class="btn btn-secondary" type="button" href="GerenteServlet?to=editFunc">Alterar</a></td>
                  <td><button class="btn btn-secondary" type="button" onclick="remover(${f.id})">Remover</a></button>
                  <script>
                  function remover(id){
                    if(window.confirm("Você quer realmente deletar esse funcionário?")){
                        window.open("GerenteServlet?to=deleteFunc&id="+id);
                    }  
                  }
                  </script>
                </tr>
              </c:forEach>
            </table>
        </div>
        <footer class="bg-light text-center text-lg-start  bottom-0 left-0 right-0 w-100 pt-2">
            <p style="margin-left:50px">${config.info}</p>
        </footer>
    </body>
</html>
