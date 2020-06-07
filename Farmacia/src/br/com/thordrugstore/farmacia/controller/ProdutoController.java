package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.ProdutoDAO;
import br.com.thordrugstore.farmacia.model.Produto;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * Classe que controla o fluxo de dados da classe produto
 * @see model.Produto
 * @see DAO.ProdutoDAO
 * @author JHK
 */
public class ProdutoController { 
    /**
     * Método para construir um objeto do tipo Produto
     * @param nomeProduto identificação do produto do tipo String
     * @param descricao descrição do produto do tipo String
     * @param valor valor unitario do produto do tipo Double
     * @param qtdProduto quantidade de produto do tipo int
     * @return boolean true = sucesso, false = falha
     */
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
     /**
      * Método para chamar a atualização na DAO
      * @param tblProdutos tabela de produto do tipo JTable
      * @param produto objeto do tipo produto
      * @return boolean true = sucesso, false = falha
      */
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
    /**
     * Método para chamar a atualização de quantidade de produto na DAO
     * @param p objeto do tipo Produto
     * @return boolean true = sucesso, false = falha
     */
    public static boolean atualizarQtd(Produto p){
        if(ProdutoDAO.atualizarQtd(p)){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Método para excluir um produto chamado na DAO
     * @param id chave primária do tipo inteiro
     * @return boolean true = sucesso, false = falha
     */
    public static boolean excluir(int id){
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir?","Atenção",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            return ProdutoDAO.excluir(id);
        }
               
        return false;
    }  
}
