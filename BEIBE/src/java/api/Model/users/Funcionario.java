/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model.users;

import api.Model.atendimento.Atendimento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class Funcionario extends Pessoa implements Serializable{
    
    private List<Atendimento> atendimentos = new ArrayList<Atendimento>();

    public Funcionario() {
    }


    public Funcionario(int id, String nick, String nome, String cpf, String email, String rua, String num, String complemento, String bairro, String cep, String cidade, String estado, String telefone, String senha, String type) {
        super(id,nick,nome,cpf,email,rua,num,complemento,bairro,cep,cidade,estado,telefone,senha,type);
    }
    
        public Funcionario(String nick, String nome, String cpf, String email, String rua, String num, String complemento, String bairro, String cep, String cidade, String estado, String telefone, String senha, String type) {
        this.setNick(nick);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setEmail(email);
        this.setRua(rua);
        this.setNum(num);
        this.setComplemento(complemento);        
        this.setBairro(bairro);
        this.setCep(cep);
        this.setCidade(cidade); 
        this.setEstado(estado);
        this.setTelefone(telefone);
        this.setType("F");
        this.setSenha(senha);
    }
    
    
    public Funcionario(Pessoa p){
        super(p);
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = new ArrayList<>();
        for(Atendimento a: atendimentos){
            this.atendimentos.add(a);
        }
    }
    
}
