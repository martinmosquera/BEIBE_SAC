/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model;

import api.Model.ConnectionFactory.ConnectionFactory;
import api.Model.Exceptions.AppException;
import api.Model.Exceptions.AtualizaClienteException;
import api.Model.Exceptions.ErroGetClienteIdException;
import api.Model.Exceptions.InserirAtendimentoException;
import api.Model.Exceptions.InserirClienteException;
import api.Model.atendimento.Atendimento;
import api.Model.atendimento.AtendimentoDao.AtendimentoDao;
import api.Model.users.Cliente;
import api.Model.users.Pessoa;
import api.Model.users.PessoaDao.PessoaDao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dell
 */
public class ClienteFacade {
    
     public static Cliente getCliente(int id) throws AppException{
        Cliente cliente = new Cliente();
        try{
            cliente = PessoaDao.getCliente(id);
        }catch(ErroGetClienteIdException e){
            throw new AppException(e.getMessage());
        }
        return cliente;
    }
     
     public static List<Pessoa> getListaClientes() throws AppException{
        List<Pessoa> lc = null;
        try{
            lc = PessoaDao.getLista();            
        }catch(SQLException e){
            throw new AppException(e);
        }
    return lc;
    }
     
     public static void atualizaCliente(Pessoa cliente) throws AppException{
         try{
             PessoaDao.atualizar(cliente);
         }catch(AtualizaClienteException e){
             throw new AppException(e);
         }
     }
     
     public static void criaAtendimento(Atendimento a) throws AppException{
         try{
             AtendimentoDao.inserir(a);
         }catch(InserirAtendimentoException e){
             throw new AppException(e);
         }
     }
     
     public static void insereUsuario(Cliente cliente) throws AppException{
     try{
         PessoaDao.inserir(cliente);
        }catch(InserirClienteException e){
            throw new AppException(e);
        }
     }
    
}
