package br.com.gabrielferreira.relogio.validate;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;

public class ValidarRelogio {

    private ValidarRelogio(){}

    public static void validarValorInformado(Integer valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(msg);
        }
    }
}
