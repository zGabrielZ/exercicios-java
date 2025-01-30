package br.com.gabrielferreira.conta.service;

import br.com.gabrielferreira.conta.model.Conta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ContaServiceTest {

    private ContaService contaService;

    @BeforeEach
    public void criarInstancias(){
        contaService = new ContaService();
    }

    @Test
    @DisplayName("Deve validar número conta quando não informar valor")
    void deveValidarNumeroConta(){
        try {
            contaService.criarConta(null, "Ronaldo", toBigDecimal(10.0), toBigDecimal(10.0));
            fail("Deveria ter lançado a exceção do número conta nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar a número conta"));
        }
    }

    @Test
    @DisplayName("Deve validar número conta quando informar valor negativo")
    void deveValidarNumeroContaNegativo(){
        try {
            contaService.criarConta(-1000, "Ronaldo", toBigDecimal(10.0), toBigDecimal(10.0));
            fail("Deveria ter lançado a exceção do número conta negativo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Número conta não pode ser negativo"));
        }
    }

    @Test
    @DisplayName("Deve validar titular da conta quando não informar valor")
    void deveValidarTitular(){
        try {
            contaService.criarConta(1000, null, toBigDecimal(10.0), toBigDecimal(10.0));
            fail("Deveria ter lançado a exceção do titular nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar titular"));
        }
    }

    @Test
    @DisplayName("Deve validar balanço inicial da conta quando não informar valor")
    void deveValidarBalancoInicial(){
        try {
            contaService.criarConta(1000, "Ronaldo", null, toBigDecimal(10.0));
            fail("Deveria ter lançado a exceção do balanço inicial nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar balanço inicial"));
        }
    }

    @Test
    @DisplayName("Deve validar balanço inicial da conta quando informar valor negativo")
    void deveValidarBalancoInicialNegativo(){
        try {
            contaService.criarConta(1000, "Ronaldo", toBigDecimal(-10.00), toBigDecimal(10.0));
            fail("Deveria ter lançado a exceção do balanço inicial negativo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Balanço inicial não pode ser negativo"));
        }
    }

    @Test
    @DisplayName("Deve criar conta quando informar valores correto")
    void deveCriarConta(){
        Conta conta = contaService.criarConta(8011, "Ronaldo", toBigDecimal(100.00), toBigDecimal(5000.00));

        assertNotNull(conta.getId());
        assertEquals(8011, conta.getNumeroConta());
        assertEquals("Ronaldo", conta.getTitular());
        assertEquals(toBigDecimal(100.00), conta.getBalancoInicial());
        assertEquals(toBigDecimal(5000.00), conta.getSaqueLimite());
    }

    @Test
    @DisplayName("Deve sacar valor quando informar valores correto")
    void deveSacarConta(){
        Conta conta = contaService.criarConta(8011, "Ronaldo", toBigDecimal(1000.00), toBigDecimal(5000.00));

        contaService.saque(conta, toBigDecimal(500.00));

        assertEquals(toBigDecimal(500.00), conta.getBalancoInicial());
    }

    @Test
    @DisplayName("Deve validar saque quando for maior que o saque limite")
    void deveValidarSaqueQuandoForMaiorQueSaqueLimiteConta(){
        Conta conta = contaService.criarConta(8011, "Ronaldo", toBigDecimal(1000.00), toBigDecimal(5000.00));

        try {
            contaService.saque(conta, toBigDecimal(100000.00));
            fail("Deveria ter lançado a exceção do saque maior que saque limite");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("O saque limite não permite você sacar com este valor"));
        }
    }

    @Test
    @DisplayName("Deve validar saque quando for maior que o balanço inicial")
    void deveValidarSaqueQuandoForMaiorQueBalancoInicialConta(){
        Conta conta = contaService.criarConta(8011, "Ronaldo", toBigDecimal(1000.00), toBigDecimal(5000.00));

        try {
            contaService.saque(conta, toBigDecimal(2000.00));
            fail("Deveria ter lançado a exceção do saque maior que balanço inicial");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Balanço não suficiente"));
        }
    }

}
