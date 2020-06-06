package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.ItemVendaDAO;
import br.com.thordrugstore.farmacia.model.ItemVenda;
import br.com.thordrugstore.farmacia.model.Produto;
import br.com.thordrugstore.farmacia.model.Venda;

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
