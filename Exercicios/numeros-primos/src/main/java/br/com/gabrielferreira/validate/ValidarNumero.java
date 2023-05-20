package br.com.gabrielferreira.validate;

import br.com.gabrielferreira.exception.RegraDeNegocioException;

public class ValidarNumero {

    private ValidarNumero(){}

    private static final Integer LIMITE = 0;

    public static void validarValorInformado(Integer valor){
        if(valor == null){
            throw new RegraDeNegocioException("O valor não pode ser nulo");
        }
    }

    public static void validarValorLimite(Integer valor){
        if(valor <= LIMITE){
            throw new RegraDeNegocioException("Número tem que ser maior do que zero");
        }
    }
}
