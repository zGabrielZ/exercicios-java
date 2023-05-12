package br.com.gabrielferreira.exception;

import java.io.Serial;

public class ValorInvalidoException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    public ValorInvalidoException(String msg){
        super(msg);
    }
}
