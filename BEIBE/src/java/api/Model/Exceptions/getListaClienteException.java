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
public class getListaClienteException extends AppException{

    public getListaClienteException(String string) {
        super(string);
    }

    public getListaClienteException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public getListaClienteException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
