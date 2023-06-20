package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.ItemCompra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static br.com.gabrielferreira.utils.CalculoUtils.toBigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ItemCompraServiceTest {

    private static final String NOME_ARQUIVO = "lista-test.txt";
    private static final String CAMINHO_COMPLETO = System.getProperty("user.home") + "/Downloads/" + NOME_ARQUIVO;


    private ItemCompraService itemCompraService;

    @BeforeEach
    public void criarInstancias(){
        itemCompraService = new ItemCompraService(new ArquivoService());
    }

    @Test
    @DisplayName("Deve validar nome produto quando for criar item compra")
    void deveValidarNomeProduto(){
        String nomeProduto = "";
        BigDecimal valor = toBigDecimal(2.5);
        assertThrows(RegraDeNegocioException.class, () -> itemCompraService.criarItemCompra(nomeProduto, valor));
    }

    @Test
    @DisplayName("Deve validar preço produto quando for criar item compra")
    void deveValidarPrecoProduto(){
        String nomeProduto = "Feijão";
        BigDecimal valor = null;
        assertThrows(RegraDeNegocioException.class, () -> itemCompraService.criarItemCompra(nomeProduto, valor));
    }

    @Test
    @DisplayName("Deve criar item compra quando informar valores corretamentes")
    void deveCriarItemCompra(){
        String nomeProduto = "Feijão";
        BigDecimal valor = toBigDecimal(4.5);

        ItemCompra itemCompra = itemCompraService.criarItemCompra(nomeProduto, valor);

        assertNotNull(itemCompra);
        assertEquals("Feijão", itemCompra.getNomeProduto());
        assertEquals(toBigDecimal(4.5), itemCompra.getPreco());
        assertNotNull(itemCompra.getDataItemCompra());
        assertNotNull(itemCompra.getId());
    }

    @Test
    @DisplayName("Deve validar geração de arquivo quando não informar nenhum valor para lista")
    void deveValidarGeracaoArquivo(){
        List<ItemCompra> itemCompras = new ArrayList<>();
        assertThrows(RegraDeNegocioException.class, () -> itemCompraService.gerarArquivoItemCompra(itemCompras, NOME_ARQUIVO));
    }

    @Test
    @DisplayName("Deve validar geração de arquivo quando tiver nulo em uma item compra")
    void deveValidarGeracaoArquivoQuandoTiverNulo(){
        List<ItemCompra> itemCompras = new ArrayList<>();
        ItemCompra itemCompra = null;
        itemCompras.add(itemCompra);

        assertThrows(RegraDeNegocioException.class, () -> itemCompraService.gerarArquivoItemCompra(itemCompras, NOME_ARQUIVO));
    }

    @Test
    @DisplayName("Deve gerar arquivo quando informar corretamente")
    void deveGerarArquivo(){
        ItemCompra itemCompra = itemCompraService.criarItemCompra("Feijão", toBigDecimal(4.5));

        itemCompraService.gerarArquivoItemCompra(List.of(itemCompra), NOME_ARQUIVO);

        File file = new File(CAMINHO_COMPLETO);
        assertTrue(file.exists());

        file.delete();
    }
}
