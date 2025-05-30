package Modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoMySQL {
    
    private static final String URL = "jdbc:mysql://localhost/software-gestao?useTimezone=true&serverTimezone=Brasil/Brasilia";
    private static final String USER = "Luccas";
    private static final String PASSWORD = "Password0";
    private static Connection connection;
    
  
    public static Connection obterConexao() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
    
    public static void fecharConexao() throws SQLException{
        if (connection != null) {
            
                connection.close();
             }
    }
    
    public static void main(String[] args) throws SQLException {
        System.out.println(obterConexao());
    }
    
    public ConexaoMySQL() {
    }
}
