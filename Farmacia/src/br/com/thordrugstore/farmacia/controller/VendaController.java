/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.VendaDAO;
import br.com.thordrugstore.farmacia.model.ItemVenda;
import br.com.thordrugstore.farmacia.model.Produto;
import br.com.thordrugstore.farmacia.model.Venda;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lipes
 */
public class VendaController {
    public static ItemVenda salvar(Produto produto,Venda venda,int qtd,double valorUnitario){
       ItemVenda item = new ItemVenda();
            item.setProduto(produto);
            item.setVenda(venda);

            item.setQuantidade(qtd);
            item.setValorUnitario(valorUnitario);
        return item;
    }
}
