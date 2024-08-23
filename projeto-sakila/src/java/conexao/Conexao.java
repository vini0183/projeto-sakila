package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String url = "jdbc:mysql://localhost:3306/sakila";
    private static final String user = "root";
    private static final String senha = "";
    
    public static Connection conectar() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, user, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }
    
}