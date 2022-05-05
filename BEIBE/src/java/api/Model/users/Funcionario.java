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
        this.setId(id);
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
        this.setId(p.getId());
        this.setNick(p.getNick());
        this.setNome(p.getNome());
        this.setCpf(p.getCpf());
        this.setEmail(p.getEmail());
        this.setRua(p.getRua());
        this.setNum(p.getNum());
        this.setComplemento(p.getComplemento());        
        this.setBairro(p.getBairro());
        this.setCep(p.getCep());
        this.setCidade(p.getCidade()); 
        this.setEstado(p.getEstado());
        this.setTelefone(p.getTelefone());
        this.setType("F");
        this.setSenha(p.getSenha());
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        for(Atendimento a: atendimentos){
            this.atendimentos.add(a);
        }
    }
    
}
