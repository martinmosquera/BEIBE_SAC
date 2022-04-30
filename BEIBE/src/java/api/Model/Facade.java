/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model;

import api.Model.ConnectionFactory.ConnectionFactory;
import api.Model.users.Cliente;
import api.Model.users.Pessoa;
import api.Model.users.PessoaDao.PessoaDao;
import java.util.List;

/**
 *
 * @author dell
 */
public class Facade {
    
    private static ConnectionFactory coon = new ConnectionFactory();
    private static PessoaDao cDao = new PessoaDao(coon);
    
    public Facade(){
    }
    
    public static List<Pessoa> getListaClientes(){
        List<Pessoa> lc = null;
        try{
            lc = cDao.getLista();            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    return lc;
    }
    
}
