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
public class AtualizaCategoriaException extends AppException{

    public AtualizaCategoriaException(String string) {
        super(string);
    }

    public AtualizaCategoriaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public AtualizaCategoriaException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
