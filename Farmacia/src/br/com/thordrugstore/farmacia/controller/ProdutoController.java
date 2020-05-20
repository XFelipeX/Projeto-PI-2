/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.ProdutoDAO;
import br.com.thordrugstore.farmacia.model.Produto;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Marcus
 */
public class ProdutoController {
    
    
     public static boolean salvar(int codProduto, String nomeProduto, String descricao, float valor, int qtdProduto) {
        Produto obj = new Produto();

        //BBBB
        
        obj.setNomeProduto(nomeProduto);
        obj.setDescricao(descricao);
        obj.setValor(valor);
        obj.setQtdProduto(qtdProduto);
        

        return ProdutoDAO.salvar(obj);

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

    public static ArrayList<Produto> pesquisar() {
        ArrayList<Produto> listaProdutos = ProdutoDAO.pesquisar();

        
        return listaProdutos;
    }
    public static ArrayList<Produto> pesquisar(String nomeProduto) throws ParseException{
        ArrayList<Produto> listaProdutos = ProdutoDAO.pesquisar(nomeProduto);

        
        return listaProdutos;
    }
    public static boolean excluir(int id){
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir?","Atenção",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            return ProdutoDAO.excluir(id);
        }
               
        return false;
    }

    public static boolean salvar(String nomeProduto, String descricao, String valor, String qtdProduto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
