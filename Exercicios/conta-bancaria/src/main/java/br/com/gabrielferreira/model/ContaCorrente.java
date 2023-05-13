package br.com.gabrielferreira.model;

import java.math.BigDecimal;

public class ContaCorrente extends ContaBancaria {

    @Override
    public BigDecimal calcularSaldoFinal() {
        return this.getSaldo().subtract(this.getSaldo().multiply(BigDecimal.valueOf(0.10)));
    }
}
