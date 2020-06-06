package br.com.thordrugstore.farmacia.controller;

import br.com.thordrugstore.farmacia.DAO.VendaDAO;
import br.com.thordrugstore.farmacia.model.Cliente;
import br.com.thordrugstore.farmacia.model.Venda;
import java.util.Date;


public class VendaController {
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
