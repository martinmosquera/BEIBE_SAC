<%-- 
    Document   : AlteracaoDadosCliente
    Created on : 06/03/2022, 11:52:15
    Author     : Emanu
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${user == null}" >
    <c:redirect url="../ClienteServlet?to=login">
        <c:param name="msg" value="Requerido fazer Login para acessar" />
    </c:redirect> 
</c:if>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar dados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${url}/assets/css/style.css" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
                <a href="../ClienteServlet?to=homeP">
                 <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
                </a>
                <a href="../ClienteServlet?to=update"><button class="btn btn-light w-100 m-2 ">Alterar Dados</button></a><br/>
                <a href="../ClienteServlet?to=listar"><button class="btn btn-light  w-100 m-2 ">Listar Atendimentos</button></a><br/>
                <a href="../ClienteServlet?to=newForm"><button class="btn btn-light w-100 m-2 ">Criar Atendimento</button></a><br/>
                <a href="../LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <h1>Alterar dados!</h1>
            <form method="post" class="form-control" action="../ClienteServlet?to=updateUsuario">
               <input type="hidden" name="id" value="${user.id}">
                <label for="nick">Nick Name:</label>
                <input type="text" class="form-control mb-2" id="nick" name="nick" value="${user.nick}">
                <label for="nome">Nome completo:</label>
                <input type="text" class="form-control mb-2" id="nome" name="nome" value="${user.nome}">
                <label for="email">Email:</label>
                <input class="form-control" type="email" name="email" value="${user.email}" maxlength="150">
                <label for="cpf">CPF:</label>
                <input class="form-control" type="text" id="cpf" name="cpf" value="${user.cpf}" maxlength="100">
                <script type="text/javascript">$("#cpf").mask("000.000.000-00");</script>
                <label for="senha">SENHA:</label> 
                <input type="text" class="form-control mb-2" id="senha" name="senha" value="${user.senha}">
                <label for="rua">Endereço - Rua:</label>
                <input type="text" id="senha" class="form-control mb-2" name="rua" value="${user.rua}">
                <label for="estado">Estado:</label>
                    <select class="form-select mb-2" id="estado" name="estado" >
                        <option value="${user.estado}">${user.estado}</option>
                        <option value="AC">Acre</option>
                        <option value="AL">Alagoas</option>
                        <option value="AP">Amapá</option>
                        <option value="AM">Amazonas</option>
                        <option value="BA">Bahia</option>
                        <option value="CE">Ceará</option>
                        <option value="DF">Distrito Federal</option>
                        <option value="ES">Espírito Santo</option>
                        <option value="GO">Goiás</option>
                        <option value="MA">Maranhão</option>
                        <option value="MT">Mato Grosso</option>
                        <option value="MS">Mato Grosso do Sul</option>
                        <option value="MG">Minas Gerais</option>
                        <option value="PA">Pará</option>
                        <option value="PB">Paraíba</option>
                        <option value="PR">Paraná</option>
                        <option value="PE">Pernambuco</option>
                        <option value="PI">Piauí</option>
                        <option value="RJ">Rio de Janeiro</option>
                        <option value="RN">Rio Grande do Norte</option>
                        <option value="RS">Rio Grande do Sul</option>
                        <option value="RO">Rondônia</option>
                        <option value="RR">Roraima</option>
                        <option value="SC">Santa Catarina</option>
                        <option value="SP">São Paulo</option>
                        <option value="SE">Sergipe</option>
                        <option value="TO">Tocantins</option>
                        <option value="EX">Estrangeiro</option>
                    </select>
                 <label for="cep">CEP:</label> 
                 <input type="text" class="form-control mb-2" id="cep" name="cep" value="${user.cep}" pattern="[0-9]{5}-[0-9]{3}">
                 <script type="text/javascript">$("#cep").mask("00000-000");</script>
                 <label for="cidade">Cidade:</label> 
                 <input type="text" class="form-control mb-2" id="cidade" name="cidade" value="${user.cidade}">
                 <label for="bairro">Bairro:</label> 
                 <input type="text" class="form-control mb-2" id="bairro" name="bairro" value="${user.bairro}">
                 <label for="num">Numero:</label> 
                 <input type="text" class="form-control mb-2" id="num" name="num" value="${user.num}">
                 <label for="complemento">Complemento:</label> 
                 <input type="text" class="form-control mb-2" id="complemento" name="complemento" value="${user.complemento}">
                 <label for="telefone">Telefone:</label> 
                 <input type="text" class="form-control mb-2" id="telefone" name="tel" value="${user.telefone}" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4,5}">
                 <script type="text/javascript">$("#telefone").mask("(00) 0000-00009");</script>
                 <input type="submit" class="btn btn-primary" value="ATUALIZAR CADASTRO">
            </form> 
        </div>
           <footer class="bg-light text-center text-lg-start bottom-0 left-0 right-0 w-100 pt-2">
                <p style="margin-left:50px">${config.info}</p>
        </footer>
    </body>
</html>
