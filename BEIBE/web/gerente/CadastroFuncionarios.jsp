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
        <title>Cadastrar Funcionarios</title>
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
                <a href="TodosAtendimentosGerente.jsp"><button class="btn btn-light">Listar Todos</button></a><br/>
                <a href="CadastroFuncionarios.jsp"><button class="btn btn-light">Gerenciar funcionários</button></a><br/>
                <a href="Relatorios.jsp"><button class="btn btn-light">Relatórios</button></a><br/>
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
                <th>Alterar</th>
                <th>Vizualizar</th>
                <th>Remover</th>
              </tr>
              <tr>
                <td>João Silva</td>
                <td>Funcionário</td>
                <td><button class="btn btn-secondary" type="button" onclick="">Alterar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Vizualizar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Remover</button></td>
              </tr>
              <tr>
                <td>João Silva</td>
                <td>Gerente</td>
                <td><button class="btn btn-secondary" type="button" onclick="">Alterar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Vizualizar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Remover</button></td>
              </tr>
              <tr>
                <td>João Silva</td>
                <td>Funcionário</td>
                <td><button class="btn btn-secondary" type="button" onclick="">Alterar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Vizualizar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Remover</button></td>
              </tr>
              <tr>
                <td>João Silva</td>
                <td>Gerente</td>
                <td><button class="btn btn-secondary" type="button" onclick="">Alterar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Vizualizar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Remover</button></td>
              </tr>
            </table>
        </div>
    </body>
</html>