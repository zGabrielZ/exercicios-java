package br.com.gabrielferreira.area.validate;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;

public class ValidacaoCalculoArea {

    private ValidacaoCalculoArea(){}

    public static void validarNumeroInformado(Integer valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(msg);
        }
    }
}
