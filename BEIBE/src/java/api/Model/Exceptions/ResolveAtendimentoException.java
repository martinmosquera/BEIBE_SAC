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
public class ResolveAtendimentoException extends AppException{

    public ResolveAtendimentoException(String string) {
        super(string);
    }

    public ResolveAtendimentoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ResolveAtendimentoException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
