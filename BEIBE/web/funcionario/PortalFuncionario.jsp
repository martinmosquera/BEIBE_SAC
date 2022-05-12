<%-- 
    Document   : PortalFuncionario
    Created on : 8 de mar de 2022, 00:02:08
    Author     : dell
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:if test="${empty user}" >
    <c:redirect url="../ClienteServlet?to=home"></c:redirect>
</c:if>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="${url}" target="_self">
        <title>Portal Funcionario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
                <a href="PortalFuncionario.jsp">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
                </a>
                <a href="${url}/FuncionarioServlet?to=listar"><button class="btn btn-light">Listar Todos</button></a><br/>
                <a href="${url}/FuncionarioServlet?to=gCategoria"><button class="btn btn-light">Gerenciar Categorias</button></a><br/>
                <a href="${url}/funcionario/CadastroProduto.jsp"><button class="btn btn-light">Gerenciar Produtos</button></a><br/>
                <a href="${url}/LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <div class="row">
                <h1>Benvind@ ${sessionScope.user.nick}</h1>
                <div class="col-8">
                    <h1>Seus Atendimentos em Aberto:</h1>
                    <table class="table table-striped">
                      <tr>
                        <th>Atendimento</th>
                        <th>Data abertura</th>
                        <th>Tipo</th>
                        <th>Status</th>
                        <th>Descricao</th>
                      </tr>
                      <c:forEach items="${sessionScope.atendimentosTotal}" var="atendimento">
                          <c:if test="${atendimento.funcionario.id == sessionScope.user.id}" >
                              <c:if test="${atendimento.status == \"Aberto\"}" >
                                  <tr>
                                <th> ${atendimento.id} </th>
                                <th> <fmt:formatDate value="${atendimento.data}" pattern="dd/MM/yyyy HH:mm:ss" /></th>
                                <th> ${atendimento.type} </th>
                                <th> ${atendimento.status} </th>
                                <th><c:out value="${atendimento.descricao}" />  </th>
                               </tr>
                                  
                              </c:if>

                              
                                
                          </c:if>
                       </c:forEach>

                    </table>
                </div>
            </div>
        </div>
    </body>
    <footer class="bg-light text-center text-lg-start  bottom-0 left-0 right-0 w-100 pt-2">
            <p style="margin-left:50px">${config.info}</p>
        </footer>
</html>
