package br.com.gabrielferreira.numeros.main;

import br.com.gabrielferreira.numeros.model.NumeroPrimo;
import lombok.Generated;

import java.util.UUID;

@Generated
public class AplicacaoNumeroPrimo {

    public static void main(String[] args) {
        System.out.println("Iniciando número primo");

        NumeroPrimo numeroPrimo1 = new NumeroPrimo(UUID.randomUUID(), 2);
        System.out.println("Valor " + numeroPrimo1.getValor() + " é primo ? " + (numeroPrimo1.isNumeroPrimo() ? "Sim" : "Não"));

        NumeroPrimo numeroPrimo2 = new NumeroPrimo(UUID.randomUUID(), 11);
        System.out.println("Valor " + numeroPrimo2.getValor() + " é primo ? " + (numeroPrimo2.isNumeroPrimo() ? "Sim" : "Não"));
    }
}
