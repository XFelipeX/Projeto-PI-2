/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.DAO;

import br.com.thordrugstore.farmacia.model.Cliente;
import br.com.thordrugstore.farmacia.model.Fornecedor;
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
 *
 * @author JHK
 */
public class FornecedorDAO {

    public static boolean salvar(Fornecedor f) {
        boolean retorno = false;
        Connection conexao = null;
        String sql = null;
        PreparedStatement pst = null;
        sql = "insert into fornecedores(razao_social,cnpj,telefone1,telefone2,celular,endereco,complemento,cidade,uf) "
                + "values(?,?,?,?,?,?,?,?,?)";
        try {
            conexao = ModuloConexao.conector();
            if (f.getRazaoSocial().isEmpty() || f.getCnpj().isEmpty() || f.getTelComercial1().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                // pst.setInt(1, f.getFonecedorcod());
                pst.setString(1, f.getRazaoSocial());
                pst.setString(2, f.getCnpj());
                pst.setString(3, f.getTelComercial1());
                pst.setString(4, f.getTelComercial2());
                pst.setString(5, f.getCelular());
                pst.setString(6, f.getEndereco());
                pst.setString(7, f.getComplemento());
                pst.setString(8, f.getCidade());
                pst.setString(9, f.getUf());

                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    retorno = true;
                    ResultSet generatedKeys = pst.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        f.setFonecedorcod(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Falha ao obter o ID do cliente.");
                    }
                    //JOptionPane.showMessageDialog(null, "Fornecedor adicionado com sucesso");                
                } else {
                    retorno = false;
                    //JOptionPane.showMessageDialog(null, "Error Fornecedor não adicionado");
                }
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

    public static boolean atualizar(Fornecedor f) {
        boolean retorno = false;
        Connection conexao = null;
        String sql = null;
        PreparedStatement pst = null;
        sql = "update fornecedores set razao_social =?,cnpj =?,telefone1 =?,telefone2 =?,celular =?,endereco =?,complemento =?,cidade =?,uf =? where cod_forn=? ";

        try {
            conexao = ModuloConexao.conector();

            pst = conexao.prepareStatement(sql);
            pst.setString(1, f.getRazaoSocial());
            pst.setString(2, f.getCnpj());
            pst.setString(3, f.getTelComercial1());
            pst.setString(4, f.getTelComercial2());
            pst.setString(5, f.getCelular());
            pst.setString(6, f.getEndereco());
            pst.setString(7, f.getComplemento());
            pst.setString(8, f.getCidade());
            pst.setString(9, f.getUf());
            pst.setInt(10, f.getFonecedorcod());

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

    public static boolean excluir(int id) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "delete from fornecedores where cod_forn =?";
        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            int adicionado = pst.executeUpdate();

            if (adicionado > 0) {
                retorno = true;
                JOptionPane.showMessageDialog(null, "Fornecedor apagado com sucesso!");
            } else {
                retorno = false;
                JOptionPane.showMessageDialog(null, "Error! não foi possível apagar o fornecedor");
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

    public static ArrayList<Fornecedor> pesquisar(String razaoSocial) throws ParseException {
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select * from fornecedores where razao_social like ?;";
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);

            pst.setString(1, "%" + razaoSocial + '%');

            resultado = pst.executeQuery();

            while (resultado.next()) {
                Fornecedor f = new Fornecedor();
                f.setFonecedorcod(resultado.getInt("cod_forn"));
                f.setRazaoSocial(resultado.getString("razao_social"));
                f.setCnpj(resultado.getString("cnpj"));
                f.setTelComercial1(resultado.getString("telefone1"));
                f.setTelComercial2(resultado.getString("telefone2"));
                f.setCelular(resultado.getString("celular"));
                f.setEndereco(resultado.getString("endereco"));
                f.setComplemento(resultado.getString("complemento"));
                f.setCidade(resultado.getString("cidade"));
                f.setUf(resultado.getString("uf"));

                fornecedores.add(f);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            fornecedores = null;
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
        return fornecedores;
    }

    public static ArrayList<Fornecedor> pesquisar() {
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select * from fornecedores;";
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);

            resultado = pst.executeQuery();

            while (resultado.next()) {
                Fornecedor f = new Fornecedor();
                f.setFonecedorcod(resultado.getInt("cod_forn"));
                f.setRazaoSocial(resultado.getString("razao_social"));
                f.setCnpj(resultado.getString("cnpj"));
                f.setTelComercial1(resultado.getString("telefone1"));
                f.setTelComercial2(resultado.getString("telefone2"));
                f.setCelular(resultado.getString("celular"));
                f.setEndereco(resultado.getString("endereco"));
                f.setComplemento(resultado.getString("complemento"));
                f.setCidade(resultado.getString("cidade"));
                f.setUf(resultado.getString("uf"));

                fornecedores.add(f);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            fornecedores = null;
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
        return fornecedores;
    }
}
