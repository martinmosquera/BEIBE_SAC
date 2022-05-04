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
public class getProdutoException extends AppException{

    public getProdutoException(String string) {
        super(string);
    }

    public getProdutoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public getProdutoException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
