package br.com.gabrielferreira.conta.validate;

import br.com.gabrielferreira.conta.exception.SaldoInsuficienteException;
import br.com.gabrielferreira.conta.exception.ValorInvalidoException;

import java.math.BigDecimal;

public class ValidarConta {

    private ValidarConta(){}

    public static void validarSaldoInformado(BigDecimal saldo, String msg){
        if(saldo == null){
            throw new ValorInvalidoException(msg);
        }
    }

    public static void validarSaldoNegativoOuZerado(BigDecimal saldo, String msg){
        if(saldo.compareTo(BigDecimal.ZERO) <= 0){
            throw new ValorInvalidoException(msg);
        }
    }

    public static void validarSaldoTotalMenorQueSaldoInformado(BigDecimal saldoTotal, BigDecimal saldoInformado, String msg){
        if(saldoInformado.compareTo(saldoTotal) > 0){
            throw new SaldoInsuficienteException(msg);
        }
    }
}
