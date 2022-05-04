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
public class ExcluirAtendimentoException extends AppException{

    public ExcluirAtendimentoException(String string) {
        super(string);
    }

    public ExcluirAtendimentoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ExcluirAtendimentoException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
