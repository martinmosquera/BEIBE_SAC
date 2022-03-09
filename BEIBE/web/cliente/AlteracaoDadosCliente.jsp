<%-- 
    Document   : AlteracaoDadosCliente
    Created on : 06/03/2022, 11:52:15
    Author     : Emanu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar dados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./assets/css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
                <a href="PortalUser.jsp">
                 <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="35" class="d-inline-block align-top" alt="">
                </a>
                <a href="AlteracaoDadosCliente.jsp"><button class="btn btn-light w-100 m-2 ">Alterar Dados</button></a><br/>
                <a href="ListaAtendimentosCliente.jsp"><button class="btn btn-light  w-100 m-2 ">Listar Atendimentos</button></a><br/>
                <a href="CriacaoAtendimentoCliente.jsp"><button class="btn btn-light w-100 m-2 ">Criar Atendimento</button></a><br/>
                <a href="../LogoutServlet"><button class="btn btn-danger  w-100 m-2 ">Logout</button></a><br/>
        </nav>
        <div class="container">
            <h1>Alterar dados!</h1>
            <jsp:useBean id="user" class="users.Cliente" scope="session" />
            <form method="post" class="form-control" action="../UpdateCliente">
               
                <label for="nick">Nick Name:</label>
                <input type="text" class="form-control mb-2" id="nick" name="nick" value="<jsp:getProperty name="user" property="nick"/>">
                <label for="nome">Nome completo:</label>
                <input type="text" class="form-control mb-2" id="nome" name="nome" value="<jsp:getProperty name="user" property="nome"/>">
                <label for="senha">SENHA:</label> 
                <input type="text" class="form-control mb-2" id="senha" name="senha" value="<jsp:getProperty name="user" property="senha"/>">
                <label for="rua">Endereço - Rua:</label>
                <input type="text" id="senha" class="form-control mb-2" name="rua" value="<jsp:getProperty name="user" property="rua"/>">
                <label for="estado">Estado:</label>
                    <select class="form-select mb-2" id="estado" name="estado">
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
                 <input type="text" class="form-control mb-2" id="cep" name="cep" value="<jsp:getProperty name="user" property="cep" />">
                 <label for="cidade">Cidade:</label> 
                 <input type="text" class="form-control mb-2" id="cidade" name="cidade" value="<jsp:getProperty name="user" property="cidade" />">
                 <label for="bairro">Bairro:</label> 
                 <input type="text" class="form-control mb-2" id="bairro" name="bairro" value="<jsp:getProperty name="user" property="bairro" />">
                 <label for="num">Numero:</label> 
                 <input type="text" class="form-control mb-2" id="num" name="num" value="<jsp:getProperty name="user" property="num" />">
                 <label for="complemento">Complemento:</label> 
                 <input type="text" class="form-control mb-2" id="complemento" name="complemento" value="<jsp:getProperty name="user" property="complemento" />">
                 <label for="telefone">Telefone:</label> 
                 <input type="text" class="form-control mb-2" id="telefone" name="telefone" value="<jsp:getProperty name="user" property="telefone" />">
                <input type="submit" class="btn btn-primary" value="ATUALIZAR CADASTRO">
            </form> 
        </div>
    </body>
</html>
