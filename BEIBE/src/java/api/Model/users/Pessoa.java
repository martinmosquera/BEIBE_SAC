/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model.users;

import java.io.Serializable;

/**
 *
 * @author dell
 */
public class Pessoa implements Serializable{
    private int id;
    private String nick;
    private String nome;
    private String cpf;
    private String email;
    private String rua;
    private String num;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String telefone;
    private String senha;
    private String type;

    public Pessoa() {
    }

    public Pessoa(String nick,String nome, String cpf, String email, String rua, String num, String complemento, String bairro, String cep, String cidade, String estado, String telefone, String senha,String type) {
        this.nick = nick;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.rua = rua;
        this.num = num;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.senha = senha;
        this.type = type;
    }

    public Pessoa(int id, String nick, String nome, String cpf, String email, String rua, String num, String complemento, String bairro, String cep, String cidade, String estado, String telefone, String senha,String type) {
        this.id = id;
        this.nick = nick;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.rua = rua;
        this.num = num;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.senha = senha;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
