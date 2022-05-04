/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model;

import api.Model.Categoria.Categoria;
import api.Model.Categoria.CategoriaDao.CategoriaDao;
import api.Model.Exceptions.AppException;
import api.Model.Exceptions.ListaCategoriaException;
import java.util.List;

/**
 *
 * @author dell
 */
public class CategoriaFacade {
    
    public static List<Categoria> listarCategorias() throws AppException{
    
    try{
        return CategoriaDao.Listar();
    }catch(ListaCategoriaException e){
        throw new AppException(e);
    }
    
    }
}
