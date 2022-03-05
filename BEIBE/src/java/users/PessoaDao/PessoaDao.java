/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.PessoaDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import users.Pessoa;

/**
 *
 * @author dell
 */
public class PessoaDao {
    
// a conexão com o banco de dados

    private ConnectionFactory connectionFactory;
    
    private final String insert = "insert into pessoa (user_nick,user_name,cpf,email,rua,num,complemento,bairro,cep,cidade,estado,telefone,senha,user_type,created_at,updated_at) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String select = "select * from pessoa";
    private final String update = "update pessoa set user_nick=?,user_name=?,rua=?,num=?,complemento=?,bairro=?,cep=?,cidade=?,estado=?,telefone=?,senha=?,updated_at=? WHERE user_id=?";
    private final String delete = "delete from pessoa WHERE user_id=?";

    public PessoaDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public void inserir(Pessoa user) {
        Connection connection=connectionFactory.getConnection();
        try {
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
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }

    public List<Pessoa> getLista() throws SQLException{
        Connection connection=connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(select);
        try {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            rs.close();
            stmtLista.close();
        }

    }


    public void atualizar(Pessoa user) throws SQLException{
        Connection connection=connectionFactory.getConnection();
        PreparedStatement stmtAtualiza = connection.prepareStatement(update);
        try {
                       
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
            LocalDate now = LocalDate.now();
            Date nova = Date.valueOf(now);
            
            stmtAtualiza.setDate(12, nova);
            stmtAtualiza.setInt(12, user.getId());
            
            stmtAtualiza.executeUpdate();
        } finally{
            stmtAtualiza.close();
        }

    }
    
    public void exluirLista(List<Pessoa> users) throws SQLException {
        for(Pessoa user : users){
            excluir(user);
        }
    }

    public void excluir(Pessoa user) throws SQLException {
        Connection connection=connectionFactory.getConnection();
        PreparedStatement stmtExcluir;
        stmtExcluir = connection.prepareStatement(delete);
        try {
            stmtExcluir.setInt(1, user.getId());
            stmtExcluir.executeUpdate();
        } finally{
            stmtExcluir.close();
        }

    }    
}

