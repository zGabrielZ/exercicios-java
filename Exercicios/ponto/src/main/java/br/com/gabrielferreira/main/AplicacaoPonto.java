package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.Ponto2D;
import br.com.gabrielferreira.model.Ponto3D;
import lombok.Generated;

import static br.com.gabrielferreira.utils.CalculoUtils.*;

import java.util.UUID;

@Generated
public class AplicacaoPonto {

    public static void main(String[] args) {
        System.out.println("Iniciando aplicação ponto");

        System.out.println("Ponto 2D");
        Ponto2D ponto2D = new Ponto2D(UUID.randomUUID(), toBigDecimal(2), toBigDecimal(3));
        System.out.println(ponto2D);

        System.out.println("Ponto 3D");
        Ponto3D ponto3D = new Ponto3D(UUID.randomUUID(), toBigDecimal(3), toBigDecimal(3), toBigDecimal(5));
        System.out.println(ponto3D);
    }
}
