package br.com.gabrielferreira.conta.model;

import br.com.gabrielferreira.conta.exception.SaldoInsuficienteException;
import br.com.gabrielferreira.conta.exception.ValorInvalidoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ContaCorrenteTest {

    @Test
    @DisplayName("Deve validar deposito quando não informar o valor")
    void deveValidarDepositoQuandoSaldoForNulo(){
        ContaBancaria contaBancaria = new ContaCorrente();
        assertThrows(ValorInvalidoException.class, () -> contaBancaria.depositar(null));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0, -2, -3, -1.5})
    @DisplayName("Deve validar deposito quando o valor informado for menor ou igual que zero")
    void deveValidarDepositoQuandoSaldoTiverForaPeriodo(double valor){
        ContaBancaria contaBancaria = new ContaCorrente();
        BigDecimal valorFormatado = toBigDecimal(valor);
        assertThrows(ValorInvalidoException.class, () -> contaBancaria.depositar(valorFormatado));
    }

    @Test
    @DisplayName("Deve depositar quando informar o valor")
    void deveDepositar(){
        ContaBancaria contaBancaria = new ContaCorrente();
        contaBancaria.setId(UUID.randomUUID());

        contaBancaria.depositar(toBigDecimal(10.00));
        contaBancaria.depositar(toBigDecimal(20.00));
        contaBancaria.depositar(toBigDecimal(30.00));

        BigDecimal resultadoFinal = contaBancaria.getSaldo();
        assertEquals(toBigDecimal(60.00), resultadoFinal);
        assertNotNull(contaBancaria.getId());
        assertNotNull(contaBancaria.toString());
    }

    @Test
    @DisplayName("Deve validar saque quando não informar o valor")
    void deveValidarSaqueQuandoSaldoForNulo(){
        ContaBancaria contaBancaria = new ContaCorrente();
        assertThrows(ValorInvalidoException.class, () -> contaBancaria.sacar(null));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0, -2, -3, -1.5})
    @DisplayName("Deve validar saque quando o valor informado for menor ou igual que zero")
    void deveValidarSaqueQuandoSaldoTiverForaPeriodo(double valor){
        ContaBancaria contaBancaria = new ContaCorrente();
        BigDecimal valorFormatado = toBigDecimal(valor);
        assertThrows(ValorInvalidoException.class, () -> contaBancaria.sacar(valorFormatado));
    }

    @Test
    @DisplayName("Deve validar saque quando o saldo final for maior que o saldo informado")
    void deveValidarSaqueQuandoSaldoFinalForMaiorQueSaldoInformado(){
        ContaBancaria contaBancaria = new ContaCorrente();
        contaBancaria.setId(UUID.randomUUID());

        contaBancaria.depositar(toBigDecimal(5.0));

        BigDecimal valorFormatado = toBigDecimal(10.0);

        assertThrows(SaldoInsuficienteException.class, () -> contaBancaria.sacar(valorFormatado));
    }

    @Test
    @DisplayName("Deve sacar quando informar o valor")
    void deveSacar(){
        ContaBancaria contaBancaria = new ContaCorrente();
        contaBancaria.setId(UUID.randomUUID());

        contaBancaria.depositar(toBigDecimal(10.00));
        contaBancaria.sacar(toBigDecimal(5.00));

        BigDecimal resultadoFinal = contaBancaria.getSaldo();
        assertEquals(toBigDecimal(5.00), resultadoFinal);
    }

    @Test
    @DisplayName("Deve validar transferência quando o saldo para transferência for nulo")
    void deveValidarTransferenciaQuandoSaldoParaTransferirForNulo(){
        ContaBancaria contaBancaria = new ContaCorrente();
        ContaBancaria contaBancariaDestino = new ContaCorrente();

        assertThrows(ValorInvalidoException.class, () -> contaBancaria.transferir(null, contaBancariaDestino));
    }

    @Test
    @DisplayName("Deve realizar transferência quando for informado corretamente")
    void deveRealizarTransferencia(){
        ContaBancaria contaBancariaOrigem = new ContaCorrente();
        contaBancariaOrigem.setId(UUID.randomUUID());

        ContaBancaria contaBancariaDestino = new ContaCorrente();
        contaBancariaDestino.setId(UUID.randomUUID());

        contaBancariaOrigem.depositar(toBigDecimal(50.00));
        contaBancariaOrigem.depositar(toBigDecimal(100.00));

        contaBancariaOrigem.transferir(toBigDecimal(30.00), contaBancariaDestino);

        BigDecimal resultadoFinalOrigem = contaBancariaOrigem.getSaldo();
        BigDecimal resultadoFinalDestino = contaBancariaDestino.getSaldo();
        assertEquals(toBigDecimal(120.00), resultadoFinalOrigem);
        assertEquals(toBigDecimal(30.00), resultadoFinalDestino);
    }

    @Test
    @DisplayName("Deve calcular o saldo final da conta corrente")
    void deveCalcularSaldoFinal(){
        ContaBancaria contaBancariaOrigem = new ContaCorrente();
        contaBancariaOrigem.setId(UUID.randomUUID());

        contaBancariaOrigem.depositar(toBigDecimal(50.00));
        contaBancariaOrigem.depositar(toBigDecimal(100.00));

        BigDecimal resultado = contaBancariaOrigem.calcularSaldoFinal();

        assertEquals(toBigDecimal(135.0), resultado.setScale(1, RoundingMode.HALF_EVEN));
    }
}
