package br.com.gabrielferreira.funcionario.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    @DisplayName("Deve criar funcionário")
    void deveCriarFuncionario(){
        Funcionario funcionario = new Funcionario(UUID.randomUUID(), "José", 10, toBigDecimal(10.00));

        assertNotNull(funcionario.getId());
        assertEquals("José", funcionario.getNome());
        assertEquals(10, funcionario.getHoras());
        assertEquals(toBigDecimal(10.00), funcionario.getValorPorHora());
    }

    @Test
    @DisplayName("Deve realizar pagamento ao funcionário")
    void deveRealizarPagamentoFuncionario(){
        Funcionario funcionario = new Funcionario(UUID.randomUUID(), "José", 10, toBigDecimal(10.00));

        BigDecimal resultado = funcionario.getPagamento();

        assertEquals(toBigDecimal(100.00), resultado);
    }

    @Test
    @DisplayName("Deve imprimir funcionário")
    void deveImprimirFuncionario(){
        Funcionario funcionario = new Funcionario(UUID.randomUUID(), "José", 10, toBigDecimal(10.00));

        String resultado = funcionario.toString();

        assertNotNull(resultado);
    }

    @Test
    @DisplayName("Deve validar id quando não informar")
    void deveValidarId(){
        try {
            new Funcionario(null, "José", 10, toBigDecimal(10.00));
            fail("Deveria ter lançado a exceção do id nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o ID"));
        }
    }

    @Test
    @DisplayName("Deve validar nome quando não informar")
    void deveValidarNome(){
        try {
            new Funcionario(UUID.randomUUID(), null, 10, toBigDecimal(10.00));
            fail("Deveria ter lançado a exceção do nome nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o nome"));
        }
    }

    @Test
    @DisplayName("Deve validar horas quando não informar")
    void deveValidarHoras(){
        try {
            new Funcionario(UUID.randomUUID(), "José", null, toBigDecimal(10.00));
            fail("Deveria ter lançado a exceção das horas nula");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar as horas"));
        }
    }

    @Test
    @DisplayName("Deve validar horas negativa")
    void deveValidarHorasNegativa(){
        try {
            new Funcionario(UUID.randomUUID(), "José", -10, toBigDecimal(10.00));
            fail("Deveria ter lançado a exceção das horas negativas");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Horas não pode ser negativo"));
        }
    }

    @Test
    @DisplayName("Deve validar valor por horas quando não informar")
    void deveValidarValorPorHoras(){
        try {
            new Funcionario(UUID.randomUUID(), "José", 10, null);
            fail("Deveria ter lançado a exceção do valor por horas nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar valor por hora"));
        }
    }

    @Test
    @DisplayName("Deve validar valor por horas negativo")
    void deveValidarValorPorHorasNegativa(){
        try {
            new Funcionario(UUID.randomUUID(), "José", 10, toBigDecimal(-10.00));
            fail("Deveria ter lançado a exceção do valor por horas negativas");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Valor por hora não pode ser negativo"));
        }
    }
}
