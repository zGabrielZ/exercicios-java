package br.com.gabrielferreira.validate;

import br.com.gabrielferreira.exception.RegraDeNegocioException;

public class ValidarNumero {

    private ValidarNumero(){}

    public static void validarNumeroInformado(Integer valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(msg);
        }
    }

    public static void validarTamanhoAno(Integer ano){
        String anoFormat = String.valueOf(ano);
        if(anoFormat.length() > 4){
            throw new RegraDeNegocioException("Informe o ano corretamente");
        }
    }

    public static void validarPeriodo(boolean isPeriodo, String msg){
        if(isPeriodo){
            throw new RegraDeNegocioException(msg);
        }
    }
}
