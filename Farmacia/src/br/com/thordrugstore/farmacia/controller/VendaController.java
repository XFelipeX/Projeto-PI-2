package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.VendaDAO;
import br.com.thordrugstore.farmacia.model.Cliente;
import br.com.thordrugstore.farmacia.model.Venda;
import java.util.Date;

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
}
