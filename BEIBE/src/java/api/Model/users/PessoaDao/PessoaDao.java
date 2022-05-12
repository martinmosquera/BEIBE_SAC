/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model.users.PessoaDao;

import api.Model.ConnectionFactory.ConnectionFactory;
import api.Model.Exceptions.AtualizaClienteException;
import api.Model.Exceptions.ConnectionException;
import api.Model.Exceptions.ErroGetClienteIdException;
import api.Model.Exceptions.ExcluirClienteException;
import api.Model.Exceptions.GetFuncionarioException;
import api.Model.Exceptions.InserirClienteException;
import api.Model.users.Cliente;
import api.Model.users.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import api.Model.users.Pessoa;

/**
 *
 * @author dell
 */
public class PessoaDao {
    
// a conexão com o banco de dados

    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    
    private static final String insert = "insert into pessoa (user_nick,user_name,cpf,email,rua,num,complemento,bairro,cep,cidade,estado,telefone,senha,user_type,created_at,updated_at) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String select = "select * from pessoa";
    private static final String selectById = "select * from pessoa where user_id=?";

    private static final String update = "update pessoa set user_nick=?,user_name=?,rua=?,num=?,complemento=?,bairro=?,cep=?,cidade=?,estado=?,telefone=?,senha=?,email=?,cpf=? WHERE user_id=?";
    private final String delete = "delete from pessoa WHERE user_id=?";

    private static final String selectFuncionarios = "SELECT * FROM pessoa WHERE user_type=?";

