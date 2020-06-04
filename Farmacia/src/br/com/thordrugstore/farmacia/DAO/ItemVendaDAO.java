package br.com.thordrugstore.farmacia.DAO;

import br.com.thordrugstore.farmacia.model.Cliente;
import br.com.thordrugstore.farmacia.model.ItemVenda;
import br.com.thordrugstore.farmacia.model.Venda;
import br.com.thordrugstore.farmacia.utils.ModuloConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author lipes
 */
public class ItemVendaDAO {
    public static boolean salvar(ItemVenda i) {
        boolean retorno = false;
        Connection conexao = null;
        String sql = null;
        PreparedStatement pst = null;
        sql = "insert into itemvenda(cod_vend,cod_prod,qtd,valor_unitario)"
                + "values(?,?,?,?)";
        try {
            conexao = ModuloConexao.conector();
 
                pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pst.setInt(1, i.getVenda().getCodigoCompra());
                pst.setInt(2, i.getProduto().getCodProduto());
                pst.setInt(3, i.getQuantidade());
                pst.setDouble(4, i.getValorUnitario());
  

                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    retorno = true;
                    ResultSet generatedKeys = pst.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        i.setCodigoItemVenda(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Falha ao obter o ID do Item.");
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
