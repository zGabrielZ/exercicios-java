package br.com.gabrielferreira.escolar.validate;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.escolar.model.Prova;

public class ValidarProva {

    private ValidarProva(){}

    public static void validarProvaInformada(Prova prova, String msg){
        if(prova == null){
            throw new RegraDeNegocioException(msg);
        }
    }
}
