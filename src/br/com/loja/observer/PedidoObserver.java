package br.com.loja.observer;

import br.com.loja.modelo.Pedido;

public interface PedidoObserver {

    void pedidoFinalizado(Pedido pedido);
}
