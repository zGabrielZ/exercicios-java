package br.com.gabrielferreira.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class PessoaFisicaTest {

    @Test
    @DisplayName("Deve validar id quando não informar")
    void deveValidarIdPessoaFisica(){
        try {
            new PessoaFisica(null, "José", toBigDecimal(10.0), toBigDecimal(10.0));
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o ID"));
        }
    }

    @Test
    @DisplayName("Deve validar nome quando não informar")
    void deveValidarNomePessoaFisica(){
        try {
            new PessoaFisica(UUID.randomUUID(), null, toBigDecimal(10.0), toBigDecimal(10.0));
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o nome"));
        }
    }

    @Test
    @DisplayName("Deve validar renda anual quando não informar")
    void deveValidarRendaAnualPessoaFisica(){
        try {
            new PessoaFisica(UUID.randomUUID(), "José", null, toBigDecimal(10.0));
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar renda anual"));
        }
    }

    @Test
    @DisplayName("Deve validar renda anual quando informar valor negativo")
    void deveValidarRendaAnualNegativaPessoaFisica(){
        try {
            new PessoaFisica(UUID.randomUUID(), "José", toBigDecimal(-10.0), toBigDecimal(10.0));
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Renda anual não pode ser negativo"));
        }
    }

    @Test
    @DisplayName("Deve validar gasto com saúde quando informar valor negativo")
    void deveValidarGastoComSaudeNegativaPessoaFisica(){
        try {
            new PessoaFisica(UUID.randomUUID(), "José", toBigDecimal(10.0), toBigDecimal(-10.0));
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Gasto com a saúde não pode ser negativo"));
        }
    }

    @Test
    @DisplayName("Deve criar pessoa física quando informar valores")
    void deveCriarPessoaFisica(){
        PessoaFisica pessoa = new PessoaFisica(UUID.randomUUID(), "José", toBigDecimal(50000.00), toBigDecimal(2000.00));

        assertNotNull(pessoa.toString());
        assertNotNull(pessoa.getId());
        assertEquals("José", pessoa.getNome());
        assertEquals(toBigDecimal(50000.00), pessoa.getRendaAnual());
        assertEquals(toBigDecimal(2000.00), pessoa.getGastoSaude());
        assertEquals(toBigDecimal(11500.0), toRetorno(pessoa.getTaxaImposto(), 1, RoundingMode.HALF_EVEN));
    }
}
