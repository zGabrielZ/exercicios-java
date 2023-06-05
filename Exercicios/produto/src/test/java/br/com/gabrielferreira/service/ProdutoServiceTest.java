package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
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
        produtos.add(Produto.builder()
                .id(UUID.randomUUID())
                .codigo(1)
                .nome("")
                .peso(toBigDecimal(2.5))
                .dataValidade(toDataBrasil("20/12/2010"))
                .build());
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProdutos(produtos));
    }

    @Test
    @DisplayName("Deve validar nome produto quando o nome for maior que o tamanho (1 até 12)")
    void deveValidarNomeProdutoTamanho(){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(Produto.builder()
                .id(UUID.randomUUID())
                .codigo(1)
                .nome("Teste do Produto Feijão 123")
                .peso(toBigDecimal(2.5))
                .dataValidade(toDataBrasil("20/12/2010"))
                .build());
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProdutos(produtos));
    }

    @Test
    @DisplayName("Deve validar peso produto quando informar como nulo")
    void deveValidarPesoProdutoNulo(){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(Produto.builder()
                .id(UUID.randomUUID())
                .codigo(1)
                .nome("Feijão")
                .peso(null)
                .dataValidade(toDataBrasil("20/12/2010"))
                .build());
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProdutos(produtos));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -0.2, -31, -2, -3})
    @DisplayName("Deve validar peso produto quando informar como negativo")
    void deveValidarPesoProdutoNegativo(double valor){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(Produto.builder()
                .id(UUID.randomUUID())
                .codigo(1)
                .nome("Feijão")
                .peso(toBigDecimal(valor))
                .dataValidade(toDataBrasil("20/12/2010"))
                .build());
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProdutos(produtos));
    }

    @Test
    @DisplayName("Deve validar data produto quando informar como nulo")
    void deveValidarDataProdutoNulo(){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(Produto.builder()
                .id(UUID.randomUUID())
                .codigo(1)
                .nome("Feijão")
                .peso(toBigDecimal(1.0))
                .dataValidade(null)
                .build());
        assertThrows(RegraDeNegocioException.class, () -> produtoService.criarProdutos(produtos));
    }

    @Test
    @DisplayName("Deve criar produto quando informar corretamente")
    void deveCriarProduto(){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(Produto.builder()
                .id(UUID.randomUUID())
                .codigo(1)
                .nome("Feijão")
                .peso(toBigDecimal(1.0))
                .dataValidade(toDataBrasil("20/10/2022"))
                .build());

        String resultado = produtoService.criarProdutos(produtos);

        assertNotNull(resultado);
    }

    @Test
    @DisplayName("Deve imprimir produtos")
    void deveImprimirProdutos(){
        Produto produto1 = Produto.builder()
                .id(UUID.randomUUID())
                .codigo(null)
                .nome("Laranja")
                .peso(toBigDecimal(2.5))
                .dataValidade(toDataBrasil("04/10/2024"))
                .build();

        Produto produto2 = Produto.builder()
                .id(UUID.randomUUID())
                .codigo(null)
                .nome("Maça")
                .peso(toBigDecimal(3.5))
                .dataValidade(toDataBrasil("04/10/2022"))
                .build();

        Produto produto3 = Produto.builder()
                .id(UUID.randomUUID())
                .codigo(null)
                .nome("Banana")
                .peso(toBigDecimal(4.5))
                .dataValidade(toDataBrasil("04/10/2024"))
                .build();

        Produto produto4 = Produto.builder()
                .id(UUID.randomUUID())
                .codigo(null)
                .nome("Limão")
                .peso(toBigDecimal(4.5))
                .dataValidade(toDataBrasil("04/10/2024"))
                .build();

        produtoService.criarProdutos(Arrays.asList(produto1, produto2, produto3, produto4));
        List<Produto> produtos = produtoService.imprimirProdutosOrdemCrescentePeso();

        assertEquals(toBigDecimal(2.5), produtos.get(0).getPeso());
        assertEquals(toBigDecimal(3.5), produtos.get(1).getPeso());
        assertEquals(toBigDecimal(4.5), produtos.get(2).getPeso());
    }

    @Test
    @DisplayName("Deve imprimir produtos")
    void deveLimparProdutos(){
        Produto produto1 = Produto.builder()
                .id(UUID.randomUUID())
                .codigo(null)
                .nome("Laranja")
                .peso(toBigDecimal(2.5))
                .dataValidade(toDataBrasil("04/10/2024"))
                .build();

        produtoService.criarProdutos(List.of(produto1));
        List<Produto> produtos = produtoService.imprimirProdutosOrdemCrescentePeso();
        produtoService.limparProdutos();

        assertTrue(produtos.isEmpty());
    }

    @Test
    @DisplayName("Deve retornar lista vazia quando não informar nenhum produto")
    void deveImprimirProdutosVazios(){
        List<Produto> produtos = produtoService.imprimirProdutosOrdemCrescentePeso();

        assertTrue(produtos.isEmpty());
    }
}
