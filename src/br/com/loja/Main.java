package br.com.loja;

import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.ItemPedido;
import br.com.loja.modelo.Pedido;
import br.com.loja.modelo.Produto;
import br.com.loja.servico.ServicoDePedidos;

public class Main {

    public static void main(String[] args) {
        Produto teclado = new Produto("Teclado Mecanico", 250.00);
        Produto monitor = new Produto("Monitor 24pol", 600.00);

        ServicoDePedidos servico = new ServicoDePedidos();

        Cliente joao = new Cliente("Joao", "joao@email.com");
        Pedido pedido1 = new Pedido(1, joao);
        pedido1.adicionarItem(new ItemPedido(teclado, 1));
        servico.finalizarPedido(pedido1);

        Cliente maria = new Cliente("Maria", "maria@email.com");
        Pedido pedido2 = new Pedido(2, maria);
        pedido2.adicionarItem(new ItemPedido(monitor, 2));
        servico.finalizarPedido(pedido2);
    }
}
