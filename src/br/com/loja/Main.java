package br.com.loja;

import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.ItemPedido;
import br.com.loja.modelo.Pedido;
import br.com.loja.modelo.Produto;
import br.com.loja.observer.EmailObserver;
import br.com.loja.observer.EstoqueObserver;
import br.com.loja.observer.FidelidadeObserver;
import br.com.loja.observer.NotaFiscalObserver;
import br.com.loja.observer.PedidoObserver;
import br.com.loja.observer.TransportadoraObserver;
import br.com.loja.servico.ServicoDePedidos;

public class Main {

    public static void main(String[] args) {
        Produto teclado = new Produto("Teclado Mecanico", 250.00);
        Produto monitor = new Produto("Monitor 24pol", 600.00);

        ServicoDePedidos servico = new ServicoDePedidos();

        PedidoObserver fidelidade = new FidelidadeObserver();
        PedidoObserver notaFiscal = new NotaFiscalObserver();

        servico.registrar(new EmailObserver());
        servico.registrar(new EstoqueObserver());
        servico.registrar(new TransportadoraObserver());
        servico.registrar(fidelidade);

        Cliente joao = new Cliente("Joao", "joao@email.com");
        Pedido pedido1 = new Pedido(1, joao);
        pedido1.adicionarItem(new ItemPedido(teclado, 1));
        servico.finalizarPedido(pedido1);

        servico.remover(fidelidade);
        servico.registrar(notaFiscal);

        Cliente maria = new Cliente("Maria", "maria@email.com");
        Pedido pedido2 = new Pedido(2, maria);
        pedido2.adicionarItem(new ItemPedido(monitor, 2));
        servico.finalizarPedido(pedido2);
    }
}
