package br.com.gabrielferreira.pedido.main;

import br.com.gabrielferreira.pedido.model.Cliente;
import br.com.gabrielferreira.pedido.model.Pedido;
import br.com.gabrielferreira.pedido.model.PedidoItens;
import br.com.gabrielferreira.pedido.model.Produto;
import br.com.gabrielferreira.pedido.service.ClienteService;
import br.com.gabrielferreira.pedido.service.PedidoService;
import br.com.gabrielferreira.pedido.service.ProdutoService;
import lombok.Generated;

import java.util.Arrays;
import java.util.List;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;

@Generated
public class AplicacaoPedido {

    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        PedidoService pedidoService = new PedidoService();

        Cliente cliente = clienteService.criarCliente("José da Silva", "jose@email.com", "10/05/1995");

        Produto produto1 = produtoService.criarProduto("TV", toBigDecimal(1000.00));
        Produto produto2 = produtoService.criarProduto("Mouse", toBigDecimal(40.00));

        PedidoItens pedidoItens1 = pedidoService.criarPedidoItens(produto1, 1);
        PedidoItens pedidoItens2 = pedidoService.criarPedidoItens(produto2, 2);

        List<PedidoItens> pedidoItens = Arrays.asList(pedidoItens1, pedidoItens2);

        Pedido pedido = pedidoService.criarPedido("PROCESSANDO", cliente, pedidoItens);

        System.out.println(pedidoService.imprimirPedido(pedido));
    }
}
