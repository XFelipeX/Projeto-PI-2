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

/**
 * Classe para interagir com o banco de dados
 * @author Felipe
 * @see controller.VendaController
 */
public class VendaDAO {
    /**
     * Método para salvar uma Venda no banco de dados
     * @param p objeto do tipo Venda
     * @see model.Venda
     * @return boolean true = sucesso , false = falha
     */
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
    /**
     * Método para pesquisar todas as vendas
     * @return retorna uma lista de objetos Venda do tipo ArrayList
     */
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
    /**
     * Método para pesquisar uma venda pelo código
     * @param cod chave primaria/codigo da venda do tipo inteiro
     * @return retorna uma lista de objetos Venda do tipo ArrayList
     */
    public static ArrayList<Venda> pesquisaPorVenda(int cod) {
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
    /**
     * Método para pesquisar a venda por data
     * @param data em formato String
     * @return retorna uma lista de objetos Venda do tipo ArrayList
     */
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
    /**
     * Método para pesquisar uma venda por Cliente
     * @param cod chave primaria/codigo do tipo inteiro
     * @return retorna uma lista de objetos Venda do tipo ArrayList
     */
    public static ArrayList<Venda> pesquisaPorCliente(int cod) {
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select * from vendas where cod_cliente=?;";
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
    
    
    /**
     * Método para pesquisar uma venda por Periodo especificado
     * @param dataInicio do tipo String
     * @param dataFim do tipo String
     * @return retorna uma lista de objetos Venda do tipo ArrayList
     */
    public static ArrayList<Venda> pesquisarPeriodo(String dataInicio,String dataFim) {
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select * from vendas where data_compra between ? and ?";
        ArrayList<Venda> vendas = new ArrayList<>();

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, dataInicio);
            pst.setString(2, dataFim);
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
    /**
     * Método para excluir uma Venda
     * @param id chave estrangeira/primaria do tipo inteiro
     * @return true = sucesso, false = falha
     */
    public static boolean excluir(int id) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "delete from vendas where cod_venda =?";
        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            int adicionado = pst.executeUpdate();

            if (adicionado > 0) {
                retorno = true;                
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
