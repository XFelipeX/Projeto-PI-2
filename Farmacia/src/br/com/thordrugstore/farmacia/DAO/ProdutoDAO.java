package br.com.thordrugstore.farmacia.DAO;

import br.com.thordrugstore.farmacia.model.Produto;
import br.com.thordrugstore.farmacia.utils.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *Classe para interagir com o banco de dados
 * 
 * @see controller.ProdutoController
 **/
public class ProdutoDAO {
    /**
     *Método para salvar produto no banco de dados
     * @param x objeto do tipo Produto
     * @see model.Produto
     * @return boolean true = sucesso, false = falha
     **/
        
    public static boolean salvar(Produto x) {
        boolean retorno = false;
        Connection conexao = null;
        String sql = null;
        PreparedStatement pst = null;
        sql = "insert into produtos(nome_prod,desc_prod,val_unit,qtd_prod) "
                + "values(?,?,?,?)";
        try {
            conexao = ModuloConexao.conector();
                pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
                pst.setString(1, x.getNomeProduto());
                pst.setString(2, x.getDescricao());
                pst.setDouble(3,  x.getValor());
                pst.setInt(4, x.getQtdProduto());

                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    retorno = true;
                    ResultSet generatedKeys = pst.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        x.setCodProduto(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Falha ao obter o ID do produto.");
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
     * Método para atualizar produtos no banco de dados
     * @param x objeto do tipo Produto
     * @return boolean true = sucesso, false = falha
     */
    public static boolean atualizar(Produto x) {
        boolean retorno = false;
        Connection conexao = null;
        String sql = null;
        PreparedStatement pst = null;
        sql = "update produtos set nome_prod =?,desc_prod =?,val_unit =?,qtd_prod =? where cod_produto =? ";

        try {
            conexao = ModuloConexao.conector();

            pst = conexao.prepareStatement(sql);
            pst.setString(1, x.getNomeProduto());
            pst.setString(2, x.getDescricao());
            pst.setDouble(3,  x.getValor());
            pst.setInt(4, x.getQtdProduto());
          
            pst.setInt(5, x.getCodProduto());

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
    /**
     * Método para atualizar quantidade de produto do banco de dados
     * @param p objeto do tipo produto
     * @return boolean true = sucesso, false = falha
     */
    public static boolean atualizarQtd(Produto p){
         boolean retorno = false;
        Connection conexao = null;
        String sql = null;
        PreparedStatement pst = null;
        sql = "update produtos set qtd_prod =? where cod_produto =? ";

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, p.getQtdProduto());        
            pst.setInt(2, p.getCodProduto());

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
    /**
     * Método para excluir um produto do banco de dados
     * @param id chave primária/ código de produto do tipo inteiro
     * @return boolean true = sucesso, false = falha
     */
    public static boolean excluir(int id) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "delete from produtos where cod_produto =?";
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
    /**
     * Método para pesquisar um produto por nome
     * @param nomeProduto do produto do tipo String
     * @return uma lista com os objetos Produto do tipo ArrayList 
     */
    public static ArrayList<Produto> pesquisar(String nomeProduto) throws ParseException {
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select * from produtos where nome_prod like ?;";
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);

            pst.setString(1, "%" + nomeProduto + '%');

            resultado = pst.executeQuery();

            while (resultado.next()) {
                Produto x = new Produto();
                x.setCodProduto(resultado.getInt("cod_produto"));
                x.setNomeProduto(resultado.getString("nome_prod"));
                x.setDescricao(resultado.getString("desc_prod"));
                x.setValor(resultado.getDouble("val_unit"));
                x.setQtdProduto(resultado.getInt("qtd_prod"));
                
                produtos.add(x);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            produtos = null;
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
        return produtos;
    }
/**
 * Método para pesquisar um produto
 * @return uma lista com os objetos produtos do tipo ArrayList
 */
    public static ArrayList<Produto> pesquisar() {
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select * from produtos;";
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);

            resultado = pst.executeQuery();

            while (resultado.next()) {
                Produto x = new Produto();
               
                x.setCodProduto(resultado.getInt("cod_produto"));
                x.setNomeProduto(resultado.getString("nome_prod"));
                x.setDescricao(resultado.getString("desc_prod"));
                x.setValor(resultado.getDouble("val_unit"));
                x.setQtdProduto(resultado.getInt("qtd_prod"));
                
                produtos.add(x);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            produtos = null;
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
        return produtos;
    }
    /**
     * Método para pesquisar quantidade de produto
     * @return uma lista com os objetos quantidade de produto do tipo ArrayList
     */
    public static Produto pesquisaSimples(int cod){
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select qtd_prod from produtos where cod_produto = ?;";
        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);

            pst.setInt(1,  cod);

            resultado = pst.executeQuery();

            if(resultado.next()) {
                Produto x = new Produto();
                x.setQtdProduto(resultado.getInt("qtd_prod"));           
                return x;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
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
        return null;
    }
}
