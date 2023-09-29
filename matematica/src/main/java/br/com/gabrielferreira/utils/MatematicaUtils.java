package br.com.gabrielferreira.utils;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.enumeration.TipoAngulo;

import static br.com.gabrielferreira.model.enumeration.TipoAngulo.*;

public class MatematicaUtils {

    private MatematicaUtils(){}

    public static Double converterAngulo(Double angulo, TipoAngulo tipoAngulo){
        validarTipoAngulo(angulo, tipoAngulo);
        if(isGraus(tipoAngulo)){
            return Math.toRadians(angulo);
        } else {
            return Math.toDegrees(angulo);
        }
    }

    public static Integer somar(Integer valorParte1, Integer valorParte2, Integer valorParte3){
        validar(valorParte1, "É necessário informar o primeiro valor");
        validar(valorParte2, "É necessário informar o segundo valor");
        validar(valorParte3, "É necessário informar o terceiro valor");
        return valorParte1 + valorParte2 + valorParte3;
    }

    public static String converterDecimalParaBinario(Integer numero){
        validar(numero, "É necessário informar o número");
        return Integer.toBinaryString(numero);
    }

    public static Integer converterBinarioParaDecimal(String numBinario){
        if(numBinario == null || numBinario.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o número binário");
        }
        return Integer.parseInt(numBinario, 2);
    }

    private static void validar(Integer valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(msg);
        }
    }

    private static void validarTipoAngulo(Double valor, TipoAngulo tipoAngulo){
        if(valor == null){
            throw new RegraDeNegocioException("Informe o ângulo");
        } else if(tipoAngulo == null){
            throw new RegraDeNegocioException("Informe o tipo do ângulo");
        }
    }
}
