package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.utils.DataUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoUsadoTest {

    @Test
    @DisplayName("Deve criar produto usado")
    void deveCriarProdutoUsado(){
        ProdutoUsado produto = new ProdutoUsado(UUID.randomUUID(), "Iphone 6s", toBigDecimal(200.00), toDataBrasil("20/10/2022"));

        assertNotNull(produto.getId());
        assertEquals("Iphone 6s", produto.getNome());
        assertEquals(toBigDecimal(200.00), produto.getPreco());
        assertEquals(toDataBrasil("20/10/2022"), produto.getDataFabricada());
    }

    @Test
    @DisplayName("Deve imprimir produto usado")
    void deveImprimirProdutoUsado(){
        ProdutoUsado produto = new ProdutoUsado(UUID.randomUUID(), "Iphone 6s", toBigDecimal(200.00), toDataBrasil("20/10/2022"));

        String resultado = produto.getPrecoTag();

        assertNotNull(resultado);
    }

    @Test
    @DisplayName("Deve validar data produto quando não informar")
    void deveValidarDataProduto(){
        try {
            new ProdutoUsado(UUID.randomUUID(), "Iphone 6s", toBigDecimal(200.00), null);
            fail("Deveria lançar a exceção da data nula");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar data"));
        }
    }

    @Test
    @DisplayName("Deve validar data produto quando informar valor maior que data atual")
    void deveValidarDataDepoisDataAtualProduto(){
        try {
            new ProdutoUsado(UUID.randomUUID(), "Iphone 6s", toBigDecimal(200.00), toDataAtualBrasil().plusDays(5L));
            fail("Deveria lançar a exceção da data maior que data atual");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("A data fabricada não pode ser maior que a data atual"));
        }
    }

}
