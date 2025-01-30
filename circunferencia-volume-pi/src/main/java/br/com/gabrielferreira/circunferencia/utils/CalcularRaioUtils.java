package br.com.gabrielferreira.circunferencia.utils;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;

public class CalcularRaioUtils {

    private CalcularRaioUtils(){}

    public static final double PI = 3.141592653589793;

    public static Double calcularCircunferencia(Double valor){
        validarValor(valor);
        return 2 * PI * valor;
    }

    public static Double calcularVolume(Double valor){
        validarValor(valor);
        return (4.0 * PI * Math.pow(valor,3)) / 3;
    }

    private static void validarValor(Double valor){
        if(valor == null){
            throw new RegraDeNegocioException("É necessário informar o valor");
        }
    }
}
