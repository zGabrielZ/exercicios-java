package br.com.gabrielferreira.conta.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;

public class ContaInvestimento extends ContaBancaria {

    private static final double CINCO_POR_CENTO = 0.5;

    @Override
    public BigDecimal calcularSaldoFinal() {
        BigDecimal calculo = somar(this.getSaldo(), multiplicar(this.getSaldo(), toBigDecimal(CINCO_POR_CENTO)));
        return toRetorno(calculo, 2, RoundingMode.HALF_EVEN);
    }
}
