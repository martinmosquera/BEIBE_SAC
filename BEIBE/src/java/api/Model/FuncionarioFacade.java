/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model;

import api.Model.Categoria.Categoria;
import api.Model.Categoria.CategoriaDao.CategoriaDao;
import api.Model.Exceptions.ApagaCategoriaException;
import api.Model.Exceptions.AppException;
import api.Model.Exceptions.AtualizaCategoriaException;
import api.Model.Exceptions.GetAtendimentoException;
import api.Model.Exceptions.ResolveAtendimentoException;
import api.Model.Exceptions.addCategoriaException;
import api.Model.Exceptions.getCategoriaException;
import api.Model.atendimento.Atendimento;
import api.Model.atendimento.AtendimentoDao.AtendimentoDao;

/**
 *
 * @author dell
 */
public class FuncionarioFacade {
    
    public static void resolver(int id) throws AppException{
    
        try{
            AtendimentoDao.resolver(id);
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
}
