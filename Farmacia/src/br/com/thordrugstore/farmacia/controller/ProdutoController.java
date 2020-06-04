package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.ProdutoDAO;
import br.com.thordrugstore.farmacia.model.Produto;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class ProdutoController { 
     public static boolean salvar(String nomeProduto, String descricao, Double valor, int qtdProduto) {
        Produto obj = new Produto();
        obj.setNomeProduto(nomeProduto);
        obj.setDescricao(descricao);
        obj.setValor(valor);
        obj.setQtdProduto(qtdProduto);

        if(ProdutoDAO.salvar(obj)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean atualizar(JTable tblProdutos, Produto produto) {
        boolean retorno = false;
        if(tblProdutos.getRowCount()>0)
        {   
            if(ProdutoDAO.atualizar(produto)){
                retorno = true;
            }else{
                retorno = false;
            }                     
        }else{
            retorno = false;
        }
        return retorno;
    }
    
    public static boolean atualizarQtd(Produto p){
        if(ProdutoDAO.atualizarQtd(p)){
            return true;
        }else{
            return false;
        }
    }
    public static boolean excluir(int id){
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir?","Atenção",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            return ProdutoDAO.excluir(id);
        }
               
        return false;
    }  
}
