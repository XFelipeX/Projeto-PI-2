/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.FuncionarioDAO;
import br.com.thordrugstore.farmacia.model.Funcionario;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author lipes
 */
public class FuncionarioController {

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


    public static boolean excluir(int id) {
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            return FuncionarioDAO.excluir(id);
        }
        return false;
    }
}
