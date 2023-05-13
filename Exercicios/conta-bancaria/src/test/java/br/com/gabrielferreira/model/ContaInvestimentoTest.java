package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaInvestimentoTest {

    @Test
    @DisplayName("Deve calcular o saldo final da conta investimento")
    void deveCalcularSaldoFinal(){
        ContaBancaria contaBancariaOrigem = new ContaInvestimento();
        contaBancariaOrigem.setId(UUID.randomUUID());

        contaBancariaOrigem.depositar(BigDecimal.valueOf(50.00));
        contaBancariaOrigem.depositar(BigDecimal.valueOf(100.00));

        BigDecimal resultado = contaBancariaOrigem.calcularSaldoFinal();

        assertEquals(BigDecimal.valueOf(225.0), resultado.setScale(1, RoundingMode.HALF_EVEN));
    }
}
