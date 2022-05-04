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
public class ConnectionException extends AppException{

    public ConnectionException(String string) {
        super(string);
    }

    public ConnectionException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ConnectionException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
