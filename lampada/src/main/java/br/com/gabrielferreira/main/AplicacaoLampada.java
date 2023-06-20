package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.Lampada;
import lombok.Generated;

import java.util.UUID;

@Generated
public class AplicacaoLampada {

    public static void main(String[] args) {
        System.out.println("Iniciando lâmpada");

        Lampada lampada = new Lampada();
        lampada.setId(UUID.randomUUID());

        lampada.ligar();
        System.out.println(lampada.imprimir());

        lampada.desligar();
        System.out.println(lampada.imprimir());
    }
}
