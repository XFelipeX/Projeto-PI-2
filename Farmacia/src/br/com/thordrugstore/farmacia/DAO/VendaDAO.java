/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.DAO;

import br.com.thordrugstore.farmacia.model.Venda;
import br.com.thordrugstore.farmacia.utils.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lipes
 */
public class VendaDAO {
    public static boolean salvar(Venda p) {
        boolean retorno = false;
        Connection conexao = null;
        String sql = null;
        PreparedStatement pst = null;
        sql = "insert into compra(cod_cliente,data_compra,valor_bruto,total,desconto,pagamento)"
                + "values(?,?,?,?,?,?)";
        try {
            conexao = ModuloConexao.conector();
 
                pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pst.setInt(1, p.getCliente().getCodcli());
                pst.setDate(2,new Date(p.getData().getTime()));
                pst.setDouble(3, p.getValorBruto());
                pst.setDouble(4, p.getTotal());
                pst.setDouble(5, p.getDesconto());
                pst.setString(6, p.getPagamento());

                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    retorno = true;
                    ResultSet generatedKeys = pst.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        p.setCodigoCompra(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Falha ao obter o ID do cliente.");
                    }
                } else {
                    retorno = false;
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                conexao.close();

            } catch (SQLException ex) {
            }
        }
        return retorno;
    }

    
}
