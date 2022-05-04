/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model;

import api.Model.Exceptions.AppException;
import api.Model.Exceptions.GetAtendimentoException;
import api.Model.Exceptions.ResolveAtendimentoException;
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
}