    public PessoaDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }
    
    public static void inserir(Funcionario user) throws InserirClienteException {
                try {
            Connection connection=connectionFactory.getConnection();
            // prepared statement para inserção
            PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            // seta os valores
            
            stmtAdiciona.setString(1, user.getNick());
            stmtAdiciona.setString(2, user.getNome());
            stmtAdiciona.setString(3, user.getCpf());
            stmtAdiciona.setString(4, user.getEmail());
            stmtAdiciona.setString(5, user.getRua());
            stmtAdiciona.setString(6, user.getNum());
            stmtAdiciona.setString(7, user.getComplemento());
            stmtAdiciona.setString(8, user.getBairro());
            stmtAdiciona.setString(9, user.getCep());
            stmtAdiciona.setString(10, user.getCidade());
            stmtAdiciona.setString(11, user.getEstado());
            stmtAdiciona.setString(12, user.getTelefone());
            stmtAdiciona.setString(13, user.getSenha());
            stmtAdiciona.setString(14, user.getType());
              
            LocalDate now = LocalDate.now();
            Date nova = Date.valueOf(now);
            stmtAdiciona.setDate(15, nova);
            stmtAdiciona.setDate(16, nova);
            // executa
            stmtAdiciona.execute();
            //Seta o id do contato
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            user.setId(i);
            
        } catch (SQLException | ConnectionException e) {
            throw new InserirClienteException(e);
        } 
    }


    public static void inserir(Cliente user) throws InserirClienteException{
        try {
            Connection connection=connectionFactory.getConnection();
            // prepared statement para inserção
            PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            // seta os valores
            
            stmtAdiciona.setString(1, user.getNick());
            stmtAdiciona.setString(2, user.getNome());
            stmtAdiciona.setString(3, user.getCpf());
            stmtAdiciona.setString(4, user.getEmail());
            stmtAdiciona.setString(5, user.getRua());
            stmtAdiciona.setString(6, user.getNum());
            stmtAdiciona.setString(7, user.getComplemento());
            stmtAdiciona.setString(8, user.getBairro());
            stmtAdiciona.setString(9, user.getCep());
            stmtAdiciona.setString(10, user.getCidade());
            stmtAdiciona.setString(11, user.getEstado());
            stmtAdiciona.setString(12, user.getTelefone());
            stmtAdiciona.setString(13, user.getSenha());
            stmtAdiciona.setString(14, user.getType());
              
            LocalDate now = LocalDate.now();
            Date nova = Date.valueOf(now);
            stmtAdiciona.setDate(15, nova);
            stmtAdiciona.setDate(16, nova);
            // executa
            stmtAdiciona.execute();
            //Seta o id do contato
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            user.setId(i);
            
        } catch (SQLException | ConnectionException e) {
            throw new InserirClienteException(e);
        } 
    }

    public static List<Pessoa> getLista() throws SQLException{
        
        try {
            Connection connection=connectionFactory.getConnection();
            ResultSet rs = null;
            PreparedStatement stmtLista = connection.prepareStatement(select);
            rs = stmtLista.executeQuery();
            List<Pessoa> usuarios = new ArrayList<Pessoa>();
            while (rs.next()) {
                // criando o objeto Contato
                //Contato contato = new Contato();
                int id = rs.getInt("user_id");
                String nome = rs.getString("user_name");
                String nick= rs.getString("user_nick");
                String cpf= rs.getString("cpf");
                String email= rs.getString("email");
                String rua= rs.getString("rua");
                String num= rs.getString("num");
                String complemento= rs.getString("complemento");
                String bairro= rs.getString("bairro");
                String cep= rs.getString("cep");
                String cidade= rs.getString("cidade");
                String estado= rs.getString("estado");
                String telefone= rs.getString("telefone");
                String senha= rs.getString("senha");
                String type = rs.getString("user_type");
                
                // adicionando o objeto à lista
                usuarios.add(new Pessoa(id,nick,nome,cpf,email,rua,num,complemento,bairro,cep,cidade,estado,telefone,senha,type));
            }
            
            return usuarios;
        } catch (SQLException| ConnectionException e) {
            throw new RuntimeException(e);
        }

    }


    public static void atualizar(Pessoa user) throws AtualizaClienteException{
        try {
            Connection connection=connectionFactory.getConnection();
            PreparedStatement stmtAtualiza = connection.prepareStatement(update);           
            stmtAtualiza.setString(1, user.getNick());
            stmtAtualiza.setString(2, user.getNome());
            stmtAtualiza.setString(3, user.getRua());
            stmtAtualiza.setString(4, user.getNum());
            stmtAtualiza.setString(5, user.getComplemento());
            stmtAtualiza.setString(6, user.getBairro());
            stmtAtualiza.setString(7, user.getCep());
            stmtAtualiza.setString(8, user.getCidade());
            stmtAtualiza.setString(9, user.getEstado());
            stmtAtualiza.setString(10, user.getTelefone());
            stmtAtualiza.setString(11, user.getSenha());
            stmtAtualiza.setString(12, user.getEmail());
            stmtAtualiza.setString(13, user.getCpf());
            stmtAtualiza.setInt(14, user.getId());
            
            stmtAtualiza.executeUpdate();
        } catch(ConnectionException | SQLException e){
         throw new AtualizaClienteException(e);
        }

    }
    
    public void exluirLista(List<Pessoa> users) throws ExcluirClienteException {
        for(Pessoa user : users){
            try {
                excluir(user.getId());
            } catch (ExcluirClienteException ex) {
                throw new ExcluirClienteException(ex);
            }
        }
    }

    public static void excluir(Integer id) throws ExcluirClienteException {
        try {
            Connection connection=connectionFactory.getConnection();
            PreparedStatement stmtExcluir = connection.prepareStatement(delete);
            stmtExcluir.setInt(1, id);
            stmtExcluir.executeUpdate();
        }catch(SQLException | ConnectionException e){
            throw new ExcluirClienteException(e);
        }

    }

    public static Cliente getCliente(int id) throws ErroGetClienteIdException{
         Cliente cliente = null;
        PreparedStatement stmtSelect = null;
        ResultSet rs = null;
        try{
            Connection connection= new ConnectionFactory().getConnection();
            stmtSelect = connection.prepareStatement(selectById);
            stmtSelect.setInt(1, id);
            rs = stmtSelect.executeQuery();;
            rs.next();
                String nome = rs.getString("user_name");
                String nick= rs.getString("user_nick");
                String cpf= rs.getString("cpf");
                String email= rs.getString("email");
                String rua= rs.getString("rua");
                String num= rs.getString("num");
                String complemento= rs.getString("complemento");
                String bairro= rs.getString("bairro");
                String cep= rs.getString("cep");
                String cidade= rs.getString("cidade");
                String estado= rs.getString("estado");
                String telefone= rs.getString("telefone");
                String senha= rs.getString("senha");
                String type = rs.getString("user_type");
                Cliente c =new Cliente(id,nick,nome,cpf,email,rua,num,complemento,bairro,cep,cidade,estado,telefone,senha,type);
                return c;
            
        }catch(SQLException | ConnectionException e){
            throw new ErroGetClienteIdException("Erro ao tentar carregar a data "+e.getMessage(),e);
        }
    
    }
    
    public static ArrayList<Funcionario> getFuncionarios() throws ErroGetClienteIdException{
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        PreparedStatement stmtSelect = null;
        ResultSet rs = null;
        
        try{
            Connection connection= connectionFactory.getConnection();
            stmtSelect = connection.prepareStatement(selectFuncionarios);
            String t = "F";
            stmtSelect.setString(1, t);
            rs = stmtSelect.executeQuery();
            while(rs.next()){
              
                String id = rs.getString("user_ id");
                String nome = rs.getString("user_name");
                String nick= rs.getString("user_nick");
                String cpf= rs.getString("cpf");
                String email= rs.getString("email");
                String rua= rs.getString("rua");
                String num= rs.getString("num");
                String complemento= rs.getString("complemento");
                String bairro= rs.getString("bairro");
                String cep= rs.getString("cep");
                String cidade= rs.getString("cidade");
                String estado= rs.getString("estado");
                String telefone= rs.getString("telefone");
                String senha= rs.getString("senha");
                String type = rs.getString("user_type");
                Funcionario f =new Funcionario(new Pessoa(id,nick,nome,cpf,email,rua,num,complemento,bairro,cep,cidade,estado,telefone,senha,type));
                funcionarios.add(f);
                
            }
            return funcionarios;
            
        }catch(SQLException | ConnectionException e){
            throw new ErroGetClienteIdException("Erro ao tentar carregar a data "+e.getMessage(),e);
        }
        
    }
     public static Funcionario getFuncionario(int id) throws GetFuncionarioException{
        Funcionario f = null;
        PreparedStatement stmtSelect = null;
        ResultSet rs = null;
        try{
            Connection connection= new ConnectionFactory().getConnection();
            stmtSelect = connection.prepareStatement(selectById);
            stmtSelect.setInt(1, id);
            rs = stmtSelect.executeQuery();;
            rs.next();
                String nome = rs.getString("user_name");
                String nick= rs.getString("user_nick");
                String cpf= rs.getString("cpf");
                String email= rs.getString("email");
                String rua= rs.getString("rua");
                String num= rs.getString("num");
                String complemento= rs.getString("complemento");
                String bairro= rs.getString("bairro");
                String cep= rs.getString("cep");
                String cidade= rs.getString("cidade");
                String estado= rs.getString("estado");
                String telefone= rs.getString("telefone");
                String senha= rs.getString("senha");
                String type = rs.getString("user_type");
                f =new Funcionario(id,nick,nome,cpf,email,rua,num,complemento,bairro,cep,cidade,estado,telefone,senha,type);
                return f;
            
        }catch(SQLException | ConnectionException e){
            throw new GetFuncionarioException("Erro ao tentar carregar os dados "+e.getMessage(),e);
        }
    
    }
   
    
}

