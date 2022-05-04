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
public class getCategoriaException extends AppException{

    public getCategoriaException(String string) {
        super(string);
    }

    public getCategoriaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public getCategoriaException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
