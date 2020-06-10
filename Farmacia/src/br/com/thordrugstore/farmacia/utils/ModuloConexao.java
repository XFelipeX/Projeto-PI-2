package br.com.thordrugstore.farmacia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Classe para gerenciar a conexao com o banco de dados
 * @author Felipe
 */
public class ModuloConexao {

    public static Connection CONEXAO;
    /**
     * Método para fazer a conexão com o banco de dados
     * @return uma conexao do tipo Connection
     */
    public static Connection conector() {
        java.sql.Connection conexao = null;
        //chamando o driver importado da biblioteca
        //Armazenando informacoes referente ao banco
        String url = "jdbc:mysql://localhost:3306/farmacia";
        String user = "root";
        String password = "";
        //Estabelecendo a conexao com o banco
        try {
            // Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
    /**
     * Método para encerrar a conexão com o banco de dados
     * @return boolean true = sucesso , false = falha
     */
    public static boolean fecharConexao() {
        boolean retorno = false;
        try {
            if (CONEXAO != null) {
                if (!CONEXAO.isClosed()) {
                    CONEXAO.close();
                }
            }
            retorno = true;

        } catch (SQLException e) {
            retorno = false;
        }
        return retorno;
    }
}
