package br.com.gabrielferreira.model;

import java.math.BigDecimal;

public class ContaInvestimento extends ContaBancaria {

    @Override
    public BigDecimal calcularSaldoFinal() {
        return this.getSaldo().add(this.getSaldo().multiply(BigDecimal.valueOf(0.5)));
    }
}
