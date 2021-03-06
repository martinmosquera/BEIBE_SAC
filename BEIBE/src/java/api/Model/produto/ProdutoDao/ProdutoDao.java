/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model.produto.ProdutoDao;

import api.Model.Categoria.Categoria;
import api.Model.Categoria.CategoriaDao.CategoriaDao;
import api.Model.ConnectionFactory.ConnectionFactory;
import api.Model.Exceptions.AppException;
import api.Model.Exceptions.ConnectionException;
import api.Model.Exceptions.ListarProdutoException;
import api.Model.Exceptions.getCategoriaException;
import api.Model.Exceptions.getProdutoException;
import api.Model.FuncionarioFacade;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import api.Model.produto.Produto;

/**
 *
 * @author dell
 */
public class ProdutoDao {
    
    
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
   
    private static final String select = "select * from produto";
    private static final String selectProduto = "select * from produto where id=?";
    
    public ProdutoDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }
    
    public static List<Produto> Listar() throws ListarProdutoException{
        
        try {
            Connection connection=connectionFactory.getConnection();
            ResultSet rs = null;
            PreparedStatement stmtLista = connection.prepareStatement(select);
            rs = stmtLista.executeQuery();
            List<Produto> produtos = new ArrayList<Produto>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int categoria_id = rs.getInt("categoria_id"); 
                Categoria categoria = FuncionarioFacade.getCategoria(categoria_id);
                String descricao = rs.getString("descricao");
                double peso = rs.getDouble("peso");
                
                // adicionando o objeto ?? lista
                produtos.add(new Produto(id,nome,categoria,descricao,peso));
            }
            
            return produtos;
        } catch (SQLException | AppException e) {
            throw new ListarProdutoException(e);
        }

    }
    
    public static Produto getProduto(int id) throws getProdutoException{
       
        try{
            Connection connection=connectionFactory.getConnection();
            ResultSet rs = null;
            PreparedStatement stmtLista = connection.prepareStatement(selectProduto);
            stmtLista.setInt(1, id);
            Produto produto = null;
            rs = stmtLista.executeQuery();
            rs.next();
            int produto_id = rs.getInt("id");
            String nome = rs.getString("nome");
            int categoria_id = rs.getInt("categoria_id");     
            Categoria categoria = FuncionarioFacade.getCategoria(categoria_id);
            String descricao = rs.getString("descricao");
            double peso = rs.getDouble("peso");
            produto = new Produto(produto_id,nome,categoria,descricao,peso);
            return produto;
        }catch(SQLException | AppException e){
            throw new getProdutoException(e);
        }
    }
}
