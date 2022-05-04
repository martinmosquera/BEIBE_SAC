/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model;

import api.Model.Exceptions.AppException;
import api.Model.Exceptions.ListarProdutoException;
import api.Model.produto.Produto;
import api.Model.produto.ProdutoDao.ProdutoDao;
import java.util.List;

/**
 *
 * @author dell
 */
public class ProdutoFacade {
 
    public static List<Produto> getListaProdutos() throws AppException{
        try{
            return ProdutoDao.Listar();
        }catch(ListarProdutoException e){
            throw new AppException(e);
        }
    }
}
