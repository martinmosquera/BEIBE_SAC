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
public class ExcluirClienteException extends AppException{

    public ExcluirClienteException(String string) {
        super(string);
    }

    public ExcluirClienteException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ExcluirClienteException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
