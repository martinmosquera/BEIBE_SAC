<%-- 
    Document   : CadastroCategorias
    Created on : 06/03/2022, 15:46:06
    Author     : Emanu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>Relatórios</title>
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
            <h1>Emitir relatórios</h1>
            <table>
              <tr>
                <th>Tipo</th>
                <th>Ação</th>
              </tr>
              <tr>
                  <td>Relatório de Funcionários</td>
                <td><a href="${url}/GeraRelatorioServlet"><button class="btn btn-secondary" type="button" onclick="">Emitir</button></a></td>
              </tr>
              <tr>
                <td>Relatório de Produtos Mais Reclamados</td>
                <td><button class="btn btn-secondary" type="button" onclick="">Emitir</button></td>
              </tr>
              <tr>
                <td>Relatório de Atendmientos em Aberto por Data</td>
                <td><a href="${url}/GeraRelatorioServletData"><button class="btn btn-secondary" type="button" onclick="">Emitir</button></a></td>
              
              <tr>
                <td>Relatório de Reclamações</td>
                <td><button class="btn btn-secondary" type="button" onclick="">Emitir</button></td>
              </tr>
            </table>
        </div>
    </body>
</html>
