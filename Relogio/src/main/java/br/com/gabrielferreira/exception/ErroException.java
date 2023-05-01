package br.com.gabrielferreira.exception;

import java.io.Serial;

public class ErroException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -4009049073481233778L;

    public ErroException(String msg){
        super(msg);
    }
}
