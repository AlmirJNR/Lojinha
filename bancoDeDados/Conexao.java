package lojinha.bancoDeDados;

import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    protected static String status = "Nao conectado...";
    
    public static Connection conexao = null;
    public static Statement statement = null;

    private static String url; // URL completa do banco de dados
    private static String userName; // Nome de usuário
    private static String password; // Senha

    public Conexao() throws IOException {
        //Mude o caminho a baixo para se adaptar ao caminho do arquivo chaveBancoDeDados.key seu sistema local
        Path caminhoDoArquivo = Paths.get("/home/almir/Development/College/lojinha/bancoDeDados/configuracoes/chaveBancoDeDados.key");
        List<String> ler = Files.readAllLines(caminhoDoArquivo);
        
        url = ler.get(0);
        userName = ler.get(1);
        password = ler.get(2);
    }

    public Statement getConexao() throws SQLException {
        String driverName = "org.postgresql.Driver";

        try {
            Class.forName(driverName);
            conexao = DriverManager.getConnection(url, userName, password);
            statement = conexao.createStatement();

            if (conexao != null) {
                status = ("STATUS: Conectado com sucesso!");
                JOptionPane.showMessageDialog(null, "Arquivo aceito e lido com sucesso\nConexao realizada com sucesso", "Lendo Dados de Conexao do Banco no Arquivo", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                status = ("STATUS: Não foi possível realizar a conexão!");
                JOptionPane.showMessageDialog(null, "A Conexao com o banco falhou", "Conexao", JOptionPane.ERROR_MESSAGE);
            }

            return statement;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "O driver especificado nao foi encontrado.", "Conexao", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel conectar ao Banco de Dados", "Conexao", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            return null;
        }
    }

    public String getStatusConexao() {
        return status;
    }

    public boolean fecharConexao() {
        try {
            conexao.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean fecharStatement() {
        try {
            statement.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
