package br.com.loja.observer;

import br.com.loja.modelo.Pedido;

@ObserverAction
public class EmailObserver implements PedidoObserver {

    @Override
    public void pedidoFinalizado(Pedido pedido) {
        System.out.printf("[E-MAIL] Enviado para %s: pedido #%d confirmado.%n",
                pedido.getCliente().getNome(), pedido.getId());
    }
}
