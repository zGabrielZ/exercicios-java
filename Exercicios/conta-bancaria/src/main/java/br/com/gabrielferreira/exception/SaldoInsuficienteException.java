package br.com.gabrielferreira.exception;

import java.io.Serial;

public class SaldoInsuficienteException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    public SaldoInsuficienteException(String msg){
        super(msg);
    }
}
