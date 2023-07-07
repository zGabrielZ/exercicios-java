package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class ProdutoServiceTest {

    private ProdutoService produtoService;

    @BeforeEach
    public void criarInstancias(){
        produtoService = new ProdutoService();
    }

    @Test
    @DisplayName("Deve validar criação do produto quando informar o nome nulo")
    void deveValidarCriarProdutoNomeNulo(){
        String nome = null;
        BigDecimal preco = toBigDecimal(10.0);
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProduto(nome, preco));
    }

    @Test
    @DisplayName("Deve validar criação do produto quando informar o preço nulo")
    void deveValidarCriarProdutoPrecoNulo(){
        String nome = "Banana";
        BigDecimal preco = null;
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProduto(nome, preco));
    }

    @Test
    @DisplayName("Deve validar criação do produto quando informar o preço negativo")
    void deveValidarCriarProdutoPrecoNegativo(){
        String nome = "Banana";
        BigDecimal preco = toBigDecimal(-10.0);
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProduto(nome, preco));
    }

    @Test
    @DisplayName("Deve criar produto quando informar valores corretos")
    void deveCriarProduto(){
        Produto produto = produtoService.criarProduto("Banana", toBigDecimal(10.0));

        assertNotNull(produto.getId());
        assertEquals(toBigDecimal(10.0), produto.getPreco());
    }

    @Test
    @DisplayName("Deve validar calculo média de preços quando informar nulo")
    void deveValidarCalculoMediaPrecoProdutoQuandoInformarNulo(){
        Produto[] produtos = new Produto[2];
        produtos[0] = new Produto(UUID.randomUUID(), "Banana", toBigDecimal(10.0));
        produtos[1] = null;
        assertThrows(RegraDeNegocioException.class, () -> produtoService.calcularMediaProdutoPreco(produtos));
    }

    @Test
    @DisplayName("Deve realizar calculo média de preçcos quando informar valores corretamentes")
    void deveRealizarCalculoMediaPrecoProdutos(){
        Produto[] produtos = new Produto[2];
        produtos[0] = new Produto(UUID.randomUUID(), "Banana", toBigDecimal(10.0));
        produtos[1] = new Produto(UUID.randomUUID(), "Limão", toBigDecimal(15.0));

        BigDecimal media = produtoService.calcularMediaProdutoPreco(produtos);

        assertEquals(toRetorno(toBigDecimal(12.50), 2, RoundingMode.HALF_EVEN), media);
    }
}
