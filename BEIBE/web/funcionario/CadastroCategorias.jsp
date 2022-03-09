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
        <title>Cadastrar Categorias</title>
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
        <div>
            <h1>Todas as categorias</h1>
            <table>
              <tr>
                <th>Categorias</th>
                <th>Alterar</th>
                <th>Vizualizar</th>
                <th>Remover</th>
              </tr>
              <tr>
                <td>Sabonetes</td>
                <td><button type="button" onclick="">Alterar</button></td>
                <td><button type="button" onclick="">Vizualizar</button></td>
                <td><button type="button" onclick="">Remover</button></td>
              </tr>
              <tr>
                <td>Maquiagem</td>
                <td><button type="button" onclick="">Alterar</button></td>
                <td><button type="button" onclick="">Vizualizar</button></td>
                <td><button type="button" onclick="">Remover</button></td>
              </tr>
              <tr>
                <td>Perfumaria</td>
                <td><button type="button" onclick="">Alterar</button></td>
                <td><button type="button" onclick="">Vizualizar</button></td>
                <td><button type="button" onclick="">Remover</button></td>
              </tr>
              <tr>
                <td>Olhos</td>
                <td><button type="button" onclick="">Alterar</button></td>
                <td><button type="button" onclick="">Vizualizar</button></td>
                <td><button type="button" onclick="">Remover</button></td>
              </tr>
            </table>
            <form action="NovaCategoria.jsp">
                <br><button type="submit">Adicionar nova categoria</button>
            </form>
        </div>
    </body>
</html>
