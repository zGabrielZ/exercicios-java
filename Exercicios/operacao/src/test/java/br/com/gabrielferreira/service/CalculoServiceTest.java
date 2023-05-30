package br.com.gabrielferreira.service;

import br.com.gabrielferreira.model.enumeration.Operacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class CalculoServiceTest {

    private CalculoService calculoService;

    @BeforeEach
    public void criarInstancias(){
        calculoService = new CalculoService();
    }

    @Test
    @DisplayName("Deve validar valor parte 1 quando não informar valor")
    void deveValidarValorParteUm(){
        try {
            calculoService.calcular(null, toBigDecimal(2), Operacao.SOMA);
            fail("Deveria lançar a exceção do primeiro valor");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o valor parte 1"));
        }
    }

    @Test
    @DisplayName("Deve validar valor parte 2 quando não informar valor")
    void deveValidarValorParteDois(){
        try {
            calculoService.calcular(toBigDecimal(2), null, Operacao.SOMA);
            fail("Deveria lançar a exceção do segundo valor");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o valor parte 2"));
        }
    }

    @Test
    @DisplayName("Deve validar tipo operação quando não informar valor")
    void deveValidarTipoOperacao(){
        try {
            calculoService.calcular(toBigDecimal(2), toBigDecimal(2), null);
            fail("Deveria lançar a exceção da operação");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o tipo da operação"));
        }
    }

    @Test
    @DisplayName("Deve somar quando informar valores correto")
    void deveSomar(){
        BigDecimal retorno = calculoService.calcular(toBigDecimal(2), toBigDecimal(2), Operacao.SOMA);
        assertEquals(toBigDecimal(4), retorno);
    }

    @Test
    @DisplayName("Deve subtrair quando informar valores correto")
    void deveSubtrair(){
        BigDecimal retorno = calculoService.calcular(toBigDecimal(2), toBigDecimal(2), Operacao.SUBTRACAO);
        assertEquals(toBigDecimal(0), retorno);
    }

    @Test
    @DisplayName("Deve multiplicar quando informar valores correto")
    void deveMultiplicar(){
        BigDecimal retorno = calculoService.calcular(toBigDecimal(3), toBigDecimal(2), Operacao.MULTIPLICACAO);
        assertEquals(toBigDecimal(6), retorno);
    }

    @Test
    @DisplayName("Deve dividir quando informar valores correto")
    void deveDividir(){
        BigDecimal retorno = calculoService.calcular(toBigDecimal(2), toBigDecimal(2), Operacao.DIVISAO);
        assertEquals(toBigDecimal(1), retorno);
    }
}
