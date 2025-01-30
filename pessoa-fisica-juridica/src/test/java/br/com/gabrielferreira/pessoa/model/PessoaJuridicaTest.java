package br.com.gabrielferreira.pessoa.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.commons.utils.CalculoUtils.toRetorno;
import static org.junit.jupiter.api.Assertions.*;

class PessoaJuridicaTest {

    @Test
    @DisplayName("Deve validar número funcionários quando não informar")
    void deveValidarNumeroFuncionariosPessoaJuridica(){
        try {
            new PessoaJuridica(UUID.randomUUID(), "José", toBigDecimal(10.0), null);
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar números de funcionários"));
        }
    }

    @Test
    @DisplayName("Deve validar renda anual quando informar valor negativo")
    void deveValidarNumeroFuncionariosNegativoPessoaJuridica(){
        try {
            new PessoaJuridica(UUID.randomUUID(), "José", toBigDecimal(10.0), -10);
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Números de funcionários não pode ser negativo"));
        }
    }

    @Test
    @DisplayName("Deve criar pessoa juridica quando informar valores")
    void deveCriarPessoaFisica(){
        PessoaJuridica pessoa = new PessoaJuridica(UUID.randomUUID(), "SoftTech", toBigDecimal(400000.00), 25);

        assertNotNull(pessoa.toString());
        assertNotNull(pessoa.getId());
        assertEquals("SoftTech", pessoa.getNome());
        assertEquals(toBigDecimal(400000.00), pessoa.getRendaAnual());
        assertEquals(25, pessoa.getNumeroFuncionarios());
        assertEquals(toBigDecimal(56000.0), toRetorno(pessoa.getTaxaImposto(), 1, RoundingMode.HALF_EVEN));
    }
}
