/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lipes
 */
public class ModuloConexao {

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
}
