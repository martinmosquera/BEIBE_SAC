/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto.ProdutoDao;

import ConnectionFactory.ConnectionFactory;
import atendimento.Atendimento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import produto.Produto;

/**
 *
 * @author dell
 */
public class ProdutoDao {
    
    
    private ConnectionFactory connectionFactory;
   
    private final String select = "select * from produto";
    private final String selectProduto = "select * from produto where id=?";
    
    public ProdutoDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }
    
    public List<Produto> Listar() throws SQLException{
        Connection connection=connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(select);
        try {
            rs = stmtLista.executeQuery();
            List<Produto> produtos = new ArrayList<Produto>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int categoria_id = rs.getInt("categoria_id");
                String descricao = rs.getString("descricao");
                double peso = rs.getDouble("peso");
                
                // adicionando o objeto à lista
                produtos.add(new Produto(id,nome,descricao,peso));
            }
            
            return produtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            rs.close();
            stmtLista.close();
        }

    }
    
    public Produto getProduto(int id) throws SQLException{
        Connection connection=connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(selectProduto);
        Produto produto = null;
        try{
            rs = stmtLista.executeQuery();
            int produto_id = rs.getInt("id");
            String nome = rs.getString("nome");
//            int categoria_id = rs.getInt("categoria_id");
            String categoria = "teste";
            String descricao = rs.getString("descricao");
            double peso = rs.getDouble("peso");
            produto = new Produto(produto_id,nome,categoria,descricao,peso);
            return produto;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
