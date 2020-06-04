package br.com.thordrugstore.farmacia.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Venda {
    private int codigoCompra;
    private Cliente cliente;
    private Double valorBruto;
    private Double desconto;
    private Double total=0.0;
    private Date data;
    private String pagamento;
    private LinkedList<ItemVenda> itens;
    private LinkedList<ItemVenda> itensRemover;
    
    public Venda(){
        this.codigoCompra = 0;
        this.cliente = null;
        this.valorBruto = 0.0;
        this.desconto = 0.0;
        this.data = new Date();
        this.pagamento = null;
        this.itens = new LinkedList<>();
        this.itensRemover = new LinkedList<>();
    }

    public Venda(int codigoCompra, Cliente cliente, Double valorBruto, Double desconto, Date data, String pagamento, LinkedList<ItemVenda> itens) {
        this.codigoCompra = codigoCompra;
        this.cliente = cliente;
        this.valorBruto = valorBruto;
        this.desconto = desconto;
        this.data = data;
        this.pagamento = pagamento;
        this.itens = itens;
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

    public Double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(Double valorBruto) {
        this.valorBruto = valorBruto;
    }
    
    public void somarValorBruto(Double valorBruto){
        this.valorBruto+=valorBruto;
    }
    public void subtrairValorBruto(Double valorBruto){
        this.valorBruto-=valorBruto;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    public void somarTotal(Double total){
        this.total+=total;
    }
     public void subtrairTotal(Double total){
        this.total-=total;
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

    public void setItens(LinkedList<ItemVenda> itens) {
        this.itens = itens;
    }
    
    public void addItem(ItemVenda itemVenda) {
        itens.add(itemVenda);
    }

    public List<ItemVenda> getItensRemover() {
        return itensRemover;
    }

    public void setItensRemover(LinkedList<ItemVenda> itensRemover) {
        this.itensRemover = itensRemover;
    }
   
    public void removeItem(ItemVenda item) {
        itens.remove(item);
        itensRemover.add(item);      
    }

    public ItemVenda getLinha(int l) {
        return itens.get(l);
    }
    public int quantidadeItens() {
        return itens.size();
    }
    public int quantidadeItensRemover() {
        return itensRemover.size();
    }
}
