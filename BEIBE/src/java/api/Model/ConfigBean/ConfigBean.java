/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model.ConfigBean;

import api.Model.Categoria.Categoria;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dell
 */
public class ConfigBean implements Serializable{
    private String info;
    
    public ConfigBean(){
    
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    
}
