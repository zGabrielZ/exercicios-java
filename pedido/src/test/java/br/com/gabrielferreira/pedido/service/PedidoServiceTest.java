package br.com.gabrielferreira.pedido.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.pedido.model.Cliente;
import br.com.gabrielferreira.pedido.model.Pedido;
import br.com.gabrielferreira.pedido.model.PedidoItens;
import br.com.gabrielferreira.pedido.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {

    private PedidoService pedidoService;

    private ProdutoService produtoService;

    private ClienteService clienteService;

    @BeforeEach
    public void criarInstanticas(){
        pedidoService = new PedidoService();
        produtoService = new ProdutoService();
        clienteService = new ClienteService();
    }

    @Test
    @DisplayName("Deve validar produto quando não informar no criar pedido itens")
    void deveValidarProdutoCriarPedidoItens(){
        Produto produto = null;
        Integer quantidade = 10;
        assertThrows(RegraDeNegocioException.class, () -> pedidoService.criarPedidoItens(produto, quantidade));
    }

    @Test
    @DisplayName("Deve validar quantidade quando não informar no criar pedido itens")
    void deveValidarQuantidadeCriarPedidoItens(){
        Produto produto = produtoService.criarProduto("Tomate", toBigDecimal(10.00));
        Integer quantidade = null;
        assertThrows(RegraDeNegocioException.class, () -> pedidoService.criarPedidoItens(produto, quantidade));
    }

    @Test
    @DisplayName("Deve validar quantidade quando informar valor negativo no criar pedido itens")
    void deveValidarQuantidadeNegativoCriarPedidoItens(){
        Produto produto = produtoService.criarProduto("Tomate", toBigDecimal(10.00));
        Integer quantidade = -10;
        assertThrows(RegraDeNegocioException.class, () -> pedidoService.criarPedidoItens(produto, quantidade));
    }

    @Test
    @DisplayName("Deve criar pedido itens")
    void deveCriarPedidoItens(){
        Produto produto = produtoService.criarProduto("Tomate", toBigDecimal(10.00));
        PedidoItens pedidoItens = pedidoService.criarPedidoItens(produto, 10);

        assertNotNull(pedidoItens.getId());
        assertEquals(10, pedidoItens.getQuantidade());
        assertEquals(toBigDecimal(10.00), pedidoItens.getPreco());
        assertEquals(produto.getId(), pedidoItens.getProduto().getId());
        assertEquals(toBigDecimal(100.00), pedidoItens.getSubTotal());
    }

    @Test
    @DisplayName("Deve validar status quando não informar no criar pedido")
    void deveValidarStatusCriarPedido(){
        String status = getStringNula();
        Cliente cliente = null;
        List<PedidoItens> pedidoItens = new ArrayList<>();
        assertThrows(RegraDeNegocioException.class, () -> pedidoService.criarPedido(status, cliente, pedidoItens));
    }

    @Test
    @DisplayName("Deve validar status quando informar errado no criar pedido")
    void deveValidarStatusNaoEncontradoCriarPedido(){
        String status = getStringNaoNula();
        Cliente cliente = null;
        List<PedidoItens> pedidoItens = new ArrayList<>();
        assertThrows(RegraDeNegocioException.class, () -> pedidoService.criarPedido(status, cliente, pedidoItens));
    }

    @Test
    @DisplayName("Deve validar cliente quando não informar no criar pedido")
    void deveValidarClienteCriarPedido(){
        String status = "PROCESSANDO";
        Cliente cliente = null;
        List<PedidoItens> pedidoItens = new ArrayList<>();
        assertThrows(RegraDeNegocioException.class, () -> pedidoService.criarPedido(status, cliente, pedidoItens));
    }

    @Test
    @DisplayName("Deve validar pedido itens quando não informar no criar pedido")
    void deveValidarPedidoItensCriarPedido(){
        String status = "PROCESSANDO";
        Cliente cliente = clienteService.criarCliente("José", "jose@email.com", "20/10/2000");
        List<PedidoItens> pedidoItens = new ArrayList<>();
        assertThrows(RegraDeNegocioException.class, () -> pedidoService.criarPedido(status, cliente, pedidoItens));
    }

    @Test
    @DisplayName("Deve criar pedido")
    void deveCriarPedido(){
        Cliente cliente = clienteService.criarCliente("José", "jose@email.com", "20/10/2000");

        Produto produto1 = produtoService.criarProduto("Tomate", toBigDecimal(10.00));
        PedidoItens pedidoItens1 = pedidoService.criarPedidoItens(produto1, 10);

        Produto produto2 = produtoService.criarProduto("Uva", toBigDecimal(5.00));
        PedidoItens pedidoItens2 = pedidoService.criarPedidoItens(produto2, 5);

        Pedido pedido = pedidoService.criarPedido("PROCESSANDO", cliente, Arrays.asList(pedidoItens1, pedidoItens2));
        String imprimir = pedidoService.imprimirPedido(pedido);

        assertNotNull(pedido.getId());
        assertNotNull(imprimir);
        assertEquals(toBigDecimal(125.00), pedido.getTotal());
    }

    private String getStringNula(){
        return null;
    }

    private String getStringNaoNula(){
        return "teste";
    }
}
