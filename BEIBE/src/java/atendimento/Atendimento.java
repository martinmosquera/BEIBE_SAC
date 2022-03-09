/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atendimento;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import produto.Produto;
import users.Cliente;
import users.Funcionario;


/**
 *
 * @author dell
 */
public class Atendimento implements Serializable{
    private int id;
    private Timestamp datatime;
    private Date data;
    private Time hora;
    private Cliente cliente;
    private Funcionario funcionario;
    private String status;
    private Produto produto;
    private String type;
    private String descricao;
    private String solucao;

    public Atendimento() {
    }
    
    public Atendimento(Cliente cliente,String type,Produto produto,String descricao){
    this.cliente = cliente;
    this.type = type;
    this.produto = produto;
    this.descricao = descricao;
    
    }

    public Atendimento(Date data, Time hora, Cliente cliente, String status, Produto produto, String type, String descricao) {
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

    public Atendimento(int idA, Date date,Time hora, Cliente cliente, String status, Produto pr, String type, String descricao) {
        this.id = idA;
        this.data = date;
        this.hora = hora;
        this.cliente = cliente;
        this.status = status;
        this.produto = pr;
        this.type = type;
        this.descricao = descricao;
    }
      public Atendimento(int idA, Timestamp tmst, Cliente cliente, String status, Produto pr, String type, String descricao) {
    this.id =idA;
    this.datatime = tmst;
    this.cliente = cliente;
    this.type = type;
    this.status = status;
    this.produto = pr;
    this.descricao = descricao;
    }

    public Atendimento(int idA, Timestamp tmst, String status, String type, Funcionario funcionario, String descricao) {
       this.id =idA;
        this.datatime = tmst;
        this.status = status;
        this.type = type;
        this.funcionario = funcionario;
        this.descricao = descricao; 
    }

    public Timestamp getDatatime() {
        return datatime;
    }

    public void setDatatime(Timestamp datatime) {
        this.datatime = datatime;
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
                            
}
