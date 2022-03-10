/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.Serializable;

/**
 *
 * @author dell
 */
public class Gerente extends Pessoa implements Serializable{
    
    public Gerente(Pessoa user){
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
    
}
