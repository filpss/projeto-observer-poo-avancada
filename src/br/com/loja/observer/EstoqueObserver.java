package br.com.loja.observer;

import br.com.loja.modelo.ItemPedido;
import br.com.loja.modelo.Pedido;

public class EstoqueObserver implements PedidoObserver {

    @Override
    public void pedidoFinalizado(Pedido pedido) {
        for (ItemPedido item : pedido.getItens()) {
            System.out.printf("[ESTOQUE] -%d unidade(s) de %s.%n",
                    item.getQuantidade(), item.getProduto().getNome());
        }
    }
}
