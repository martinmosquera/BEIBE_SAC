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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import users.Pessoa;
import ConnectionFactory.ConnectionFactory;

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

    public AtendimentoDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public void inserir(Atendimento atendimento) {
        Connection connection=connectionFactory.getConnection();
        try {
            // prepared statement para inserção
            PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            // seta os valores
            
            stmtAdiciona.setDate(1, atendimento.getData());
            stmtAdiciona.setInt(2, atendimento.getCliente().getId());
            stmtAdiciona.setString(3, atendimento.getStatus());
            stmtAdiciona.setInt(4, atendimento.getProduto().getId());
            stmtAdiciona.setString(5, atendimento.getType());
            stmtAdiciona.setString(6, atendimento.getDescricao());
            
            // executa
            stmtAdiciona.execute();
            //Seta o id do contato
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            atendimento.setId(i);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }

    public List<Atendimento> getLista() throws SQLException{
        Connection connection=connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(select);
        try {
            rs = stmtLista.executeQuery();
            List<Atendimento> atendimentos = new ArrayList<Atendimento>();
            while (rs.next()) {
                // criando o objeto Contato
                //Contato contato = new Contato();
                int id = rs.getInt("atendimento_id");
                Date date = rs.getDate("data");
                int cliente_id = rs.getInt("cliente_id");
                int funcionario_id = rs.getInt("funcionario_id");
                String status = rs.getString("status");
                int produto_id = rs.getInt("produto_id");
                String type = rs.getString("type");
                String descricao = rs.getString("descricao");
                String solucao = rs.getString("solucao");
                
                // adicionando o objeto à lista
                atendimentos.add(new Atendimento(id,date,cliente_id,funcionario_id,status,produto_id,type,descricao,solucao));
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

