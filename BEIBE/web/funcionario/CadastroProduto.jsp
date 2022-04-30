<%-- 
    Document   : CadastroProduto
    Created on : 06/03/2022, 16:14:31
    Author     : Emanu
--%>

<%@page import="api.Model.produto.Produto"%>
<%@page import="java.util.List"%>
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
                <th>Remover</th>
              </tr>
              <%
                  ServletContext sc = getServletContext();
                  List<Produto> produtos = (List<Produto>)sc.getAttribute("produtos");
                  for(Produto p : produtos){
                  out.println("<tr><th>"+p.getNome()+"</th>");
                  out.println("<th>"+p.getCategoria().getNome()+"</th>");
                  out.println("<th>"+p.getDescricao()+"</th>");
                  out.println("<th>"+p.getPeso()+" gr </th>");
                  out.println("<td><a href=\"../UpdateProduto\"><button class=\"btn btn-secondary\" type=\"button\" key=\"${produto.getId()}\" >Alterar</button></a></td>");
                  out.println("<td><a href=\"../DeleteProduto\"><button class=\"btn btn-secondary\" type=\"button\" key=\"${produto.getId()}\">Remover</button></a></td></tr>");
                  
                  }
              %>
            
            </table>
        </div>
    </body>
</html>
