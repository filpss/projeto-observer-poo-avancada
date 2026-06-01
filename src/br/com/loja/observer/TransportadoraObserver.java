package br.com.loja.observer;

import br.com.loja.modelo.Pedido;

public class TransportadoraObserver implements PedidoObserver {

    @Override
    public void pedidoFinalizado(Pedido pedido) {
        System.out.printf("[TRANSPORTADORA] Coleta agendada para o pedido #%d.%n",
                pedido.getId());
    }
}
