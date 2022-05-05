/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model;

import api.Model.Categoria.Categoria;
import api.Model.Categoria.CategoriaDao.CategoriaDao;
import api.Model.ConnectionFactory.ConnectionFactory;
import api.Model.Exceptions.ApagaCategoriaException;
import api.Model.Exceptions.AppException;
import api.Model.Exceptions.AtualizaCategoriaException;
import api.Model.Exceptions.ErroGetClienteIdException;
import api.Model.Exceptions.ExcluirClienteException;
import api.Model.Exceptions.GetAtendimentoException;
import api.Model.Exceptions.GetFuncionarioException;
import api.Model.Exceptions.InserirClienteException;
import api.Model.Exceptions.ListaCategoriaException;
import api.Model.Exceptions.ResolveAtendimentoException;
import api.Model.Exceptions.addCategoriaException;
import api.Model.Exceptions.getCategoriaException;
import api.Model.atendimento.Atendimento;
import api.Model.atendimento.AtendimentoDao.AtendimentoDao;
import api.Model.users.Cliente;
import api.Model.users.PessoaDao.PessoaDao;
import api.Model.users.PessoaDao.PessoaDao;

import api.Model.users.Funcionario;
import api.Model.users.Pessoa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class FuncionarioFacade {
    
    
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    
    public static void deletaFuncionario(Integer id) throws ExcluirClienteException{
        PessoaDao pdao = new PessoaDao(connectionFactory);
        PessoaDao.excluir(id);
    }
    
    public static ArrayList<Funcionario> listFuncionarios() throws AppException{
        try{
            ArrayList<Funcionario> fList = PessoaDao.getFuncionarios();
            return fList;
        } catch(ErroGetClienteIdException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static void resolver(int id,String msg) throws AppException{
    
        try{
            AtendimentoDao.resolver(id,msg);
        }catch(ResolveAtendimentoException e){
            throw new AppException(e);
        }
    }
    
     public static Atendimento getAtendimento(int id) throws AppException{
        try{
            return AtendimentoDao.getAtendimento(id);
        }catch(GetAtendimentoException e){
            throw new AppException(e);
        }
    }
     
     public static Categoria criaCategoria(String nome) throws AppException{
         try{
             return CategoriaDao.addCategoria(nome);
         }catch(addCategoriaException e){
             throw new AppException(e);
         }
     }
     
      public static Categoria getCategoria(int id) throws AppException{
         try{
             return CategoriaDao.getCategoria(id);
         }catch(getCategoriaException e){
             throw new AppException(e);
         }
     }
      
      public static void atualizaCategoria(Categoria c) throws AppException{
      
          try{
              CategoriaDao.update(c);
          }catch(AtualizaCategoriaException e){
           throw new AppException(e);
          }
      }
      
        public static void apagaCategoria(int id) throws AppException{
      
          try{
              CategoriaDao.delete(id);
          }catch(ApagaCategoriaException e){
           throw new AppException(e);
          }
      }
        
      public static List<Categoria> getListaCategorias() throws AppException{
          try{
              return CategoriaDao.Listar();
          }catch(ListaCategoriaException e){
              throw new AppException(e);
          }
      }
      
      public static Funcionario getFuncionario(int id) throws AppException{
          try{
              return PessoaDao.getFuncionario(id);
          }catch(GetFuncionarioException e){
              throw new AppException(e);
          }
      }
      
      public static void insereFuncionario(Funcionario f) throws AppException{
          PessoaDao.inserir(f);
        }
      
      public static void editaFunc(Funcionario f) throws AppException{
          PessoaDao.atualizar(f);
        }

}
