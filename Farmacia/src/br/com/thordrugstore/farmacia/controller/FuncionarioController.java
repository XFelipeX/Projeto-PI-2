package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.FuncionarioDAO;
import br.com.thordrugstore.farmacia.model.Funcionario;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * Classe que controla o fluxo de dados da classe funcionario
 * @see model.Funcionario
 * @see DAO.FuncionarioDAO
 * @author Felipe
 */
public class FuncionarioController {
    /**
     * Método para construir um objeto do tipo Funcionario
     * @param user identificação do usuário do tipo String
     * @param perfil tipo de perfil admin/usuario do tipo String
     * @param senha do usuario do tipo String
     * @param nome do usuário do tipo String
     * @param cpf do usuário do tipo String
     * @param logradouro do funcionário do tipo String
     * @param num numero da casa/apartamento do tipo String
     * @param complemento do tipo String
     * @param uf unidade da federação do tipo String
     * @param telefone telefone do usuário do tipo String
     * @param email do usuário do tipo String
     * @param funcao do usuário do tipo String 
     * @param salario do tipo Double
     * @return boolean true = sucesso , false = falha
     */
    public static boolean salvar(String user,String perfil, String senha, String nome, String cpf, String logradouro, String num, String complemento, String uf, String telefone, String email, String funcao, double salario) {
        Funcionario obj = new Funcionario();
        obj.setIdUsuario(user);
        obj.setPerfil(perfil);
        obj.setSenha(senha);
        obj.setNome(nome);
        obj.setCpf(cpf);
        obj.setLogradouro(logradouro);
        obj.setNum(num);
        obj.setComplemento(complemento);
        obj.setUf(uf);
        obj.setTelefone(telefone);
        obj.setEmail(email);
        obj.setFuncao(funcao);
        obj.setSalario(salario);

        return FuncionarioDAO.salvar(obj);

    }
    /**
     * Método para chamar a atualização na DAO
     * @param tblFuncionarios tabela de funcionarios do tipo JTable
     * @param func objeto do tipo Funcionario
     * @return boolean true = sucesso , false = falha
     */
    public static boolean atualizar(JTable tblFuncionarios, Funcionario func) {
        boolean retorno = false;
        if (tblFuncionarios.getRowCount() > 0) {
            if (FuncionarioDAO.atualizar(func)) {
                retorno = true;
            } else {
                retorno = false;
            }

        } else {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Método para excluir um funcionário chamando a DAO
     * @param id chave primária do tipo inteiro
     * @return boolean true = sucesso , false = falha 
     */
    public static boolean excluir(int id) {
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            return FuncionarioDAO.excluir(id);
        }
        return false;
    }
}
