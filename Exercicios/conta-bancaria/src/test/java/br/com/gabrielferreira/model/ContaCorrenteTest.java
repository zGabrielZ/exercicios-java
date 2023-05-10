package br.com.gabrielferreira.model;

import static org.junit.jupiter.api.Assertions.*;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.UUID;

class ContaCorrenteTest {

    @Test
    @DisplayName("Deve validar deposito quando não informar o valor")
    void deveValidarDepositoQuandoSaldoForNulo(){
        ContaBancaria contaBancaria = new ContaCorrente();
        assertThrows(RegraDeNegocioException.class, () -> contaBancaria.depositar(null));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0, -2, -3, -1.5})
    @DisplayName("Deve validar deposito quando o valor informado for menor ou igual que zero")
    void deveValidarDepositoQuandoSaldoTiverForaPeriodo(double valor){
        ContaBancaria contaBancaria = new ContaCorrente();
        assertThrows(RegraDeNegocioException.class, () -> contaBancaria.depositar(valor));
    }

    @Test
    @DisplayName("Deve depositar quando informar o valor")
    void deveDepositar(){
        ContaBancaria contaBancaria = new ContaCorrente();
        contaBancaria.setId(UUID.randomUUID());

        contaBancaria.depositar(10.00);
        contaBancaria.depositar(20.00);
        contaBancaria.depositar(30.00);

        assertEquals(60.00, contaBancaria.getSaldo());
    }

    @Test
    @DisplayName("Deve validar saque quando não informar o valor")
    void deveValidarSaqueQuandoSaldoForNulo(){
        ContaBancaria contaBancaria = new ContaCorrente();
        assertThrows(RegraDeNegocioException.class, () -> contaBancaria.sacar(null));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0, -2, -3, -1.5})
    @DisplayName("Deve validar saque quando o valor informado for menor ou igual que zero")
    void deveValidarSaqueQuandoSaldoTiverForaPeriodo(double valor){
        ContaBancaria contaBancaria = new ContaCorrente();
        assertThrows(RegraDeNegocioException.class, () -> contaBancaria.sacar(valor));
    }

    @Test
    @DisplayName("Deve validar saque quando o saldo final for maior que o saldo informado")
    void deveValidarSaqueQuandoSaldoFinalForMaiorQueSaldoInformado(){
        ContaBancaria contaBancaria = new ContaCorrente();
        contaBancaria.setId(UUID.randomUUID());

        contaBancaria.depositar(5.0);

        assertThrows(RegraDeNegocioException.class, () -> contaBancaria.sacar(10.0));
    }

    @Test
    @DisplayName("Deve sacar quando informar o valor")
    void deveSacar(){
        ContaBancaria contaBancaria = new ContaCorrente();
        contaBancaria.setId(UUID.randomUUID());

        contaBancaria.depositar(10.00);
        contaBancaria.sacar(5.00);

        assertEquals(5.00, contaBancaria.getSaldo());
    }

    @Test
    @DisplayName("Deve validar transferência quando o saldo para transferência for nulo")
    void deveValidarTransferenciaQuandoSaldoParaTransferirForNulo(){
        ContaBancaria contaBancaria = new ContaCorrente();
        ContaBancaria contaBancariaDestino = new ContaCorrente();

        assertThrows(RegraDeNegocioException.class, () -> contaBancaria.transferir(null, contaBancariaDestino));
    }

    @Test
    @DisplayName("Deve realizar transferência quando for informado corretamente")
    void deveRealizarTransferencia(){
        ContaBancaria contaBancariaOrigem = new ContaCorrente();
        contaBancariaOrigem.setId(UUID.randomUUID());

        ContaBancaria contaBancariaDestino = new ContaCorrente();
        contaBancariaDestino.setId(UUID.randomUUID());

        contaBancariaOrigem.depositar(50.00);
        contaBancariaOrigem.depositar(100.00);

        contaBancariaOrigem.transferir(30.00, contaBancariaDestino);

        assertEquals(120.00, contaBancariaOrigem.getSaldo());
        assertEquals(30.00, contaBancariaDestino.getSaldo());
    }

    @Test
    @DisplayName("Deve calcular o saldo final da conta corrente")
    void deveCalcularSaldoFinal(){
        ContaBancaria contaBancariaOrigem = new ContaCorrente();
        contaBancariaOrigem.setId(UUID.randomUUID());

        contaBancariaOrigem.depositar(50.00);
        contaBancariaOrigem.depositar(100.00);

        Double resultado = contaBancariaOrigem.calcularSaldoFinal();

        assertEquals(135.00, resultado);
    }
}
