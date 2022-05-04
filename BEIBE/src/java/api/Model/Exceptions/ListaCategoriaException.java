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
public class ListaCategoriaException extends AppException{

    public ListaCategoriaException(String string) {
        super(string);
    }

    public ListaCategoriaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ListaCategoriaException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
