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
public class AppException extends Exception{

    public AppException(String string) {
        super(string);
    }

    public AppException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public AppException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
