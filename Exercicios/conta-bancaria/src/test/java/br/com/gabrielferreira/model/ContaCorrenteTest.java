package br.com.gabrielferreira.model;

import static org.junit.jupiter.api.Assertions.*;

import br.com.gabrielferreira.exception.SaldoInsuficienteException;
import br.com.gabrielferreira.exception.ValorInvalidoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

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
        BigDecimal valorFormatado = BigDecimal.valueOf(valor);
        assertThrows(ValorInvalidoException.class, () -> contaBancaria.depositar(valorFormatado));
    }

    @Test
    @DisplayName("Deve depositar quando informar o valor")
    void deveDepositar(){
        ContaBancaria contaBancaria = new ContaCorrente();
        contaBancaria.setId(UUID.randomUUID());

        contaBancaria.depositar(BigDecimal.valueOf(10.00));
        contaBancaria.depositar(BigDecimal.valueOf(20.00));
        contaBancaria.depositar(BigDecimal.valueOf(30.00));

        BigDecimal resultadoFinal = contaBancaria.getSaldo();
        assertEquals(BigDecimal.valueOf(60.00), resultadoFinal);
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
        BigDecimal valorFormatado = BigDecimal.valueOf(valor);
        assertThrows(ValorInvalidoException.class, () -> contaBancaria.sacar(valorFormatado));
    }

    @Test
    @DisplayName("Deve validar saque quando o saldo final for maior que o saldo informado")
    void deveValidarSaqueQuandoSaldoFinalForMaiorQueSaldoInformado(){
        ContaBancaria contaBancaria = new ContaCorrente();
        contaBancaria.setId(UUID.randomUUID());

        contaBancaria.depositar(BigDecimal.valueOf(5.0));

        BigDecimal valorFormatado = BigDecimal.valueOf(10.0);

        assertThrows(SaldoInsuficienteException.class, () -> contaBancaria.sacar(valorFormatado));
    }

    @Test
    @DisplayName("Deve sacar quando informar o valor")
    void deveSacar(){
        ContaBancaria contaBancaria = new ContaCorrente();
        contaBancaria.setId(UUID.randomUUID());

        contaBancaria.depositar(BigDecimal.valueOf(10.00));
        contaBancaria.sacar(BigDecimal.valueOf(5.00));

        BigDecimal resultadoFinal = contaBancaria.getSaldo();
        assertEquals(BigDecimal.valueOf(5.00), resultadoFinal);
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

        contaBancariaOrigem.depositar(BigDecimal.valueOf(50.00));
        contaBancariaOrigem.depositar(BigDecimal.valueOf(100.00));

        contaBancariaOrigem.transferir(BigDecimal.valueOf(30.00), contaBancariaDestino);

        BigDecimal resultadoFinalOrigem = contaBancariaOrigem.getSaldo();
        BigDecimal resultadoFinalDestino = contaBancariaDestino.getSaldo();
        assertEquals(BigDecimal.valueOf(120.00), resultadoFinalOrigem);
        assertEquals(BigDecimal.valueOf(30.00), resultadoFinalDestino);
    }

    @Test
    @DisplayName("Deve calcular o saldo final da conta corrente")
    void deveCalcularSaldoFinal(){
        ContaBancaria contaBancariaOrigem = new ContaCorrente();
        contaBancariaOrigem.setId(UUID.randomUUID());

        contaBancariaOrigem.depositar(BigDecimal.valueOf(50.00));
        contaBancariaOrigem.depositar(BigDecimal.valueOf(100.00));

        BigDecimal resultado = contaBancariaOrigem.calcularSaldoFinal();

        assertEquals(BigDecimal.valueOf(135.0), resultado.setScale(1, RoundingMode.HALF_EVEN));
    }

    @Test
    @DisplayName("Deve comparar conta corrente quando não forem iguais")
    void deveCompararContaCorrenteNaoIguais(){
        ContaBancaria contaBancaria1 = new ContaCorrente();
        contaBancaria1.setId(UUID.randomUUID());

        ContaBancaria contaBancaria2 = new ContaCorrente();
        contaBancaria2.setId(UUID.randomUUID());

        assertNotEquals(contaBancaria1, contaBancaria2);
        assertNotEquals(contaBancaria1.hashCode(), contaBancaria2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar conta corrente quando forem iguais")
    void deveCompararContaCorrenteIguais(){
        UUID id = UUID.randomUUID();
        ContaBancaria contaBancaria1 = new ContaCorrente();
        contaBancaria1.setId(id);

        ContaBancaria contaBancaria2 = new ContaCorrente();
        contaBancaria2.setId(id);

        assertEquals(contaBancaria1, contaBancaria2);
        assertEquals(contaBancaria1.hashCode(), contaBancaria2.hashCode());
    }
}
