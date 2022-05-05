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
public class addCategoriaException extends AppException{

    public addCategoriaException(String string) {
        super(string);
    }

    public addCategoriaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public addCategoriaException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
