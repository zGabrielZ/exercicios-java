package br.com.gabrielferreira.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static br.com.gabrielferreira.utils.CalculoUtils.*;

public class ContaCorrente extends ContaBancaria {

    private static final double DEZ_POR_CENTO = 0.10;

    @Override
    public BigDecimal calcularSaldoFinal() {
        BigDecimal calculo = subtrair(this.getSaldo(), multiplicar(this.getSaldo(), toBigDecimal(DEZ_POR_CENTO)));
        return toRetorno(calculo, 2, RoundingMode.HALF_EVEN);
    }
}
