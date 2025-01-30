package br.com.gabrielferreira.escolar.validate;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;

import java.math.BigDecimal;

public class ValidarCalculo {

    private ValidarCalculo(){}

    private static final BigDecimal NOTA_LIMITE = BigDecimal.TEN;

    public static void validarValorInformado(BigDecimal valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(msg);
        }
    }

    public static void validarLimteNota(BigDecimal valor){
        if(valor.compareTo(NOTA_LIMITE) > 0){
            throw new RegraDeNegocioException("A soma das duas notas não pode ultrapassar de 10.0");
        }
    }
}
