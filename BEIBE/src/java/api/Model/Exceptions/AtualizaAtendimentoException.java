/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model.Exceptions;

/**
 *
 * @author dell
 */
public class AtualizaAtendimentoException extends AppException{

    public AtualizaAtendimentoException(String string) {
        super(string);
    }

    public AtualizaAtendimentoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public AtualizaAtendimentoException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
