/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.Model;

import api.Model.Exceptions.GetAtendimentoException;
import api.Model.atendimento.Atendimento;
import api.Model.atendimento.AtendimentoDao.AtendimentoDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class GerenteFacade {
    
    public static ArrayList<Atendimento> getAtendimentosEmAberto(){
        ArrayList<Atendimento> atendimentos = null;
        try {
            atendimentos = AtendimentoDao.getAtendimentos();
        } catch (GetAtendimentoException ex) {
            Logger.getLogger(GerenteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atendimentos;
    }
    
    public static ArrayList<Atendimento> getAtendimentos(){
        ArrayList<Atendimento> atendimentos = null;
        try {
            atendimentos = AtendimentoDao.getAtendimentos();
        } catch (GetAtendimentoException ex) {
            Logger.getLogger(GerenteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atendimentos;
    }
}
