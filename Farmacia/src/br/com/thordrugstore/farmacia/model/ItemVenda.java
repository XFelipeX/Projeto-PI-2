package br.com.thordrugstore.farmacia.model;

/**
 * Classe que representa o ItemVenda
 * @author JHK
 */
public class ItemVenda {
    private int codigoItemVenda;
    private Venda venda;
    private Produto produto;
    private int quantidade;
    private Double valorUnitario;
    private Double valorTotal;

    public ItemVenda() {
        this.codigoItemVenda = 0;
        this.venda = new Venda();
        this.produto = new Produto();
        this.quantidade = 0;
        this.valorUnitario = 0.0;
    }

    public ItemVenda(int codigo) {
        this.codigoItemVenda = codigo;
        this.venda = new Venda();
        this.produto = new Produto();
        this.quantidade = 0;
        this.valorUnitario = 0.0;
    }

    public int getCodigoItemVenda() {
        return codigoItemVenda;
    }

    public void setCodigoItemVenda(int codigoItemVenda) {
        this.codigoItemVenda = codigoItemVenda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return getProduto().getNomeProduto();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ItemVenda) {
            ItemVenda iv = (ItemVenda) o;
            if (iv.getCodigoItemVenda() == this.getCodigoItemVenda()) {
                return true;
            }
        }
        return false;
    }

    public Double getValorTotal() {
        return this.getValorUnitario()*this.quantidade;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
