package br.com.gabrielferreira.exception;

import java.io.Serial;

public class ErroInesperadoException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -260138733430064530L;

    public ErroInesperadoException(String mensagem){
        super(mensagem);
    }
}
