package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.Numero;

public class AplicacaoNumero {

    public static void main(String[] args) {
        System.out.println("Iniciando número");

        String separador = "**************************************************************";

        Numero numero = new Numero();
        System.out.println(numero.imprimirDezAteVinteCinco());
        System.out.println(separador);
        System.out.println(numero.imprimirUmAteCemPulandoDeDois());
        System.out.println(separador);
        System.out.println(numero.imprimirSomandoAteBaterCem());
        System.out.println(separador);
        System.out.println(numero.imprimirTabuadaDoNove());
        System.out.println(separador);
        System.out.println(numero.calcularNumeroParaFatorar(6));
        System.out.println(separador);
        System.out.println(numero.imprimirQuinzePrimeirosNumerosFibonacci());
        System.out.println(separador);
        System.out.println(numero.imprimirAteUltrapassarMil(4));
        System.out.println(separador);
        System.out.println(numero.imprimirDataInformada(26, 5, 2023));
    }
}
