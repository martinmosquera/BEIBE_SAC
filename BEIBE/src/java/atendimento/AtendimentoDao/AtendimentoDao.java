/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atendimento.AtendimentoDao;

import atendimento.Atendimento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import users.Pessoa;
import ConnectionFactory.ConnectionFactory;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import produto.Produto;
import produto.ProdutoDao.ProdutoDao;
import users.Cliente;
import users.Funcionario;

/**
 *
 * @author dell
 */
public class AtendimentoDao {
    
// a conexão com o banco de dados

    private ConnectionFactory connectionFactory;
    
    private final String insert = "insert into atendimento (data,cliente_id,status,produto_id,type,descricao) values (?,?,?,?,?,?)";
    private final String select = "select * from atendimento";
    private final String update = "update atendimento set funcionario_id=?,status=?,solucao=? WHERE atendimento_id=?";
    private final String delete = "delete from atendimento WHERE atendimento_id=?";
    private final String selectforcliente = "select atendimento_id,data,cliente_id,status,produto_id,type,descricao from atendimento WHERE cliente_id=?";
    private final String selectforfuncionario = "select * from atendimento WHERE funcionario_id=?";
    
    public AtendimentoDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public void inserir(Atendimento atendimento) throws Exception {
        Connection connection=connectionFactory.getConnection();
        try {
            
            PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            String datSt = atendimento.getData() + " " + atendimento.getHora();
            stmtAdiciona.setTimestamp(1, Timestamp.valueOf(datSt));
            stmtAdiciona.setInt(2, atendimento.getCliente().getId());
            stmtAdiciona.setString(3, atendimento.getStatus());
            stmtAdiciona.setInt(4, atendimento.getProduto().getId());
            stmtAdiciona.setString(5, atendimento.getType());
            stmtAdiciona.setString(6, atendimento.getDescricao());

            stmtAdiciona.execute();
            
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            atendimento.setId(i);
            
        } catch(Exception e) {
            throw new Exception(e);
        } 
    }
    
    public List<Atendimento> getListaCliente(Cliente cliente) throws SQLException{
        Connection connection=connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(selectforcliente);
        int id = cliente.getId();
        stmtLista.setInt(1, id);
        try {
            rs = stmtLista.executeQuery();
            List<Atendimento> atendimentos = new ArrayList<Atendimento>();
            while (rs.next()) {
                int cliente_id = rs.getInt("cliente_id");
                if( cliente_id == cliente.getId()){
                int idA = rs.getInt("atendimento_id");
                Timestamp tmst = rs.getTimestamp("data");
                
                String status = rs.getString("status");
                int produto_id = rs.getInt("produto_id");
                Produto pr = new Produto(1,"nuevo");
                String type = rs.getString("type");
                String descricao = rs.getString("descricao");

                atendimentos.add(new Atendimento(idA,tmst,cliente,status,pr,type,descricao));           
                }
                
            }
            
            return atendimentos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            rs.close();
            stmtLista.close();
        }

        
    }

    public List<Atendimento> getListaFuncionario(Funcionario funcionario) throws SQLException{
        Connection connection=connectionFactory.getConnection();
        ResultSet rs = null;
        Produto pr = null;
        PreparedStatement stmtLista = connection.prepareStatement(selectforfuncionario);
        int id = funcionario.getId();
        stmtLista.setInt(1, id);
        try {
            rs = stmtLista.executeQuery();
            List<Atendimento> atendimentos = new ArrayList<Atendimento>();
            while (rs.next()) {
                int funcionario_id = rs.getInt("funcionario_id");
                if( funcionario_id == funcionario.getId()){
                    int idA = rs.getInt("atendimento_id");
                    Timestamp tmst = rs.getTimestamp("data");
                    String status = rs.getString("status");
                    String type = rs.getString("type");
                    String descricao = rs.getString("descricao");
    //              
                    atendimentos.add(new Atendimento(idA,tmst,status,type,funcionario,descricao));           
                }
                
            }
            
            return atendimentos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            rs.close();
            stmtLista.close();
        }

        
    }
    
    public void atualizar(Atendimento atendimento) throws SQLException{
        Connection connection=connectionFactory.getConnection();
        PreparedStatement stmtAtualiza = connection.prepareStatement(update);
        try {
                       
            stmtAtualiza.setString(1, atendimento.getDescricao());
            stmtAtualiza.setString(2, atendimento.getStatus());
            stmtAtualiza.setString(3, atendimento.getSolucao());
            stmtAtualiza.setInt(4, atendimento.getId());
            
            stmtAtualiza.executeUpdate();
        } finally{
            stmtAtualiza.close();
        }

    }
    
    public void exluirLista(List<Atendimento> atendimentos) throws SQLException {
        for(Atendimento atendimento : atendimentos){
            excluir(atendimento);
        }
    }

    public void excluir(Atendimento atendimento) throws SQLException {
        Connection connection=connectionFactory.getConnection();
        PreparedStatement stmtExcluir;
        stmtExcluir = connection.prepareStatement(delete);
        try {
            stmtExcluir.setInt(1, atendimento.getId());
            stmtExcluir.executeUpdate();
        } finally{
            stmtExcluir.close();
        }

    }    
}

