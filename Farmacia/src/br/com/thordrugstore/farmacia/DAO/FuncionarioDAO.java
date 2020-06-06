package br.com.thordrugstore.farmacia.DAO;

import br.com.thordrugstore.farmacia.model.Funcionario;
import br.com.thordrugstore.farmacia.utils.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe para interagir com o banco de dados
 * @author Felipe
 * @see controller.FuncionarioController
 */
public class FuncionarioDAO {
    /**
     * Método para salvar funcionario no banco de dados
     * @param f objeto do tipo Funcionario
     * @see model.Funcionario
     * @return boolean true = sucesso , false = falha
     */
    public static boolean salvar(Funcionario f) {
        boolean retorno = false;
        Connection conexao = null;
        String sql = null;
        PreparedStatement pst = null;
        sql = "insert into funcionarios(perfil,senha,nome,cpf,logradoura,num_resid,complemento,uf,telefone,email,função,salario,idUsuario) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conexao = ModuloConexao.conector();

            pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, f.getPerfil());
            pst.setString(2, f.getSenha());
            pst.setString(3, f.getNome());
            pst.setString(4, f.getCpf());
            pst.setString(5, f.getLogradouro());
            pst.setString(6, f.getNum());
            pst.setString(7, f.getComplemento());
            pst.setString(8, f.getUf());
            pst.setString(9, f.getTelefone());
            pst.setString(10, f.getEmail());
            pst.setString(11, f.getFuncao());
            pst.setDouble(12, f.getSalario());
            pst.setString(13, f.getIdUsuario());

            int adicionado = pst.executeUpdate();

            if (adicionado > 0) {
                retorno = true;
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    f.setCodfunc(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID do funcionario.");
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
     * Método para atualizar funcionario no banco de dados
     * @param f objeto do tipo Funcionario
     * @return boolean true = sucesso , false = falha
     */
    public static boolean atualizar(Funcionario f) {
        boolean retorno = false;
        Connection conexao = null;
        String sql = null;
        PreparedStatement pst = null;
        sql = "update funcionarios set perfil=?,senha=?,nome=?,cpf=?,logradoura=?,num_resid=?,complemento=?,uf=?,telefone=?,email=?,função=?,salario=?, idUsuario=? where codf=?";

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, f.getPerfil());
            pst.setString(2, f.getSenha());
            pst.setString(3, f.getNome());
            pst.setString(4, f.getCpf());
            pst.setString(5, f.getLogradouro());
            pst.setString(6, f.getNum());
            pst.setString(7, f.getComplemento());
            pst.setString(8, f.getUf());
            pst.setString(9, f.getTelefone());
            pst.setString(10, f.getEmail());
            pst.setString(11, f.getFuncao());
            pst.setDouble(12, f.getSalario());
            pst.setString(13, f.getIdUsuario());
            pst.setInt(14, f.getCodfunc());

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
     * Método para excluir um funcionário do banco de dados
     * @param id chave primária/código do funcionário do tipo inteiro
     * @return boolean true = sucesso , false = falha
     */
    public static boolean excluir(int id) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "delete from funcionarios where codf=?";
        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            int adicionado = pst.executeUpdate();

            if (adicionado > 0) {
                retorno = true;
                JOptionPane.showMessageDialog(null, "Funcionario apagado com sucesso!");
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
    /**
     * Método para pesquisar um funcionário por nome
     * @param nome do funcionário do tipo String
     * @return uma lista com os objetos Funcionario do tipo ArrayList
     */
    public static ArrayList<Funcionario> pesquisar(String nome) {
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select * from funcionarios where nome like ?;";
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);

            pst.setString(1, "%" + nome + '%');

            resultado = pst.executeQuery();

            while (resultado.next()) {
                Funcionario f = new Funcionario();
                f.setCodfunc(resultado.getInt("codf"));
                f.setIdUsuario(resultado.getString("idUsuario"));
                f.setSenha(resultado.getString("senha"));
                f.setNome(resultado.getString("nome"));
                f.setPerfil(resultado.getString("perfil"));
                f.setCpf(resultado.getString("cpf"));
                f.setEmail(resultado.getString("email"));
                f.setTelefone(resultado.getString("telefone"));
                f.setLogradouro(resultado.getString("logradoura"));
                f.setUf(resultado.getString("uf"));
                f.setSalario(resultado.getDouble("salario"));
                f.setComplemento(resultado.getString("complemento"));
                f.setFuncao(resultado.getString("função"));
                f.setNum(resultado.getString("num_resid"));
                funcionarios.add(f);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            funcionarios = null;
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
        return funcionarios;
    }
    /**
     * Método para pesquisar um funcionário
     * @return uma lista com os objetos Funcionario do tipo ArrayList
     */
    public static ArrayList<Funcionario> pesquisar() {
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "select * from funcionarios;";
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);

            resultado = pst.executeQuery();

            while (resultado.next()) {
                Funcionario f = new Funcionario();
                f.setCodfunc(resultado.getInt("codf"));
                f.setIdUsuario(resultado.getString("idUsuario"));
                f.setSenha(resultado.getString("senha"));
                f.setNome(resultado.getString("nome"));
                f.setPerfil(resultado.getString(14));
                f.setCpf(resultado.getString("cpf"));
                f.setEmail(resultado.getString("email"));
                f.setTelefone(resultado.getString("telefone"));
                f.setLogradouro("logradoura");
                f.setUf(resultado.getString("uf"));
                f.setSalario(resultado.getDouble("salario"));
                f.setComplemento(resultado.getString("complemento"));
                f.setFuncao(resultado.getString("função"));
                f.setNum(resultado.getString("num_resid"));
                funcionarios.add(f);

                funcionarios.add(f);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            funcionarios = null;
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
        return funcionarios;
    }
}
