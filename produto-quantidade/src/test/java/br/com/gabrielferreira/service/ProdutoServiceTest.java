package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class ProdutoServiceTest {

    private ProdutoService produtoService;

    @BeforeEach
    public void criarInstancias(){
        produtoService = new ProdutoService();
    }

    @Test
    @DisplayName("Deve validar criação do produto quando informar o nome como nulo")
    void deveValidarCriarProdutoNomeNulo(){
        String nome = null;
        BigDecimal preco = BigDecimal.ZERO;
        Integer quantidade = 4;
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProduto(nome, preco, quantidade));
    }

    @Test
    @DisplayName("Deve validar criação do produto quando informar o preço como nulo")
    void deveValidarCriarProdutoPrecoNulo(){
        String nome = "Banana";
        BigDecimal preco = null;
        Integer quantidade = 4;
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProduto(nome, preco, quantidade));
    }

    @Test
    @DisplayName("Deve validar criação do produto quando informar o preço como negativo")
    void deveValidarCriarProdutoPrecoNegativo(){
        String nome = "Banana";
        BigDecimal preco = toBigDecimal(-10.5);
        Integer quantidade = 4;
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProduto(nome, preco, quantidade));
    }

    @Test
    @DisplayName("Deve validar criação do produto quando informar a quantidade como nulo")
    void deveValidarCriarProdutoQuantidadeNulo(){
        String nome = "Banana";
        BigDecimal preco = toBigDecimal(10.5);
        Integer quantidade = null;
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProduto(nome, preco, quantidade));
    }

    @Test
    @DisplayName("Deve validar criação do produto quando informar a quantidade como negativo")
    void deveValidarCriarProdutoQuantidadeNegativo(){
        String nome = "Banana";
        BigDecimal preco = toBigDecimal(10.5);
        Integer quantidade = -14;
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProduto(nome, preco, quantidade));
    }

    @Test
    @DisplayName("Deve criar produto quando infomar corretamente")
    void deveCriarProduto(){
        Produto produto = produtoService.criarProduto("Feijão", toBigDecimal(2.5), 1);

        assertNotNull(produto.getId());
        assertEquals(toBigDecimal(2.5), produto.getTotal());
    }

    @Test
    @DisplayName("Deve validar quando adicionar quantidade no produto como nulo")
    void deveValidarAdicionarQuantidadeProdutoNulo(){
        Produto produto = null;
        Integer quantidade = 10;
        assertThrows(RegraDeNegocioException.class, () -> produtoService.adicionarQuantidade(produto, quantidade));
    }

    @Test
    @DisplayName("Deve adicionar quantidade no produto quando infomar valores corretamente")
    void deveAdicionarQuantidadeProduto(){
        Produto produto = produtoService.criarProduto("Arroz", toBigDecimal(2.0), 2);

        produtoService.adicionarQuantidade(produto, 2);

        assertEquals(toBigDecimal(8.0), produto.getTotal());
    }

    @Test
    @DisplayName("Deve validar quando remover quantidade no produto como nulo")
    void deveValidarRemoverQuantidadeProdutoNulo(){
        Produto produto = null;
        Integer quantidade = 10;
        assertThrows(RegraDeNegocioException.class, () -> produtoService.removerQuantidade(produto, quantidade));
    }

    @Test
    @DisplayName("Deve validar quando remover com a nova quantidade maior que a quantidade já do produto")
    void deveValidarRemoverNovaQuantidadeMaiorQueQuantidadeProduto(){
        Produto produto = produtoService.criarProduto("Arroz", toBigDecimal(2.0), 2);
        assertThrows(RegraDeNegocioException.class, () -> produtoService.removerQuantidade(produto, 5));
    }

    @Test
    @DisplayName("Deve remover quantidade no produto quando infomar valores corretamente")
    void deveRemoverQuantidadeProduto(){
        Produto produto = produtoService.criarProduto("Arroz", toBigDecimal(2.0), 2);

        produtoService.removerQuantidade(produto, 1);

        assertEquals(toBigDecimal(2.0), produto.getTotal());
    }

    @Test
    @DisplayName("Deve imprimir status atual do produto")
    void deveImprimirStatusAtualProduto(){
        Produto produto = produtoService.criarProduto("Arroz", toBigDecimal(2.0), 2);

        produtoService.adicionarQuantidade(produto, 2);

        String status = produtoService.imprimirProduto(produto);

        assertNotNull(status);
    }
}
