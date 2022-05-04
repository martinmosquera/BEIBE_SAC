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
public class ErroGetClienteIdException extends AppException{

    public ErroGetClienteIdException(String string) {
        super(string);
    }

    public ErroGetClienteIdException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ErroGetClienteIdException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
