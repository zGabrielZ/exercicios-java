package br.com.gabrielferreira.validate;

import br.com.gabrielferreira.exception.RegraDeNegocioException;

import java.util.Collections;
import java.util.List;

public class ValidarCalculo {

    private ValidarCalculo(){}

    public static void validarValorInformado(Double valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(msg);
        }
    }

    public static void validarTipoTriangulo(Character valor){
        if(valor == null){
            throw new RegraDeNegocioException("É necessário informar o tipo do triângulo");
        }
    }

    public static void validarTipoTrianguloRepetido(List<Character> tiposTriangulos){
        tiposTriangulos.forEach(tipo -> {
            int duplicados = Collections.frequency(tiposTriangulos, tipo);

            if (duplicados > 1) {
                throw new RegraDeNegocioException("Não pode repetir tipo de triângulo");
            }
        });
    }
}
