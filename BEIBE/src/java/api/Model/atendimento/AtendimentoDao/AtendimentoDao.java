/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Model.atendimento.AtendimentoDao;

import api.Model.ClienteFacade;
import api.Model.atendimento.Atendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import api.Model.ConnectionFactory.ConnectionFactory;
import api.Model.Exceptions.AppException;
import api.Model.Exceptions.AtualizaAtendimentoException;
import java.sql.Timestamp;
import api.Model.produto.Produto;
import api.Model.Exceptions.ConnectionException;
import api.Model.Exceptions.ExcluirAtendimentoException;
import api.Model.Exceptions.GetAtendimentoException;
import api.Model.Exceptions.InserirAtendimentoException;
import api.Model.Exceptions.ResolveAtendimentoException;
import api.Model.Exceptions.getListaClienteException;
import api.Model.FuncionarioFacade;
import api.Model.produto.ProdutoDao.ProdutoDao;
import api.Model.users.Cliente;
import api.Model.users.Funcionario;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author dell
 */
public class AtendimentoDao {
    
// a conexão com o banco de dados

    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    
    private static final String insert = "insert into atendimento (data,cliente_id,status,produto_id,type,descricao) values (?,?,?,?,?,?)";
    private static final String select = "select * from atendimento";
    private static final String resolve = "update atendimento set status=?,solucao=? where atendimento_id=?";
    private final String update = "update atendimento set funcionario_id=?,status=?,solucao=? WHERE atendimento_id=?";
    private final String delete = "delete from atendimento WHERE atendimento_id=?";
    private static final String selectforcliente = "select atendimento_id,data,cliente_id,status,produto_id,type,descricao,solucao,data_end from atendimento WHERE cliente_id=?";
    private static final String selectforfuncionario = "select * from atendimento WHERE funcionario_id=?";
    private static final String getAtendimento = "select * from atendimento where atendimento_id=?";
    
    public AtendimentoDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public static void inserir(Atendimento atendimento) throws InserirAtendimentoException{
        
        try {
            Connection connection=connectionFactory.getConnection();
            PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            LocalDateTime ld = LocalDateTime.now();
            stmtAdiciona.setTimestamp(1, Timestamp.valueOf(ld));
            stmtAdiciona.setInt(2, atendimento.getCliente().getId());
            stmtAdiciona.setString(3, atendimento.getStatus());
            stmtAdiciona.setInt(4, atendimento.getProduto().getId());
            stmtAdiciona.setString(5, atendimento.getType());
            stmtAdiciona.setString(6, atendimento.getDescricao());

            stmtAdiciona.execute();
            
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            atendimento.setId(i);
            
        } catch(SQLException | ConnectionException e) {
            throw new InserirAtendimentoException(e);
        } 
    }
    
    public static List<Atendimento> getListaCliente(Cliente cliente) throws getListaClienteException{
        
        try {
            Connection connection=connectionFactory.getConnection();
            ResultSet rs = null;
            PreparedStatement stmtLista = connection.prepareStatement(selectforcliente);
            int id = cliente.getId();
            stmtLista.setInt(1, id);
            rs = stmtLista.executeQuery();
            List<Atendimento> atendimentos = new ArrayList<Atendimento>();
            while (rs.next()) {
                int cliente_id = rs.getInt("cliente_id");
                if( cliente_id == cliente.getId()){
                cliente = ClienteFacade.getCliente(cliente_id);
                int idA = rs.getInt("atendimento_id");
                int idF = rs.getInt("funcionario_id");
                Funcionario f;
                if(idF != 0)
                f = FuncionarioFacade.getFuncionario(idF);
                else{
                f = new Funcionario();
                f.setId(0);
                }
                Timestamp tmst = rs.getTimestamp("data");
                java.util.Date d = new Date(tmst.getTime());
                String status = rs.getString("status");
                int idP = rs.getInt("produto_id");
                Produto pr = ProdutoDao.getProduto(idP);
                String type = rs.getString("type");
                String descricao = rs.getString("descricao");
                String solucao = rs.getString("solucao");
                if(solucao == null) solucao = "";
                Timestamp tmst2 = rs.getTimestamp("data_end");
                java.util.Date de = new Date(tmst2.getTime());

                atendimentos.add(new Atendimento(idA,d,cliente,f,status,pr,type,descricao,solucao,de));           
                }
                
            }
            
            return atendimentos;
        } catch (SQLException e) {
            throw new getListaClienteException(e);
        } catch (ConnectionException ex) {
            throw new getListaClienteException(ex);
        } catch(AppException e){
            throw new getListaClienteException(e);
        }

        
    }

    public static Funcionario getListaFuncionario(Funcionario funcionario) throws SQLException{
       
        try {
             Connection connection=connectionFactory.getConnection();
            ResultSet rs = null;
            Produto pr = null;
            PreparedStatement stmtLista = connection.prepareStatement(selectforfuncionario);
            stmtLista.setInt(1, funcionario.getId());
            rs = stmtLista.executeQuery();
            List<Atendimento> atendimentos = new ArrayList<Atendimento>();
            List<Atendimento> atendimentoTotal = new ArrayList<Atendimento>();
            while (rs.next()) {
                int funcionario_id = rs.getInt("funcionario_id");
                
                    int idA = rs.getInt("atendimento_id");
                    Timestamp tmst = rs.getTimestamp("data");
                    Date d = new Date(tmst.getTime());
                    Cliente cliente = ClienteFacade.getCliente(rs.getInt("cliente_id"));
                    String status = rs.getString("status");
                    Funcionario f = FuncionarioFacade.getFuncionario(rs.getInt("funcionario_id"));
                    String stat = rs.getString("status");
                    pr = ProdutoDao.getProduto(rs.getInt("produto_id"));
                    String type = rs.getString("type");
                    String descricao = rs.getString("descricao");
                    String solucao = rs.getString("solucao");
                    Timestamp tmst2 = rs.getTimestamp("date_end");
                    Date de = new Date(tmst2.getTime());
                    atendimentoTotal.add(new Atendimento(idA,d,cliente,f,stat,pr,type,descricao,solucao,de));           
            }
            funcionario.setAtendimentos(atendimentos);
            return funcionario;
        } catch (SQLException | AppException e) {
            throw new RuntimeException(e);
        } 

        
    }
    
