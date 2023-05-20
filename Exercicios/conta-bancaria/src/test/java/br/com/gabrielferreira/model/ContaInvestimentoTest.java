package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

    @Test
    @DisplayName("Deve comparar conta investimento quando não forem iguais")
    void deveCompararContaInvestimentoNaoIguais(){
        ContaBancaria contaBancaria1 = new ContaInvestimento();
        contaBancaria1.setId(UUID.randomUUID());

        ContaBancaria contaBancaria2 = new ContaInvestimento();
        contaBancaria2.setId(UUID.randomUUID());

        assertNotEquals(contaBancaria1, contaBancaria2);
        assertNotEquals(contaBancaria1.hashCode(), contaBancaria2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar conta investimento quando forem iguais")
    void deveCompararContaInvestimentoIguais(){
        UUID id = UUID.randomUUID();
        ContaBancaria contaBancaria1 = new ContaInvestimento();
        contaBancaria1.setId(id);

        ContaBancaria contaBancaria2 = new ContaInvestimento();
        contaBancaria2.setId(id);

        assertEquals(contaBancaria1, contaBancaria2);
        assertEquals(contaBancaria1.hashCode(), contaBancaria2.hashCode());
    }
}
