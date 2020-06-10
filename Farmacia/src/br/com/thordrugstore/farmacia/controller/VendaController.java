package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.ItemVendaDAO;
import br.com.thordrugstore.farmacia.DAO.VendaDAO;
import br.com.thordrugstore.farmacia.model.Cliente;
import br.com.thordrugstore.farmacia.model.Venda;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Classe que controla o fluxo de dados da classe Venda
 * @see DAO.VendaDAO
 * @see model.Venda
 * @author Felipe
 */
public class VendaController {
    /**
     * Método para construir um objeto do tipo Venda
     * @param cliente objeto do tipo Cliente
     * @param valorBruto do tipo double
     * @param desconto do tipo double
     * @param total do tipo double
     * @param data do tipo Date
     * @param pagamento do tipo String
     * @return retorna a chave primaria/codigo da Venda se salvar, senao retorna zero
     */
    public static int salvar(Cliente cliente,Double valorBruto,double desconto,double total,Date data,String pagamento){
       Venda venda = new Venda();
       venda.setCliente(cliente);
       venda.setValorBruto(valorBruto);
       venda.setDesconto(desconto);
       venda.setTotal(total);
       venda.setData(data);
       venda.setPagamento(pagamento);
       if(VendaDAO.salvar(venda)){
           return venda.getCodigoCompra();
       }else{
           return 0;
       }
    }   
    
    /**
     * Método para excluir uma venda chamando na DAO
     * @param id chave estrangeira do tipo inteiro
     * @return boolean true = sucesso, false = falha
     */
    public static boolean excluir(int id){
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir?","Atenção",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            return ItemVendaDAO.excluir(id);
        }              
        return false;
    } 
}
