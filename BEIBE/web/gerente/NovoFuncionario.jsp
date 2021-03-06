<%-- 
    Document   : NovoProduto
    Created on : Mar 9, 2022, 7:41:04 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionário</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
      
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
                <a href="PortalGerente.jsp">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
                </a>
                <a href="../LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <c:if test="${empty funcionario}">
                
                <h1>Novo Funcionário</h1>
                 <form class="col-8 form-group" method="post" action="FuncionarioServlet?to=newFunc">
            </c:if>
            <c:if test="${not empty funcionario}">
                
                <h1>Editar Funcionário</h1>
                <form class="col-8 form-group" method="post" action="FuncionarioServlet?to=editFunc">
            </c:if>
                
                    <div class="form-group mb-2">
                        <label for="nick">Nome:</label>
                        <input class="form-control" type="text" name="nick" placeholder="Nome" value="${funcionario.nick}">
                    </div>
                    <div class="form-group mb-2">
                        <label for="peso">Cargo</label>
                        <input class="form-control" type="text" name="cargo" placeholder="Cargo" value="${funcionario.cargo}">
                    </div>
                    <div class="form-group mb-2">
                        <label for="peso">CPF</label>
                        <input class="form-control" type="text" id="cpf" name="cpf" placeholder="CPF" maxlength="100" value="${funcionario.cpf}">
                        <script type="text/javascript">$("#cpf").mask("000.000.000-00");</script>
                    </div>
                   <div class="form-group mb-2">
                        <label for="peso">Email</label>
                        <input class="form-control" type="email" name="email" placeholder="Email" value="${funcionario.email}">
                    </div>
                    <c:if test="${not empty funcionario}">
                        <div class="form-group mb-2">
                            <a href="CadastroFuncionarios.jsp" class="btn btn-primary" >Editar</a>
                        </div>
                    </c:if>
                    <c:if test="${empty funcionario}">
                        <div class="form-group mb-2">
                            <a href="CadastroFuncionarios.jsp" class="btn btn-primary" >Adicionar</a>
                        </div>
                    </c:if>
                </form>
        </div>
        <footer class="bg-light text-center text-lg-start  bottom-0 left-0 right-0 w-100 pt-2">
            <p style="margin-left:50px">${config.info}</p>
        </footer>
    </body>
</html>
