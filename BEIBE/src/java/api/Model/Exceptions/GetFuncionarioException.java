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
public class GetFuncionarioException extends AppException{

    public GetFuncionarioException(String string) {
        super(string);
    }

    public GetFuncionarioException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public GetFuncionarioException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
