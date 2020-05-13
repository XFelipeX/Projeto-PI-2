/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.DAO;

import br.com.thordrugstore.farmacia.model.Cliente;
import br.com.thordrugstore.farmacia.utils.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author lipes
 */
public class ClienteDAO {

    public static boolean salvar(Cliente p) {
        boolean retorno = false;
        Connection conexao = null;
        String sql = null;
        PreparedStatement pst = null;
        sql = "insert into clientes(cod_cli,nome,cpf,data_nascimento,email,telefone,endereco,complemento,cidade,uf) "
                + "values(?,?,?,?,?,?,?,?,?,?)";
        try {
            conexao = ModuloConexao.conector();

            if (p.getNome().isEmpty()||p.getEmail().isEmpty()||p.getTelefone().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, p.getCodcli());
                pst.setString(2,p.getNome());
                pst.setString(3,p.getCpf());
                pst.setString(4,p.getDataNascimento());
                pst.setString(5,p.getEmail());
                pst.setString(6,p.getTelefone());
                pst.setString(7,p.getEndereco());
                pst.setString(8,p.getComplemento());
                pst.setString(9,p.getCidade());
                pst.setString(10,p.getUf());
                
                
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    retorno = true;
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
                    
                }
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
        return retorno;
    }
}
