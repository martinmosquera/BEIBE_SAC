/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import Categoria.Categoria;
import java.io.Serializable;

/**
 *
 * @author dell
 */
public class Produto implements Serializable{
    private int id;
    private String nome;
    private Categoria categoria;
    private String descricao;
    private double peso;
    public Produto(){
    }
    public Produto(int id,String nome){
        this.id = id;
        this.nome = nome;
    }
    public Produto(int id,String nome,Categoria categoria,String descricao,double peso){
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.peso = peso;
    }
       public Produto(int id,String nome,String descricao,double peso){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    
}
