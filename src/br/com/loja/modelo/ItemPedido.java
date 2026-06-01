package br.com.loja.modelo;

public class ItemPedido {

    private final Produto produto;
    private final int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }
}
