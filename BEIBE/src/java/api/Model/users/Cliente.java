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
public class Cliente extends Pessoa implements Serializable{
    private List<Atendimento> lista = new ArrayList<Atendimento>();

    public Cliente(){
    }

    public Cliente(String nick, String nome, String cpf, String email, String rua, String num, String complemento, String bairro, String cep, String cidade, String estado, String telefone, String senha, String type) {
        super(nick, nome, cpf, email, rua, num, complemento, bairro, cep, cidade, estado, telefone, senha, type);
    }

    public Cliente(int id, String nick, String nome, String cpf, String email, String rua, String num, String complemento, String bairro, String cep, String cidade, String estado, String telefone, String senha, String type) {
        super(id, nick, nome, cpf, email, rua, num, complemento, bairro, cep, cidade, estado, telefone, senha, type);
    }

    public Cliente(Pessoa user) {
       setId(user.getId());
       setNick(user.getNick());
       setNome(user.getNome());
       setCpf(user.getCpf());
       setEmail(user.getEmail());
       setRua(user.getRua());
       setNum(user.getNum());
       setComplemento(user.getComplemento());
       setBairro(user.getBairro());
       setCep(user.getCep());
       setCidade(user.getCidade());
       setEstado(user.getEstado());
       setTelefone(user.getTelefone());
       setSenha(user.getSenha());
       setType(user.getSenha());
    }
    

    public List<Atendimento> getLista() {
        return lista;
    }

    public void setLista(List<Atendimento> lista) {
        for(Atendimento at : lista){
        this.lista.add(at);
        }
    }
    
    public void addAtendimento(Atendimento atendimento){
    this.lista.add(atendimento);
    }

}
