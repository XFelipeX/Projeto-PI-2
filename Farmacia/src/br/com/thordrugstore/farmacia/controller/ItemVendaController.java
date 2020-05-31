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

    public static ItemVenda salvar(Produto produto, Venda venda, int qtd, double valorUnitario) {
        ItemVenda item = new ItemVenda();
        item.setProduto(produto);
        item.setVenda(venda);

        item.setQuantidade(qtd);
        item.setValorUnitario(valorUnitario);
        if(ItemVendaDAO.salvar(item)){
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Produto não adicionado!");
            return null;
        }
        return item;
    }
}
