package br.com.gabrielferreira.utils;

import br.com.gabrielferreira.exception.RegraDeNegocioException;

import java.math.BigDecimal;

import static br.com.gabrielferreira.utils.CalculoUtils.*;

public class CurrencyConverterUtils {

    private CurrencyConverterUtils(){}

    private static final BigDecimal IOF = toBigDecimal(0.06);

    public static BigDecimal dolarToReal(BigDecimal dolar, BigDecimal cotacaoDolarReal){
        validarValorInformado(cotacaoDolarReal, "o preço do dolar em real");
        validarValorInformado(dolar, "o dolar que quer comprar");
        BigDecimal real = multiplicar(dolar, cotacaoDolarReal);
        return  somar(real, multiplicar(real, IOF));
    }

    private static void validarValorInformado(BigDecimal valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(String.format("É necessário informar %s", msg));
        }

        if(valor.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException("O valor informado não pode ser negativo");
        }
    }
}
