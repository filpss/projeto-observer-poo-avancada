package br.com.loja.servico;

import br.com.loja.modelo.Pedido;
import br.com.loja.observer.PedidoObserver;

import java.util.ArrayList;
import java.util.List;

public class ServicoDePedidos {

    private final List<PedidoObserver> observers = new ArrayList<>();

    public void registrar(PedidoObserver observer) {
        observers.add(observer);
    }

    public void remover(PedidoObserver observer) {
        observers.remove(observer);
    }

    public void finalizarPedido(Pedido pedido) {
        System.out.println("==> Pedido #" + pedido.getId()
                + " finalizado (" + pedido.getCliente().getNome() + ")");

        for (PedidoObserver observer : observers) {
            observer.pedidoFinalizado(pedido);
        }

        System.out.println();
    }
}
