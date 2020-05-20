/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.ClienteDAO;
import br.com.thordrugstore.farmacia.model.Cliente;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lipes
 */
public class ClienteController {

    public static boolean salvar(String nome, String cpf, String data, String email, String telefone, String endereco, String complemento, String cidade, String uf) {
        Cliente obj = new Cliente();

        //obj.setCodcli(codcli);
        obj.setNome(nome);
        obj.setCpf(cpf);
        obj.setDataNascimento(data);
        obj.setEmail(email);
        obj.setTelefone(telefone);
        obj.setEndereco(endereco);
        obj.setComplemento(complemento);
        obj.setCidade(cidade);
        obj.setUf(uf);

        return ClienteDAO.salvar(obj);

    }

    public static boolean atualizar(JTable tblClientes, Cliente cliente) {
        boolean retorno = false;
        if (tblClientes.getRowCount() > 0) {
            if (ClienteDAO.atualizar(cliente)) {
                retorno = true;
            } else {
                retorno = false;
            }

        } else {
            retorno = false;
        }

        return retorno;

    }

    public static ArrayList<Cliente> pesquisar() {
        ArrayList<Cliente> listaClientes = ClienteDAO.pesquisar();

        return listaClientes;
    }

    public static ArrayList<Cliente> pesquisar(String nome) throws ParseException {
        ArrayList<Cliente> listaClientes = ClienteDAO.pesquisar(nome);

        return listaClientes;
    }

    public static boolean excluir(int id) {
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            return ClienteDAO.excluir(id);
        }

        return false;
    }
}
