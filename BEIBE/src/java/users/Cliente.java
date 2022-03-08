/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import atendimento.Atendimento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class Cliente extends Pessoa{
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
       this.setCpf(user.getCpf());
       this.setEmail(user.getEmail());
       this.setRua(user.getRua());
       this.setNum(user.getNum());
       this.setComplemento(user.getComplemento());
       this.setBairro(user.getBairro());
       this.setCep(user.getCep());
       this.setCidade(user.getCidade());
       this.setEstado(user.getEstado());
       this.setTelefone(user.getTelefone());
       this.setSenha(user.getSenha());
       this.setType(user.getSenha());
    }
    

    public List<Atendimento> getLista() {
        return lista;
    }

    public void setLista(List<Atendimento> lista) {
        this.lista = lista;
    }


}
