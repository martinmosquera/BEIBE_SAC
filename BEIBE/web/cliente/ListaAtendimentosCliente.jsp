<%-- 
    Document   : ListaAtendimentosCliente
    Created on : 06/03/2022, 13:52:35
    Author     : Emanu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atendimentos</title>
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
        <h1>Seus Atendimentos:</h1>
            <table>
              <tr>
                <th>Atendimento</th>
                <th>Data abertura</th>
                <th>Status</th>
                <th>Ver mais</th>
              </tr>
              <tr>
                <td>Atendimento 1</td>
                <td>02-01-2022</td>
                <td>Aberto</td>
                <td><button type="button" onclick="">Mais detalhes</button></td>
              </tr>
              <tr>
                <td>Atendimento 2</td>
                <td>04-03-2022</td>
                <td>Fechado</td>
                <td><button type="button" onclick="">Mais detalhes</button></td>
              </tr>
              <tr>
                <td>Atendimento 3</td>
                <td>06-03-2022</td>
                <td>Aberto</td>
                <td><button type="button" onclick="">Mais detalhes</button></td>
              </tr>
            </table>
        </div>
    </body>
</html>
