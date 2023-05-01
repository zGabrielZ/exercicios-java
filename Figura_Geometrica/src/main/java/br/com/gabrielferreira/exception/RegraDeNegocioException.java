package br.com.gabrielferreira.exception;

import java.io.Serial;

public class RegraDeNegocioException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -260138733430064530L;

    public RegraDeNegocioException(String msg){
        super(msg);
    }
}
