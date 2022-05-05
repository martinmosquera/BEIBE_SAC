/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model.Categoria.CategoriaDao;

import api.Model.Categoria.Categoria;
import api.Model.ConnectionFactory.ConnectionFactory;
import api.Model.Exceptions.ApagaCategoriaException;
import api.Model.Exceptions.AtualizaCategoriaException;
import api.Model.Exceptions.ConnectionException;
import api.Model.Exceptions.ListaCategoriaException;
import api.Model.Exceptions.addCategoriaException;
import api.Model.Exceptions.getCategoriaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class CategoriaDao {
    
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
   
    private static final String selectAll = "select * from categoria";
    private static final String selectCategoria = "select * from categoria where id=?";
    private static final String insert = "insert into categoria (nome) values (?)";
    private static final String updateC = "update categoria set nome=? where id=?";
    private static final String apagaReg = "delete from categoria where id=?";
    
    
    public static List<Categoria> Listar() throws ListaCategoriaException{
        
        try {
            Connection connection=connectionFactory.getConnection();
            ResultSet rs = null;
            PreparedStatement stmtLista = connection.prepareStatement(selectAll);
            rs = stmtLista.executeQuery();
            List<Categoria> categorias = new ArrayList<Categoria>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
              
                categorias.add(new Categoria(id,nome));
            }
            
            return categorias;
        } catch (SQLException | ConnectionException e) {
            throw new ListaCategoriaException(e);
        } 

    }
    
    public static Categoria getCategoria(int id) throws getCategoriaException{
        
        try{
            Connection connection=connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(selectCategoria);
        Categoria categoria = null;
        stmtLista.setInt(1,id);
            rs = stmtLista.executeQuery();
            
            while(rs.next()){
                int categoria_id = rs.getInt("id");
                if(categoria_id == id){
                    String nome = rs.getString("nome");
                    categoria = new Categoria(id,nome);
                    
                }
                
            }
            return categoria;
            
        }catch(SQLException | ConnectionException e){
            throw new getCategoriaException(e);
        }
    }
    
    public static Categoria addCategoria(String nome) throws addCategoriaException{
    
        try{
            Connection conn = connectionFactory.getConnection();
            PreparedStatement stmtAdd = conn.prepareStatement(insert,PreparedStatement.RETURN_GENERATED_KEYS);
            stmtAdd.setString(1, nome);
            stmtAdd.execute();
            ResultSet rs = stmtAdd.getGeneratedKeys();
            rs.next();
            int a = rs.getInt(1);
            return new Categoria(a,nome);
        }catch(SQLException | ConnectionException e){
            throw new addCategoriaException(e);
        }
    }
    
    public static void update(Categoria c) throws AtualizaCategoriaException{
    
        try{
            Connection conn = connectionFactory.getConnection();
            PreparedStatement update = conn.prepareStatement(updateC);
            update.setString(1, c.getNome());
            update.setInt(2, c.getId());
            update .executeUpdate();
            
            
        }catch(ConnectionException | SQLException e){
            throw new AtualizaCategoriaException(e);
        }
    }
    
     public static void delete(int id) throws ApagaCategoriaException{
         System.out.println("Eqtro aqui en delete");
        try{
            connectionFactory = new ConnectionFactory();
            Connection conn = connectionFactory.getConnection();
            PreparedStatement apaga = conn.prepareStatement(apagaReg);
            apaga.setInt(1, id);
            apaga.executeUpdate();
         System.out.println("Eqtro aqui endepois da qurey");   
        }catch(ConnectionException | SQLException e){
            throw new ApagaCategoriaException(e);
        }
    }
}
