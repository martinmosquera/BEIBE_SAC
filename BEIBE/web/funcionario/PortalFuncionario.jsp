<%-- 
    Document   : PortalFuncionario
    Created on : 8 de mar de 2022, 00:02:08
    Author     : dell
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="./" target="_self">
        <title>Portal Funcionario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Benvind@ <jsp:getProperty name="user" property="nick"/></h1>
                <div class="col-3">
                    <h3>Menu</h3>
                    <hr>
                    <a href="TodosAtendimentosFuncionario.jsp"><button class="btn-primary">Listar Todos</button></a><br/>
                    <a href="CadastroCategorias.jsp"><button class="btn-primary">Gerenciar Categorias</button></a><br/>
                    <a href="CadastroProduto.jsp"><button class="btn-primary">Gerenciar Produtos</button></a><br/>
                    
                    
                    <a href="../LogoutServlet"><button class="btn-danger">Logout</button></a><br/>
                </div>
            
                <div class="col-8">
                    <h1>Seus Atendimentos Em Aberto:</h1>
                    <table class="table table-striped">
                      <tr>
                        <th>Atendimento</th>
                        <th>Data abertura</th>
                        <th>Tipo</th>
                        <th>Status</th>
                        <th>Descricao</th>
                      </tr>
                      <c:forEach items="${atendimentosAbertos}" var="atendimento">
                        <tr>
                          <th> ${atendimento.getId()} </th>
                          <th> ${atendimento.getDatatime()} </th>
                          <th> ${atendimento.getType()} </th>
                          <th> ${atendimento.getStatus()} </th>
                          <th> ${atendimento.getDescricao()} </th>
                         </tr>
                       </c:forEach>

                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
