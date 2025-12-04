package fatec.poo.control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mhebe
 */
public class Conexao {
    private String connectionString;
    private String driver;
    private String usuario;
    private String senha;
    private Connection connection = null;

    public Conexao(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public void setConnectionString(String connectionStringo) {
        this.connectionString = connectionStringo;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    public Connection abrirConxao() {
        if(connection == null){
            try{
                Class.forName(driver);
                connection = DriverManager.getConnection(connectionString, usuario, senha);
                System.out.println("[Conexão OK]");
            } catch(Exception ex) {
                System.out.println("Falha em se conectar com o banco de dados");
                System.out.println(ex.toString() + ex.getMessage());
            }
        }
        return connection;
    }
    
    public void fecharConexao(){
        try {
            connection.close();
            System.out.println("{Conexão encerrada com sucesso}");
        } catch (Exception ex) {
            System.out.println("Falha em encerrar a conexão");
            System.out.println(ex.toString() + ex.getMessage());
        }
    }
}
