package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.utils.CalculoUtils.toRetorno;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTerceirizadoTest {

    @Test
    @DisplayName("Deve criar funcionário terceirizado")
    void deveCriarFuncionario(){
        FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado(UUID.randomUUID(), "Bob", 100, toBigDecimal(15.00), toBigDecimal(200.00));

        assertNotNull(funcionario.getId());
        assertEquals("Bob", funcionario.getNome());
        assertEquals(100, funcionario.getHoras());
        assertEquals(toBigDecimal(15.00), funcionario.getValorPorHora());
        assertEquals(toBigDecimal(200.00), funcionario.getBonus());
    }

    @Test
    @DisplayName("Deve realizar pagamento ao funcionário terceirizado")
    void deveRealizarPagamentoFuncionarioTerceirizado(){
        Funcionario funcionario = new FuncionarioTerceirizado(UUID.randomUUID(), "Bob", 100, toBigDecimal(15.00), toBigDecimal(200.00));

        BigDecimal resultado = funcionario.getPagamento();

        assertEquals(toBigDecimal(1720.0), toRetorno(resultado, 1, RoundingMode.HALF_EVEN));
    }

    @Test
    @DisplayName("Deve imprimir funcionário")
    void deveImprimirFuncionarioTerceirizado(){
        Funcionario funcionario = new FuncionarioTerceirizado(UUID.randomUUID(), "Bob", 100, toBigDecimal(15.00), toBigDecimal(200.00));

        String resultado = funcionario.toString();

        assertNotNull(resultado);
    }

    @Test
    @DisplayName("Deve validar bônus quando não informar")
    void deveValidarBonus(){
        try {
            new FuncionarioTerceirizado(UUID.randomUUID(), "Bob", 100, toBigDecimal(15.00), null);
            fail("Deveria ter lançado a exceção do bônus nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar bônus"));
        }
    }

    @Test
    @DisplayName("Deve validar bônus negativo")
    void deveValidarBonusNegativo(){
        try {
            new FuncionarioTerceirizado(UUID.randomUUID(), "Bob", 100, toBigDecimal(15.00), toBigDecimal(-100.00));
            fail("Deveria ter lançado a exceção do bônus negativo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Bônus não pode ser negativo"));
        }
    }
}
