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
public class ListarProdutoException extends AppException{

    public ListarProdutoException(String string) {
        super(string);
    }

    public ListarProdutoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ListarProdutoException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
