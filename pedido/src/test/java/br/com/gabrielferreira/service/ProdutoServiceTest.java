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
    @DisplayName("Deve validar nome do produto quando não informar nada")
    void deveValidarNomeProduto(){
        String nome = null;
        BigDecimal preco = toBigDecimal(10.00);
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProduto(nome, preco));
    }

    @Test
    @DisplayName("Deve validar preço do produto quando não informar nada")
    void deveValidarPrecoProduto(){
        String nome = "Tomate";
        BigDecimal preco = null;
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProduto(nome, preco));
    }

    @Test
    @DisplayName("Deve validar preço do produto quando for negativo")
    void deveValidarPrecoNegativoProduto(){
        String nome = "Tomate";
        BigDecimal preco = toBigDecimal(-10.00);
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProduto(nome, preco));
    }

    @Test
    @DisplayName("Deve criar produto quando informar valores corretamente")
    void deveCriarProduto(){
        Produto produto = produtoService.criarProduto("Tomate", toBigDecimal(10.00));

        assertNotNull(produto.getId());
        assertEquals("Tomate", produto.getNome());
        assertEquals(toBigDecimal(10.00), produto.getPreco());
    }


}
