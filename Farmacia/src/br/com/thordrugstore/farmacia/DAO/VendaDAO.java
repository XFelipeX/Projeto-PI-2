package br.com.thordrugstore.farmacia.DAO;

import br.com.thordrugstore.farmacia.model.Cliente;
import br.com.thordrugstore.farmacia.model.Venda;
import br.com.thordrugstore.farmacia.utils.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class VendaDAO {
    public static boolean salvar(Venda p) {
        boolean retorno = false;
        Connection conexao = null;
        String sql = null;
        PreparedStatement pst = null;
        sql = "insert into vendas(cod_cliente,data_compra,valor_bruto,total,desconto,pagamento)"
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
                        throw new SQLException("Falha ao obter o ID");
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

    public static ArrayList<Venda> pesquisar() {
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select * from vendas;";
        ArrayList<Venda> vendas = new ArrayList<>();

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);

            resultado = pst.executeQuery();

            while (resultado.next()) {
                Venda x = new Venda();               
                x.setCodigoCompra(resultado.getInt("cod_venda"));
                Cliente cliente = new Cliente();
                x.setCliente(cliente);
                x.getCliente().setCodcli(resultado.getInt("cod_cliente"));
                x.setValorBruto(resultado.getDouble("valor_bruto"));
                x.setDesconto(resultado.getDouble("desconto"));
                x.setTotal(resultado.getDouble("total"));
                x.setData(resultado.getDate("data_compra"));
                x.setPagamento(resultado.getString("pagamento"));
                
                vendas.add(x);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            vendas = null;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conexao != null) {
                    conexao.close();
                }

            } catch (SQLException ex) {
            }
        }
        return vendas;
    }
    
    public static ArrayList<Venda> pesquisar(int cod) {
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select * from vendas where cod_venda=?;";
        ArrayList<Venda> vendas = new ArrayList<>();

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, cod);
            resultado = pst.executeQuery();

            while (resultado.next()) {
                Venda x = new Venda();               
                x.setCodigoCompra(resultado.getInt("cod_venda"));
                Cliente cliente = new Cliente();
                x.setCliente(cliente);
                x.getCliente().setCodcli(resultado.getInt("cod_cliente"));
                x.setValorBruto(resultado.getDouble("valor_bruto"));
                x.setDesconto(resultado.getDouble("desconto"));
                x.setTotal(resultado.getDouble("total"));
                x.setData(resultado.getDate("data_compra"));
                x.setPagamento(resultado.getString("pagamento"));
                
                vendas.add(x);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            vendas = null;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conexao != null) {
                    conexao.close();
                }

            } catch (SQLException ex) {
            }
        }
        return vendas;
    }
   
    public static ArrayList<Venda> pesquisar(String data) {
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select * from vendas where data_compra = ? ;";
        ArrayList<Venda> vendas = new ArrayList<>();

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, data);
            resultado = pst.executeQuery();

            while (resultado.next()) {
                Venda x = new Venda();               
                x.setCodigoCompra(resultado.getInt("cod_venda"));
                Cliente cliente = new Cliente();
                x.setCliente(cliente);
                x.getCliente().setCodcli(resultado.getInt("cod_cliente"));
                x.setValorBruto(resultado.getDouble("valor_bruto"));
                x.setDesconto(resultado.getDouble("desconto"));
                x.setTotal(resultado.getDouble("total"));
                x.setData(resultado.getDate("data_compra"));
                x.setPagamento(resultado.getString("pagamento"));
                
                vendas.add(x);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            vendas = null;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conexao != null) {
                    conexao.close();
                }

            } catch (SQLException ex) {
            }
        }
        return vendas;
    }
}
