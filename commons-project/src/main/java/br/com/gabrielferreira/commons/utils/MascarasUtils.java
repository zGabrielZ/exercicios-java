package br.com.gabrielferreira.commons.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class MascarasUtils {

    private MascarasUtils(){}

    private static final Locale BRASIL = new Locale("pt", "BR");

    public static String valorMonetarioBrasil(BigDecimal valor){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(BRASIL);
        return numberFormat.format(valor);
    }

    public static String valorFormatadoBrasil(BigDecimal valor){
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(BRASIL);
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');

        DecimalFormat decimalFormat = new DecimalFormat("###,###.##", decimalFormatSymbols);
        return decimalFormat.format(valor);
    }
}
