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

    public Funcionario(Pessoa user) {
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
       setType(user.getType());
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
