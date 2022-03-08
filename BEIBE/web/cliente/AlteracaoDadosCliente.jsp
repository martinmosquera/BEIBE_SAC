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
    </head>
    <body>
        <div>
            <h1>Alterar dados!</h1>
            <jsp:useBean id="user" class="users.Cliente" scope="session" />
            <form method="post" class="form-group" action="../UpdateCliente">
               
                <label for="nick">Nick Name:</label><br>
                <input type="text" id="nick" name="nick" value="<jsp:getProperty name="user" property="nick"/>"><br>
                <label for="nome">Nome completo:</label><br>
                <input type="text" id="nome" name="nome" value="<jsp:getProperty name="user" property="nome"/>"><br>
                <label for="senha">SENHA:</label><br> 
                <input type="text" id="senha" name="senha" value="<jsp:getProperty name="user" property="senha"/>"><br>
                <label for="rua">Endereço - Rua:</label><br>
                <input type="text" id="senha" name="rua" value="<jsp:getProperty name="user" property="rua"/>"><br>
                <label for="estado">Estado:</label><br>
                    <select id="estado" name="estado">
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
                    </select><br>
                 <label for="cep">CEP:</label><br> 
                 <input type="text" id="cep" name="cep" value="<jsp:getProperty name="user" property="cep" />"><br>
                 <label for="cidade">Cidade:</label><br> 
                 <input type="text" id="cidade" name="cidade" value="<jsp:getProperty name="user" property="cidade" />"><br>
                 <label for="bairro">Bairro:</label><br> 
                 <input type="text" id="bairro" name="bairro" value="<jsp:getProperty name="user" property="bairro" />"><br>
                 <label for="num">Numero:</label><br> 
                 <input type="text" id="num" name="num" value="<jsp:getProperty name="user" property="num" />"><br>
                 <label for="complemento">Complemento:</label><br> 
                 <input type="text" id="complemento" name="complemento" value="<jsp:getProperty name="user" property="complemento" />"><br>
                 <label for="telefone">Telefone:</label><br> 
                 <input type="text" id="telefone" name="telefone" value="<jsp:getProperty name="user" property="telefone" />"><br><br>
                <input type="submit" value="ATUALIZAR CADASTRO">
            </form> 
        </div>
                <a href="PortalUser.jsp"><button class="btn-primary">Home</button></a>
    </body>
</html>
