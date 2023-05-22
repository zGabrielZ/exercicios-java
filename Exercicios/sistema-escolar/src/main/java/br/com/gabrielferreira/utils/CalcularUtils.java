package br.com.gabrielferreira.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcularUtils {

    private CalcularUtils(){}

    public static BigDecimal somar(BigDecimal...valores){
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (BigDecimal valor : valores) {
            valorTotal = valorTotal.add(valor);
        }
        return valorTotal;
    }

    public static BigDecimal divide(BigDecimal primeiroValor, BigDecimal segundoValor, RoundingMode roundingMode){
        return primeiroValor.divide(segundoValor, roundingMode);
    }
}
