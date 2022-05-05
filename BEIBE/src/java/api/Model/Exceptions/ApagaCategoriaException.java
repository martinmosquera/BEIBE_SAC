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
public class ApagaCategoriaException extends AppException{

    public ApagaCategoriaException(String string) {
        super(string);
    }

    public ApagaCategoriaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ApagaCategoriaException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