    public void atualizar(Atendimento atendimento) throws AtualizaAtendimentoException{
        
        try {
            Connection connection=connectionFactory.getConnection();
            PreparedStatement stmtAtualiza = connection.prepareStatement(update);    
            stmtAtualiza.setString(1, atendimento.getDescricao());
            stmtAtualiza.setString(2, atendimento.getStatus());
            stmtAtualiza.setString(3, atendimento.getSolucao());
            stmtAtualiza.setInt(4, atendimento.getId());
            
            stmtAtualiza.executeUpdate();
        }catch(ConnectionException | SQLException e){
            throw new AtualizaAtendimentoException(e);
        } 

    }
    
    public void exluirLista(List<Atendimento> atendimentos) throws ExcluirAtendimentoException {
        for(Atendimento atendimento : atendimentos){
            try {
                excluir(atendimento);
            } catch (ExcluirAtendimentoException ex) {
                throw new ExcluirAtendimentoException(ex);
            }
        }
    }

    public void excluir(Atendimento atendimento) throws ExcluirAtendimentoException {
       
        try {
             Connection connection=connectionFactory.getConnection();
        PreparedStatement stmtExcluir;
        stmtExcluir = connection.prepareStatement(delete);
            stmtExcluir.setInt(1, atendimento.getId());
            stmtExcluir.executeUpdate();
        }catch(ConnectionException | SQLException e){
            throw new ExcluirAtendimentoException(e);
        }

    }

    public static void resolver(int id,String msg) throws ResolveAtendimentoException{
        try{
        
            Connection conn = connectionFactory.getConnection();
            PreparedStatement stmtResolve = conn.prepareStatement(resolve);
            stmtResolve.setString(1,"Fechado");
            stmtResolve.setString(2, msg);
            stmtResolve.setInt(3, id);
            stmtResolve.executeUpdate();
        }catch(SQLException | ConnectionException e){
            throw new ResolveAtendimentoException(e);
        }
    }
    
    public static Atendimento getAtendimento(int id)throws GetAtendimentoException{
         try{
        
            Connection conn = connectionFactory.getConnection();
            PreparedStatement stmtGet = conn.prepareStatement(getAtendimento);
            ResultSet rs;
            stmtGet.setInt(1, id);
            rs = stmtGet.executeQuery();
            rs.next();
            int cliente_id = rs.getInt("cliente_id");
                Cliente cliente = ClienteFacade.getCliente(cliente_id);
                Timestamp tmst = rs.getTimestamp("data");
                Date d = new Date(tmst.getTime());
                Funcionario f = FuncionarioFacade.getFuncionario(rs.getInt("funcionario_id"));
                Timestamp tmst2 = rs.getTimestamp("data_end");
                String stat = rs.getString("status");
                int produto_id = rs.getInt("produto_id");
                Produto pr = ProdutoDao.getProduto(produto_id);
                String type = rs.getString("type");
                String descricao = rs.getString("descricao");
                String solucao = rs.getString("solucao");
                Date de = new Date(tmst2.getTime());

                Atendimento a = new Atendimento(id,d,cliente,f,stat,pr,type,descricao,solucao,de);
                return a;
        }catch(SQLException | ConnectionException e){
            throw new GetAtendimentoException(e);
        } catch (AppException ex) {
            throw new GetAtendimentoException(ex);
        }
    
    }
    
    public static ArrayList<Atendimento> getAtendimentos()throws GetAtendimentoException{
        ArrayList<Atendimento> atendimentos = new ArrayList<>(); 
        try{
            Connection conn = connectionFactory.getConnection();
            PreparedStatement stmtGet = conn.prepareStatement(select + "order by data");
            ResultSet rs;
            rs = stmtGet.executeQuery();
            while(rs.next()){
                int id = rs.getInt("atendimento_id");
                int cliente_id = rs.getInt("cliente_id");
               Cliente cliente = ClienteFacade.getCliente(cliente_id);
                Timestamp tmst = rs.getTimestamp("data");
                Date d = new Date(tmst.getTime());
                int num = rs.getInt("funcionario_id");
                Funcionario f;
                if(num != 0)
                    f = FuncionarioFacade.getFuncionario(num);
                else{
                    f = new Funcionario();
                    f.setId(0);
                } 
                Timestamp tmst2 = rs.getTimestamp("data_end");
                String stat = rs.getString("status");
                int produto_id = rs.getInt("produto_id");
                Produto pr = ProdutoDao.getProduto(produto_id);
                String type = rs.getString("type");
                String descricao = rs.getString("descricao");
                String solucao = rs.getString("solucao");
                if(solucao == null) solucao = "";
                Date de = new Date(tmst2.getTime());

                atendimentos.add(new Atendimento(id,d,cliente,f,stat,pr,type,descricao,solucao,de));
            }
            return atendimentos;
        }catch(SQLException | ConnectionException e){
            throw new GetAtendimentoException(e);
        } catch (AppException ex) {
            throw new GetAtendimentoException(ex);
        }
    
    }
}

