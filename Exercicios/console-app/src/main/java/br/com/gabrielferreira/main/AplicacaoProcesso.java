package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.Processo;

public class AplicacaoProcesso {

    public static void main(String[] args) {
        System.out.println("Iniciando o processo");
        Processo processo = new Processo();

        System.out.println("Imprimindo nulo ao informar nulo no parametro");
        System.out.println(processo.processar(null));

        System.out.println("Imprimindo nulo ao informar vazio no parametro");
        System.out.println(processo.processar(""));

        System.out.println("Imprimindo letra maiuscula ao informar dados no parametro");
        System.out.println(processo.processar("gab"));

        System.out.println("Imprimindo letra maiuscula e as três primeiras letras inversa ao informar dados no parametro");
        System.out.println(processo.processar("cristiano ronaldo"));
    }
}
