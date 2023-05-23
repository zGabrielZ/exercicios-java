package br.com.gabrielferreira.utils;

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

    public static BigDecimal multiplicar(BigDecimal valorParte1, BigDecimal valorParte2, int escala, RoundingMode tipoArredondamento){
        return valorParte1.multiply(valorParte2).setScale(escala, tipoArredondamento);
    }
}