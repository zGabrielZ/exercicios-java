package br.com.gabrielferreira.validate;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Prova;

public class ValidarProva {

    private ValidarProva(){}

    public static void validarProvaInformada(Prova prova, String msg){
        if(prova == null){
            throw new RegraDeNegocioException(msg);
        }
    }
}
