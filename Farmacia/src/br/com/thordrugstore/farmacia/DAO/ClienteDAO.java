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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
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
        sql = "insert into clientes(nome,cpf,data_nascimento,email,telefone,endereco,complemento,cidade,uf) "
                + "values(?,?,?,?,?,?,?,?,?)";
        try {
            conexao = ModuloConexao.conector();
            if (p.getNome().isEmpty() || p.getEmail().isEmpty() || p.getTelefone().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                //pst.setInt(1, p.getCodcli());
                pst.setString(1, p.getNome());
                pst.setString(2, p.getCpf());
                //pst.setDate(3, new Date(p.getDataNascimento().getTime()));
                pst.setDate(3,new Date(p.getDataNascimento().getTime()));
                pst.setString(4, p.getEmail());
                pst.setString(5, p.getTelefone());
                pst.setString(6, p.getEndereco());
                pst.setString(7, p.getComplemento());
                pst.setString(8, p.getCidade());
                pst.setString(9, p.getUf());

                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    retorno = true;
                    ResultSet generatedKeys = pst.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        p.setCodcli(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Falha ao obter o ID do cliente.");
                    }
                    //JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
                } else {
                    retorno = false;
                    //JOptionPane.showMessageDialog(null, "Error cliente não adicionado");
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

    public static boolean atualizar(Cliente p) {
        boolean retorno = false;
        Connection conexao = null;
        String sql = null;
        PreparedStatement pst = null;
        sql = "update clientes set nome =?,cpf =?,data_nascimento =?,email =?,telefone =?,endereco =?,complemento =?,cidade =?,uf =? where cod_cli=? ";

        try {
            conexao = ModuloConexao.conector();

            pst = conexao.prepareStatement(sql);
            pst.setString(1, p.getNome());
            pst.setString(2, p.getCpf());
            //pst.setDate(3, new Date(p.getDataNascimento().getTime()));
            pst.setDate(3,new Date(p.getDataNascimento().getDate()));
            pst.setString(4, p.getEmail());
            pst.setString(5, p.getTelefone());
            pst.setString(6, p.getEndereco());
            pst.setString(7, p.getComplemento());
            pst.setString(8, p.getCidade());
            pst.setString(9, p.getUf());
            pst.setInt(10, p.getCodcli());

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
        String sql = "delete from clientes where cod_cli=?";
        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            int adicionado = pst.executeUpdate();

            if (adicionado > 0) {
                retorno = true;
                JOptionPane.showMessageDialog(null, "Cliente apagado com sucesso!");
            } else {
                retorno = false;
                JOptionPane.showMessageDialog(null, "Error! não foi possível apagar o cliente");
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

    public static ArrayList<Cliente> pesquisar(String nome) throws ParseException {
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select * from clientes where nome like ?;";
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);

            pst.setString(1, "%" + nome + '%');

            resultado = pst.executeQuery();

            while (resultado.next()) {
                Cliente c = new Cliente();
                c.setCodcli(resultado.getInt("cod_cli"));
                c.setNome(resultado.getString("nome"));
                c.setCpf(resultado.getString("cpf"));
                c.setDataNascimento(resultado.getDate("data_nascimento"));
                c.setEmail(resultado.getString("email"));
                c.setTelefone(resultado.getString("telefone"));
                c.setEndereco(resultado.getString("endereco"));
                c.setComplemento(resultado.getString("complemento"));
                c.setCidade(resultado.getString("cidade"));
                c.setUf(resultado.getString("uf"));

                clientes.add(c);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            clientes = null;
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
        return clientes;
    }

    public static ArrayList<Cliente> pesquisar() {
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select * from clientes;";
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);

            resultado = pst.executeQuery();

            while (resultado.next()) {
                Cliente c = new Cliente();
                c.setCodcli(resultado.getInt("cod_cli"));
                c.setNome(resultado.getString("nome"));
                c.setCpf(resultado.getString("cpf"));
                c.setDataNascimento(resultado.getDate("data_nascimento"));
                c.setEmail(resultado.getString("email"));
                c.setTelefone(resultado.getString("telefone"));
                c.setEndereco(resultado.getString("endereco"));
                c.setComplemento(resultado.getString("complemento"));
                c.setCidade(resultado.getString("cidade"));
                c.setUf(resultado.getString("uf"));

                clientes.add(c);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            clientes = null;
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
        return clientes;
    }
}
