<%-- 
    Document   : register
    Created on : 5 de mar de 2022, 17:20:38
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>Registrar</title>
        <link rel="shortcut icon" href="./assets/img/favicon.png"/>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${url}/assets/css/style.css" rel="stylesheet" type="text/css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light shadow-sm px-5 mb-4">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1280px-Bootstrap_logo.svg.png" height="30" class="d-inline-block align-top" alt="">
            <a href="ClienteServlet?to=home" class="navbar-nav">Home</a>
            <a href="ClienteServlet?to=sobre">Sobre</a>
            <a href="ClienteServlet?to=login">Login</a>
        </nav>
        <div class="container mb-4">
            <div class="d-flex align-items-center justify-content-center pb-5">
                <form class="col-8 form-group" method="post" action="ClienteServlet?to=userNew">
                    <div class="form-group mb-2">
                        <label for="nick">Nick Name:</label>
                        <input class="form-control" type="text" name="nick" placeholder="Nick Name" maxlength="100">
                    </div>
                    <div class="form-group mb-2">
                        <label for="nome">Nome Completo:</label>
                        <input class="form-control" type="text" name="nome" placeholder="Nome" maxlength="100">
                    </div>
                    <div class="form-group mb-2">
                        <label for="cpf">CPF:</label>
                        <input class="form-control" type="text" id="cpf" name="cpf" placeholder="000.000.000-00" maxlength="100">
                        <script type="text/javascript">$("#cpf").mask("000.000.000-00");</script>
                    </div>
                    <div class="form-group mb-2">
                        <label for="email">Email:</label>
                        <input class="form-control" type="email" name="email" placeholder="Email" maxlength="150">
                    </div>
                    <div class="form-group mb-2">
                        <label for="rua">Endereço - Rua:</label>
                        <input class="form-control" type="text" name="rua" placeholder="Rua" maxlength="150">
                    </div>
                    <div class="form-group mb-2">
                        <label for="num">Numero:</label>
                        <input class="form-control" type="text" name="num" placeholder="Numero" maxlength="5">
                    </div>
                    <div class="form-group mb-2">
                        <label for="comple">Complemento:</label>
                        <input class="form-control" type="text" name="comple" placeholder="Complemento" maxlength="150">
                    </div>
                    <div class="form-group mb-2">
                        <label for="bairro">Bairro:</label>
                        <input class="form-control" type="text" name="bairro" placeholder="Bairro" >
                    </div>
                    <div class="form-group mb-2">
                        <label for="cep">CEP:</label>
                        <input class="form-control" type="text" id="cep" name="cep" placeholder="CEP" pattern="[0-9]{5}-[0-9]{3}">
                        <script type="text/javascript">$("#cep").mask("00000-000");</script>
                    </div>
                    <div class="form-group mb-2">
                        <label for="cidade">Cidade:</label>
                        <input class="form-control" type="text" name="cidade" placeholder="Cidade">
                    </div>
                    <div class="form-group mb-2">
                         <label for="estado">Estado:</label>
                    <select class="form-select mb-2" id="estado" name="estado" placeholder="Estado">
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
                    </div>
                    <div class="form-group mb-2">
                        <label for="tel">Telefone:</label>
                        <input class="form-control" type="text" name="tel" id="telefone" placeholder="Telefone" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4,5}">
                         <script type="text/javascript">$("#telefone").mask("(00) 0000-00000");</script>
                    </div>
                    <div class="form-group mb-2">
                        <label for="senha">Password</label>
                        <input class="form-control" type="password" name="senha" placeholder="Senha">
                    </div>
                    <hr>
                    <div class="form-group mb-2 col-2">
                        <input type="submit" class="form-control btn-primary" value="Registrar">
                    </div>
                </form>
          </div> 
        </div>
        <footer class="bg-light text-center text-lg-start  bottom-0 left-0 right-0 w-100 pt-2">
            <p style="margin-left:50px">${config.info}</p>
        </footer>
    </body>
</html>

