/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.ClienteDAO;
import br.com.thordrugstore.farmacia.model.Cliente;

/**
 *
 * @author lipes
 */
public class ClienteController {
    public static boolean salvar(int codcli,String nome,String cpf,String data,String email,String telefone, String endereco, String complemento,String cidade,String uf){
        Cliente obj = new Cliente();
        
        obj.setCodcli(codcli);
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
}
