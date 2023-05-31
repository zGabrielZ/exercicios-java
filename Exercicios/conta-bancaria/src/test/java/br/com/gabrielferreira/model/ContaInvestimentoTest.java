package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class ContaInvestimentoTest {

    @Test
    @DisplayName("Deve calcular o saldo final da conta investimento")
    void deveCalcularSaldoFinal(){
        ContaBancaria contaBancariaOrigem = new ContaInvestimento();
        contaBancariaOrigem.setId(UUID.randomUUID());

        contaBancariaOrigem.depositar(toBigDecimal(50.00));
        contaBancariaOrigem.depositar(toBigDecimal(100.00));

        BigDecimal resultado = contaBancariaOrigem.calcularSaldoFinal();

        assertEquals(toBigDecimal(225.0), resultado.setScale(1, RoundingMode.HALF_EVEN));
    }
}
