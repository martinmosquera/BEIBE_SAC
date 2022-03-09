<%-- 
    Document   : CadastroProduto
    Created on : 06/03/2022, 16:14:31
    Author     : Emanu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar produto</title>
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
            <h1>Todos os produtos</h1>
                        <table>
              <tr>
                <th>Nome</th>
                <th>Categoria</th>
                <th>Descrição</th>
                <th>Peso</th>
                <th>Alterar</th>
                <th>Vizualizar</th>
                <th>Remover</th>
              </tr>
              <tr>
                <td>Produto1</td>
                <td>Sabonetes</td>
                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut lacinia pharetra tempor. Donec consequat tempor dolor, nec vehicula purus pellentesque sit amet. Vestibulum eget purus gravida, consectetur sapien non, mattis eros. In tortor massa, hendrerit a odio vestibulum, tincidunt finibus nulla. Proin luctus lectus quis diam ornare bibendum.</td>
                <td>120g</td>
                <td><button type="button" onclick="">Alterar</button></td>
                <td><button type="button" onclick="">Vizualizar</button></td>
                <td><button type="button" onclick="">Remover</button></td>
              </tr>
              <tr>
                <td>Produto2</td>
                <td>Maquiagem</td>
                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut lacinia pharetra tempor. Donec consequat tempor dolor, nec vehicula purus pellentesque sit amet. Vestibulum eget purus gravida, consectetur sapien non, mattis eros. In tortor massa, hendrerit a odio vestibulum, tincidunt finibus nulla. Proin luctus lectus quis diam ornare bibendum.</td>
                <td>75g</td>
                <td><button type="button" onclick="">Alterar</button></td>
                <td><button type="button" onclick="">Vizualizar</button></td>
                <td><button type="button" onclick="">Remover</button></td>
              </tr>
              <tr>
                <td>Produto3</td>
                <td>Sabonetes</td>
                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut lacinia pharetra tempor. Donec consequat tempor dolor, nec vehicula purus pellentesque sit amet. Vestibulum eget purus gravida, consectetur sapien non, mattis eros. In tortor massa, hendrerit a odio vestibulum, tincidunt finibus nulla. Proin luctus lectus quis diam ornare bibendum.</td>
                <td>92g</td>
                <td><button type="button" onclick="">Alterar</button></td>
                <td><button type="button" onclick="">Vizualizar</button></td>
                <td><button type="button" onclick="">Remover</button></td>
              </tr>
              <tr>
                <td>Produto4</td>
                <td>Olhos</td>
                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut lacinia pharetra tempor. Donec consequat tempor dolor, nec vehicula purus pellentesque sit amet. Vestibulum eget purus gravida, consectetur sapien non, mattis eros. In tortor massa, hendrerit a odio vestibulum, tincidunt finibus nulla. Proin luctus lectus quis diam ornare bibendum.</td>
                <td>450g</td>
                <td><button type="button" onclick="">Alterar</button></td>
                <td><button type="button" onclick="">Vizualizar</button></td>
                <td><button type="button" onclick="">Remover</button></td>
              </tr>
            </table>
            <form action="NovoProduto.jsp">
                <br><button type="submit">Adicionar novo produto</button>
            </form>
        </div>
    </body>
</html>
