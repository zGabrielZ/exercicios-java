package br.com.gabrielferreira.validate;

import br.com.gabrielferreira.exception.RegraDeNegocioException;

public class ValidarFracao {

    private ValidarFracao(){}

    public static void validarObjeto(Object obj, String msg){
        if(obj == null){
            throw new RegraDeNegocioException(msg);
        }
    }

    public static void validarValorInformado(Integer valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(msg);
        }
    }
}
