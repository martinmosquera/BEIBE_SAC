<%-- 
    Document   : TodosAtendimentosFuncionario
    Created on : 06/03/2022, 15:07:23
    Author     : Emanu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
              background-color: tomato;
            }
        </style> 
    </head>
    <body>
        <div>
            <h1>Todos os atendimentos</h1>
            <p>legenda:</p>
            <p style="background-color:Tomato; max-width: 90px; padding: 4px">ATRASADO</p>
            <p style="background-color:yellow; max-width: 90px; padding: 4px">EM DIA</p>
            <br><table>
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
                <td><button type="button" onclick="">Resolver</button></td>
              </tr>
              <tr style="background-color: yellow">
                <td>Atendimento 2</td>
                <td>04-03-2022</td>
                <td>Aberto</td>
                <td><button type="button" onclick="">Resolver</button></td>
              </tr>
              <tr>
                <td>Atendimento 3</td>
                <td>06-03-2022</td>
                <td>Aberto</td>
                <td><button type="button" onclick="">Resolver</button></td>
              </tr>
              <tr>
                <td>Atendimento 4</td>
                <td>06-03-2022</td>
                <td>Fechado</td>
                <td><button type="button" onclick="">Detalhes</button></td>
              </tr>
            </table>
        </div>
    </body>
</html>
