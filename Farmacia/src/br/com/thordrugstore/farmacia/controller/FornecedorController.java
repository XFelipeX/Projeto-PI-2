/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.FornecedorDAO;
import br.com.thordrugstore.farmacia.model.Fornecedor;

/**
 *
 * @author JHK
 */
public class FornecedorController {
    public static boolean Salvar(String razaoSocial,String cnpj,String telComercial1,
            String telComercaial2,String celular,String endereco,String complemento,String cidade,String uf){
        
        Fornecedor obj = new Fornecedor();
        
        obj.setRazaoSocial(razaoSocial);
        obj.setCnpj(cnpj);
        obj.setTelComercial1(telComercial1);
        obj.setTelComercaial2(telComercaial2);
        obj.setCelular(celular);
        obj.setEndereco(endereco);
        obj.setComplemento(complemento);
        obj.setCidade(cidade);
        obj.setUf(uf);
        
        return FornecedorDAO.salvar(obj);
    }
    
}
