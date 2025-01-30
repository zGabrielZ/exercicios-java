package br.com.gabrielferreira.figura.validate;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;

public class ValidarCalcularArea {

    private ValidarCalcularArea(){}

    public static void validarValorInformado(Integer valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(msg);
        }
    }
}
