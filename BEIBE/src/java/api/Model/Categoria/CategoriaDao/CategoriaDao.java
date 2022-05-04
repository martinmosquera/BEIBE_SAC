/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model.Categoria.CategoriaDao;

import api.Model.Categoria.Categoria;
import api.Model.ConnectionFactory.ConnectionFactory;
import api.Model.Exceptions.ConnectionException;
import api.Model.Exceptions.ListaCategoriaException;
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
    
    private ConnectionFactory connectionFactory;
   
    private final String selectAll = "select * from categoria";
    private final String selectCategoria = "select * from categoria where id=?";
    
    public CategoriaDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }
    
    public List<Categoria> Listar() throws ListaCategoriaException{
        
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
    
    public Categoria getCategoria(int id) throws getCategoriaException{
        
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
}
