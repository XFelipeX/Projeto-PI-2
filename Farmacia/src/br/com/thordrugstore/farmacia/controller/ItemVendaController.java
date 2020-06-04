/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.ItemVendaDAO;
import br.com.thordrugstore.farmacia.model.ItemVenda;
import br.com.thordrugstore.farmacia.model.Produto;
import br.com.thordrugstore.farmacia.model.Venda;
import javax.swing.JOptionPane;

/**
 *
 * @author lipes
 */
public class ItemVendaController {

    public static Boolean salvar(Venda venda, Produto produto,int qtd,Double valorUnitario) {
        ItemVenda item = new ItemVenda();
        item.setVenda(venda);
        item.setProduto(produto);
        item.setQuantidade(qtd);
        item.setValorUnitario(valorUnitario);
        if(ItemVendaDAO.salvar(item)){
            return true;
        }else{
            return false;
        }
    }
}
