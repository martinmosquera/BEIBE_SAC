package api.Model.ConnectionFactory;

import api.Model.Exceptions.ConnectionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory implements AutoCloseable{
    private static  String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/webii";
    private static String LOGIN = "root";
    private static String SENHA = "";
    
    private Connection  conn = null;
    
    public Connection getConnection() throws ConnectionException{
        if(conn == null){
            try{
             Class.forName(DRIVER);
             conn = DriverManager.getConnection(URL,LOGIN,SENHA);
            }catch(ClassNotFoundException e){
                throw new ConnectionException("Driver do banco nâo encontrado: "+DRIVER,e);
            }catch(SQLException e){
                throw new ConnectionException("Erro conectando o Banco: "+URL+"/"+LOGIN+"/"+SENHA,e);
            }
        
        }
        return conn;
    }

    @Override
    public void close(){
        if(conn != null){
            try{
                conn.close();
            }catch(Exception e){
                System.out.println("Erro fechando a conexao <- In console ||");
                e.printStackTrace();
            
            }finally{
                conn  = null;
            }
        }
    }
}

