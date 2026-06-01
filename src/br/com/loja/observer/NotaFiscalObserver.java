package br.com.loja.observer;

import br.com.loja.modelo.Pedido;

@ObserverAction
public class NotaFiscalObserver implements PedidoObserver {

    @Override
    public void pedidoFinalizado(Pedido pedido) {
        System.out.printf("[NOTA FISCAL] NF-e emitida para o pedido #%d.%n",
                pedido.getId());
    }
}
