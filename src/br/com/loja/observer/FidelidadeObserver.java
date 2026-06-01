package br.com.loja.observer;

import br.com.loja.modelo.Pedido;

public class FidelidadeObserver implements PedidoObserver {

    @Override
    public void pedidoFinalizado(Pedido pedido) {
        int pontos = (int) Math.floor(pedido.getValorTotal());
        System.out.printf("[FIDELIDADE] +%d pontos para %s.%n",
                pontos, pedido.getCliente().getNome());
    }
}
