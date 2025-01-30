package br.com.gabrielferreira.produto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    @DisplayName("Deve criar produto")
    void deveCriarProduto(){
        Produto produto = new Produto(UUID.randomUUID(), "Iphone 6s", toBigDecimal(2500.00));

        assertNotNull(produto.getId());
        assertEquals("Iphone 6s", produto.getNome());
        assertEquals(toBigDecimal(2500.00), produto.getPreco());
    }

    @Test
    @DisplayName("Deve imprimir produto")
    void deveImprimirProduto(){
        Produto produto = new Produto(UUID.randomUUID(), "Iphone 6s", toBigDecimal(2500.00));

        String resultado = produto.getPrecoTag();

        assertNotNull(resultado);
    }

    @Test
    @DisplayName("Deve validar id produto quando não informar")
    void deveValidarIdProduto(){
        try {
            new Produto(null, "Iphone 6s", toBigDecimal(2500.00));
            fail("Deveria lançar a exceção do id nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o ID"));
        }
    }

    @Test
    @DisplayName("Deve validar nome produto quando não informar")
    void deveValidarNomeProduto(){
        try {
            new Produto(UUID.randomUUID(), null, toBigDecimal(2500.00));
            fail("Deveria lançar a exceção do nome nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o nome"));
        }
    }

    @Test
    @DisplayName("Deve validar preço produto quando não informar")
    void deveValidarPrecoProduto(){
        try {
            new Produto(UUID.randomUUID(), "Iphone 6s", null);
            fail("Deveria lançar a exceção do preço nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o preço"));
        }
    }

    @Test
    @DisplayName("Deve validar preço produto quando informar valor negativo")
    void deveValidarPrecoNegativoProduto(){
        try {
            new Produto(UUID.randomUUID(), "Iphone 6s", toBigDecimal(-2600.00));
            fail("Deveria lançar a exceção do preço negativo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Preço não pode ser negativo"));
        }
    }

}
