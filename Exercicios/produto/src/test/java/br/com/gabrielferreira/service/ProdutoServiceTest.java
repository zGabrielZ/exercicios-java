package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.utils.DataUtils.toDataBrasil;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {

    private ProdutoService produtoService;

    @BeforeEach
    public void criarInstancias(){
        produtoService = new ProdutoService();
    }

    @Test
    @DisplayName("Deve validar produtos quando informar como nulo")
    void deveValidarProdutosNaoInformadosNulo(){
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProdutos(null));
    }

    @Test
    @DisplayName("Deve validar produtos quando informar como vazio")
    void deveValidarProdutosNaoInformadosVazio(){
        List<Produto> produtos = new ArrayList<>();
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProdutos(produtos));
    }

    @Test
    @DisplayName("Deve validar produtos quando informar algum objeto como nulo")
    void deveValidarProdutosComObjetoNulo(){
        List<Produto> produtos = new ArrayList<>();

        Produto produto = null;
        produtos.add(produto);
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProdutos(produtos));
    }

    @Test
    @DisplayName("Deve validar nome produto quando informar como vazio")
    void deveValidarNomeProdutoVazio(){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(UUID.randomUUID(), 1, "", toBigDecimal(2.5), toDataBrasil("20/12/2010")));
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProdutos(produtos));
    }

    @Test
    @DisplayName("Deve validar nome produto quando o nome for maior que o tamanho (1 até 12)")
    void deveValidarNomeProdutoTamanho(){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(UUID.randomUUID(), 1, "Teste do Produto Feijão 123", toBigDecimal(2.5), toDataBrasil("20/12/2010")));
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProdutos(produtos));
    }

    @Test
    @DisplayName("Deve validar peso produto quando informar como nulo")
    void deveValidarPesoProdutoNulo(){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(UUID.randomUUID(), 1, "Feijão", null, toDataBrasil("20/12/2010")));
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProdutos(produtos));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -0.2, -31, -2, -3})
    @DisplayName("Deve validar peso produto quando informar como negativo")
    void deveValidarPesoProdutoNegativo(double valor){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(UUID.randomUUID(), 1, "Feijão", toBigDecimal(valor), toDataBrasil("20/12/2010")));
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProdutos(produtos));
    }

    @Test
    @DisplayName("Deve validar data produto quando informar como nulo")
    void deveValidarDataProdutoNulo(){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(UUID.randomUUID(), 1, "Feijão", toBigDecimal(1.0), null));
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProdutos(produtos));
    }

    @Test
    @DisplayName("Deve criar produto quando informar corretamente")
    void deveCriarProduto(){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(UUID.randomUUID(), 1, "Feijão", toBigDecimal(1.0), toDataBrasil("20/10/2022")));

        String resultado = produtoService.criarProdutos(produtos);

        assertNotNull(resultado);
    }
}
