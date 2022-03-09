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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
            <form action="NovoProduto.jsp">
                <br><a href="NovoProduto.jsp" class="btn btn-primary my-2">Adicionar novo produto</a>
            </form>
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
                <td><button class="btn btn-secondary" type="button" onclick="">Alterar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Vizualizar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Remover</button></td>
              </tr>
              <tr>
                <td>Produto2</td>
                <td>Maquiagem</td>
                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut lacinia pharetra tempor. Donec consequat tempor dolor, nec vehicula purus pellentesque sit amet. Vestibulum eget purus gravida, consectetur sapien non, mattis eros. In tortor massa, hendrerit a odio vestibulum, tincidunt finibus nulla. Proin luctus lectus quis diam ornare bibendum.</td>
                <td>75g</td>
                <td><button class="btn btn-secondary" type="button" onclick="">Alterar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Vizualizar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Remover</button></td>
              </tr>
              <tr>
                <td>Produto3</td>
                <td>Sabonetes</td>
                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut lacinia pharetra tempor. Donec consequat tempor dolor, nec vehicula purus pellentesque sit amet. Vestibulum eget purus gravida, consectetur sapien non, mattis eros. In tortor massa, hendrerit a odio vestibulum, tincidunt finibus nulla. Proin luctus lectus quis diam ornare bibendum.</td>
                <td>92g</td>
                <td><button class="btn btn-secondary" class="btn btn-secondary" type="button" onclick="">Alterar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Vizualizar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Remover</button></td>
              </tr>
              <tr>
                <td>Produto4</td>
                <td>Olhos</td>
                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut lacinia pharetra tempor. Donec consequat tempor dolor, nec vehicula purus pellentesque sit amet. Vestibulum eget purus gravida, consectetur sapien non, mattis eros. In tortor massa, hendrerit a odio vestibulum, tincidunt finibus nulla. Proin luctus lectus quis diam ornare bibendum.</td>
                <td>450g</td>
                <td><button class="btn btn-secondary" type="button" onclick="">Alterar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Vizualizar</button></td>
                <td><button class="btn btn-secondary" type="button" onclick="">Remover</button></td>
              </tr>
            </table>
        </div>
    </body>
</html>
