package br.com.gabrielferreira.validate;

import br.com.gabrielferreira.exception.RegraDeNegocioException;

public class ValidarCalcularArea {

    private ValidarCalcularArea(){}

    public static void validarValorInformado(Integer valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(msg);
        }
    }
}
