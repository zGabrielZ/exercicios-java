package br.com.gabrielferreira.validate;

import br.com.gabrielferreira.exception.RegraDeNegocioException;

import java.time.LocalDate;

public class ValidarDataNascimento {

    private ValidarDataNascimento(){}

    public static void validarData(LocalDate dataNascimento){
        if(dataNascimento == null){
            throw new RegraDeNegocioException("É necessário informar a data de nascimento");
        }
    }
}
