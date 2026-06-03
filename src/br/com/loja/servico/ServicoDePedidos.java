package br.com.loja.servico;

import br.com.loja.modelo.ItemPedido;
import br.com.loja.modelo.Pedido;

public class ServicoDePedidos {

    public void finalizarPedido(Pedido pedido) {
        System.out.println("==> Pedido #" + pedido.getId()+ " finalizado (" + pedido.getCliente().getNome() + ")");

        enviarEmailConfirmacao(pedido);
        baixarEstoque(pedido);
        agendarTransportadora(pedido);
        creditarPontosFidelidade(pedido);

        System.out.println();
    }

    private void enviarEmailConfirmacao(Pedido pedido) {
        System.out.printf("[E-MAIL] Enviado para %s: pedido #%d confirmado.%n", pedido.getCliente().getNome(), pedido.getId());
    }

    private void baixarEstoque(Pedido pedido) {
        for (ItemPedido item : pedido.getItens()) {
            System.out.printf("[ESTOQUE] -%d unidade(s) de %s.%n",item.getQuantidade(), item.getProduto().getNome());
        }
    }

    private void agendarTransportadora(Pedido pedido) {
        System.out.printf("[TRANSPORTADORA] Coleta agendada para o pedido #%d.%n",
                pedido.getId());
    }

    private void creditarPontosFidelidade(Pedido pedido) {
        int pontos = (int) Math.floor(pedido.getValorTotal());
        System.out.printf("[FIDELIDADE] +%d pontos para %s.%n", pontos, pedido.getCliente().getNome());
    }
}
