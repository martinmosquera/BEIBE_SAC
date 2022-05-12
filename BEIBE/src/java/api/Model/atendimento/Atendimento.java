/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model.atendimento;

import java.io.Serializable;
import java.util.Date;
import api.Model.produto.Produto;
import api.Model.users.Cliente;
import api.Model.users.Funcionario;


/**
 *
 * @author dell
 */
public class Atendimento implements Serializable{
    private int id;
    private Date data;
    private Cliente cliente;
    private Funcionario funcionario;
    private String status;
    private Produto produto;
    private String type;
    private String descricao;
    private String solucao;
    private Date data_end;

    public Atendimento() {
    }

    public Atendimento(int id, Date data, Cliente cliente, Funcionario funcionario, String status, Produto produto, String type, String descricao, String solucao, Date data_end) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.status = status;
        this.produto = produto;
        this.type = type;
        this.descricao = descricao;
        this.solucao = solucao;
        this.data_end = data_end;
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
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
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
    
    public Date getData_end() {
        return data_end;
    }

    public void setData_end(Date data_end) {
        this.data_end = data_end;
    }
                            
}
