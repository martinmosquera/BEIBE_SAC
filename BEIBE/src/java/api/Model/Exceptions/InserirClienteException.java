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
public class InserirClienteException extends AppException{

    public InserirClienteException(String string) {
        super(string);
    }

    public InserirClienteException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public InserirClienteException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
