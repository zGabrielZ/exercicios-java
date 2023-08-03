package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.toBigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoImportadoTest {

    @Test
    @DisplayName("Deve criar produto importado")
    void deveCriarProdutoImportado(){
        ProdutoImportado produto = new ProdutoImportado(UUID.randomUUID(), "Iphone 6s", toBigDecimal(2500.00), toBigDecimal(200.00));

        assertNotNull(produto.getId());
        assertEquals("Iphone 6s", produto.getNome());
        assertEquals(toBigDecimal(2500.00), produto.getPreco());
        assertEquals(toBigDecimal(200.00), produto.getTaxaCustomizada());
    }

    @Test
    @DisplayName("Deve imprimir produto importado")
    void deveImprimirProdutoImportado(){
        ProdutoImportado produto = new ProdutoImportado(UUID.randomUUID(), "Iphone 6s", toBigDecimal(2500.00), toBigDecimal(200.00));

        String resultado = produto.getPrecoTag();

        assertNotNull(resultado);
    }

    @Test
    @DisplayName("Deve validar taxa produto quando não informar")
    void deveValidarTaxaProduto(){
        try {
            new ProdutoImportado(UUID.randomUUID(), "Iphone 6s", toBigDecimal(2500.00), null);
            fail("Deveria lançar a exceção da taxa nula");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar a taxa customizada"));
        }
    }

    @Test
    @DisplayName("Deve validar taxa produto quando informar valor negativo")
    void deveValidarTaxaNegativoProduto(){
        try {
            new ProdutoImportado(UUID.randomUUID(), "Iphone 6s", toBigDecimal(2500.00), toBigDecimal(-200.00));
            fail("Deveria lançar a exceção da taxa negativo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("A taxa customizada não pode ser negativo"));
        }
    }

}
