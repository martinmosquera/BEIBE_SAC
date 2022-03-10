<%-- 
    Document   : ResolucaoAtendimento
    Created on : 06/03/2022, 15:15:28
    Author     : Emanu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>Resolução Atendimento</title>
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
            <a href="PortalFuncionario.jsp">
               <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
            </a>
            <a href="TodosAtendimentosFuncionario.jsp"><button class="btn btn-light">Listar Todos</button></a><br/>
            <a href="CadastroCategorias.jsp"><button class="btn btn-light">Gerenciar Categorias</button></a><br/>
            <a href="CadastroProduto.jsp"><button class="btn btn-light">Gerenciar Produtos</button></a><br/>
            <a href="../LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <h1>Todos os atendimentos</h1>
        <div>
            <h1>Atendimento xxxx* </h1>
            <table>
                <tr>
                    <th>Data/hora atendimento</th>
                    <th>Cliente</th>
                    <th>Situação</th>
                </tr>
                <tr>
                    <td>06-03-2022</td>
                    <td>xxxx</td>
                    <td>Aberto</td>
                </tr>
            </table>
            <table>
                <tr>
                    <th>Produto</th>
                    <th>Tipo Atendimento</th>
                </tr>
                <tr>
                    <td>Produto 1</td>
                    <td>Reclamação</td>
                </tr>
            </table>
            <table>
                <tr>
                    <th>Descrição Atendimento</th>
                </tr>
                <tr>
                    <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut lacinia pharetra tempor. Donec consequat tempor dolor, nec vehicula purus pellentesque sit amet. Vestibulum eget purus gravida, consectetur sapien non, mattis eros. In tortor massa, hendrerit a odio vestibulum, tincidunt finibus nulla. Proin luctus lectus quis diam ornare bibendum. Nunc sit amet elit libero. Ut laoreet eget nibh vel mollis. Sed ullamcorper mauris eu nibh rhoncus imperdiet. Integer tincidunt aliquet ante quis cursus. Donec facilisis accumsan arcu elementum semper. Nunc non ligula et tortor tempus ultrices et tempor velit. Pellentesque vitae metus sem.</td>
                </tr>
            </table>
            <h2>Resolução:</h2>
            <p>Descrição da resolução do atendimento:</p>
            <form action="">
                <textarea name="mensagem" rows="10" cols="30"></textarea>
                <br><br><input type="submit" value="ENCERRAR ATENDIMENTO">
            </form>
        </div>
    </body>
</html>
