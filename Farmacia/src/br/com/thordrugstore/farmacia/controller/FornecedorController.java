/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.FornecedorDAO;
import br.com.thordrugstore.farmacia.model.Fornecedor;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author JHK
 */
public class FornecedorController {
    
    public static boolean salvar(int fornecedorcod,String razaoSocial, String cnpj, String telComercial1, String telComercial2, String celular, String endereco, String complemento, String cidade, String uf) {
        Fornecedor obj = new Fornecedor();

        //obj.setFonecedorcod(fornecedorcod);
        obj.setRazaoSocial(razaoSocial);
        obj.setCnpj(cnpj);
        obj.setTelComercial1(telComercial1);
        obj.setTelComercial2(telComercial2);
        obj.setCelular(celular);
        obj.setEndereco(endereco);
        obj.setComplemento(complemento);
        obj.setCidade(cidade);
        obj.setUf(uf);

        return FornecedorDAO.salvar(obj);
    }
    
    public static boolean atualizar(JTable tblFornecedores, Fornecedor fornecedor) {
        boolean retorno = false;
        if(tblFornecedores.getRowCount()>0){
            if(FornecedorDAO.atualizar(fornecedor)){
                retorno =true;
            }else{
                retorno = false;
            }
            
        }else{
            retorno = false;
        }
        return retorno;
    }
    
    public static ArrayList<Fornecedor> pesquisar(){
        ArrayList<Fornecedor> listaFornecedores = FornecedorDAO.pesquisar();
        
        return listaFornecedores;
    }
    
    public static ArrayList<Fornecedor> pesquiar(String razaoSocial) throws ParseException{
        ArrayList<Fornecedor> listaFornecedores = FornecedorDAO.pesquisar(razaoSocial);
        
        return listaFornecedores;
    }
    
    public static boolean excluir(int id){
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir?","Atenção",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            return FornecedorDAO.excluir(id);
        }
        
        return false;
    }    
}
