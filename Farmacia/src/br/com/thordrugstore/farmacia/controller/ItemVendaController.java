package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.ItemVendaDAO;
import br.com.thordrugstore.farmacia.model.ItemVenda;
import br.com.thordrugstore.farmacia.model.Produto;
import br.com.thordrugstore.farmacia.model.Venda;

/**
 * Classe que controla o fluxo de dados da classe ItemVenda
 * @see DAO.ItemVendaDAO
 * @see model.ItemVenda
 * @author lipes
 */
public class ItemVendaController {
    /**
     * Método para construir um objeto do tipo ItemVenda
     * @param venda objeto do tipo Venda
     * @param produto objeto do tipo produto,
     * @param qtd objeto do tipo quantidade , tipo inteiro
     * @param valorUnitario do tipo Double
     * @return retorna a chave primaria/codigo da ItemVenda se salvar, senao retorna zero
     */

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
