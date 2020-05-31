package br.com.thordrugstore.farmacia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lipes
 */
public class Venda {
    private int codigoCompra;
    private Cliente cliente;
    private float valorBruto;
    private float desconto;
    private float total=0;
    private Date data;
    private String pagamento;
    private List<ItemVenda> itens;
    private List<ItemVenda> itensRemover;
    
    public Venda(){
        this.codigoCompra = 0;
        this.cliente = null;
        this.valorBruto = 0;
        this.desconto = 0;
        this.data = new Date();
        this.pagamento = null;
        this.itens = new ArrayList<>();
    }

    public Venda(int codigoCompra, Cliente cliente, float valorBruto, float desconto, Date data, String pagamento, List<ItemVenda> itens) {
        this.codigoCompra = codigoCompra;
        this.cliente = cliente;
        this.valorBruto = valorBruto;
        this.desconto = desconto;
        this.data = data;
        this.pagamento = pagamento;
        this.itens = itens;
    }
    public Double getValorTotal() {
        double total = 0;
        for (ItemVenda iv : itens) {
            total += (iv.getValorUnitario() * iv.getQuantidade());
        }
        return total;
    }
    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(float valorBruto) {
        this.valorBruto = valorBruto;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
    
    public void addItem(ItemVenda itemVenda) {
        itens.add(itemVenda);
    }

    public List<ItemVenda> getItensRemover() {
        return itensRemover;
    }

    public void setItensRemover(List<ItemVenda> itensRemover) {
        this.itensRemover = itensRemover;
    }
   
    public void removeItem(ItemVenda itemVenda) {
        itens.remove(itemVenda);
        if (itemVenda.getCodigoItemVenda()!= 0) {
            itensRemover.add(itemVenda);
        }
    }

    public int quantidadeItens() {
        return itens.size();
    }
}
