package br.com.loja.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {

    private final int id;
    private final Cliente cliente;
    private final List<ItemPedido> itens = new ArrayList<>();

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public double getValorTotal() {
        return itens.stream()
                .mapToDouble(ItemPedido::getSubtotal)
                .sum();
    }
}
