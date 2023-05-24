package br.com.gabrielferreira.validate;

import br.com.gabrielferreira.exception.ErroInesperadoException;
import lombok.Generated;

import java.util.InputMismatchException;
import java.util.Scanner;

@Generated
public class ValidarEntrada {

    private ValidarEntrada(){}

    public static Integer validarEntrada(Scanner scanner){
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e){
            throw new ErroInesperadoException("Apenas números inteiros");
        }
    }
}
