package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.ClienteDAO;
import br.com.thordrugstore.farmacia.model.Cliente;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Classe que controla o fluxo de dados da classe cliente
 * @see model.Cliente
 * @see DAO.Cliente
 * @author lipes
 */
public class ClienteController {
    /**
     * Método para construir um objeto do tipo Cliente
     * @param nome identificação do cliente do tipo String
     * @param cpf  do cliente do tipo String
     * @param data  data de nascimento do cleinte do tipo int
     * @param email do cliente do tipo String
     * @param telefone  do cliente do tipo String
     * @param endereco do cliente do tipo String
     * @param complemento do cliente do tipo String
     * @param cidade do cliente do tipo String
     * @param uf unidade de federação do tipo String
     * @return boolean true = sucesso, false = falha
     */
    public static boolean salvar(String nome, String cpf, Date data, String email, String telefone, String endereco, String complemento, String cidade, String uf) {
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
    /**
     * Método para chamar a atualização na DAO
     * @param tblClientes tabela de cliente do tipo JTable
     * @param cliente objeto do tipo Cliente
     * @return boolean true = sucesso, false = falha
     */
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
    /**
     * Método para pesquisar cliente
     * @return boolean true= sucesso, false = falha
     */
    public static ArrayList<Cliente> pesquisar() {
        ArrayList<Cliente> listaClientes = ClienteDAO.pesquisar();

        return listaClientes;
    }
    /**
     * Método para pesquisar um cliente por nome
     * @param nome do cliente do tipo String
     * @return boolean true = sucesso, false = falha
     */
    public static ArrayList<Cliente> pesquisar(String nome) throws ParseException {
        ArrayList<Cliente> listaClientes = ClienteDAO.pesquisar(nome);

        return listaClientes;
    }
    /**
     * Método para excluir um cliente chamndo a DAO
     * @param id chave primária do tipo inteiro
     * @return boolean true = sucesso, false = falha
     */
    public static boolean excluir(int id) {
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            return ClienteDAO.excluir(id);
        }

        return false;
    }
}
