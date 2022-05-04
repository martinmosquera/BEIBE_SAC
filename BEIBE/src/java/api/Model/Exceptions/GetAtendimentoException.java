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
public class GetAtendimentoException extends AppException{

    public GetAtendimentoException(String string) {
        super(string);
    }

    public GetAtendimentoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public GetAtendimentoException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
