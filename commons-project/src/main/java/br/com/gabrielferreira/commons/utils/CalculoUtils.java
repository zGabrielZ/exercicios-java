package br.com.gabrielferreira.commons.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculoUtils {

    private CalculoUtils(){}

    public static BigDecimal toBigDecimal(long valor){
        return BigDecimal.valueOf(valor);
    }

    public static BigDecimal toBigDecimal(double valor){
        return BigDecimal.valueOf(valor);
    }

    public static BigDecimal multiplicar(BigDecimal valorParte1, BigDecimal valorParte2){
        return valorParte1.multiply(valorParte2);
    }

    public static Integer multiplicar(Integer valorParte1, Integer valorParte2){
        return valorParte1 * valorParte2;
    }

    public static BigDecimal somar(BigDecimal valorParte1, BigDecimal valorParte2){
        return valorParte1.add(valorParte2);
    }

    public static BigDecimal somar(BigDecimal...valores){
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (BigDecimal valor : valores) {
            valorTotal = valorTotal.add(valor);
        }
        return valorTotal;
    }

    public static BigDecimal subtrair(BigDecimal valorParte1, BigDecimal valorParte2){
        return valorParte1.subtract(valorParte2);
    }

    public static BigDecimal divide(BigDecimal valorParte1, BigDecimal valorParte2, int escala, RoundingMode roundingMode){
        return valorParte1.divide(valorParte2, escala, roundingMode);
    }

    public static BigDecimal toRetorno(BigDecimal valor, int escala, RoundingMode tipoArredondamento){
        return valor.setScale(escala, tipoArredondamento);
    }
}
