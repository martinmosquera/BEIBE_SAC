/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atendimento;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import produto.Produto;
import users.Pessoa;

/**
 *
 * @author dell
 */
public class Atendimento implements Serializable{
    private int id;
    private Date data;
    private Time hora;
    private Pessoa cliente;
    private Pessoa funcionario;
    private String status;
    private Produto produto;
    private String type;
    private String descricao;
    private String solucao;

    public Atendimento() {
    }

    public Atendimento(Date data, Time hora, Pessoa cliente, String status, Produto produto, String type, String descricao) {
        this.data = data;
        this.hora = hora;
        this.cliente = cliente;
        this.status = status;
        this.produto = produto;
        this.type = type;
        this.descricao = descricao;
    }

    public Atendimento(int id, Date date, int cliente_id, int funcionario_id, String status, int produto_id, String type, String descricao, String solucao) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.cliente = cliente;
        this.status = status;
        this.produto = produto;
        this.type = type;
        this.descricao = descricao;
        this.solucao = solucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Pessoa getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Pessoa funcionario) {
        this.funcionario = funcionario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String Solucao) {
        this.solucao = Solucao;
    }
                            
}
