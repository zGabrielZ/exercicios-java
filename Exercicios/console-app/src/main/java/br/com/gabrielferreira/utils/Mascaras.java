package br.com.gabrielferreira.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Mascaras {

    private Mascaras(){}

    private static final Locale BRASIL = new Locale("pt", "BR");

    public static String valorMonetarioBrasil(BigDecimal valor){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(BRASIL);
        return numberFormat.format(valor);
    }
}
