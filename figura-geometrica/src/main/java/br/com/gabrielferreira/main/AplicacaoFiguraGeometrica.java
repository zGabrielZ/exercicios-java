package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.Circunferencia;
import br.com.gabrielferreira.model.Quadrado;
import br.com.gabrielferreira.model.Trapezio;
import br.com.gabrielferreira.model.Triangulo;
import lombok.Generated;

import java.util.UUID;

import static br.com.gabrielferreira.utils.MascarasUtils.valorFormatadoBrasil;

@Generated
public class AplicacaoFiguraGeometrica {

    public static void main(String[] args) {
        System.out.println("Iniciando figura geométrica");

        Circunferencia circunferencia = new Circunferencia(UUID.randomUUID(), 3);
        System.out.println("Cálculo da área da Circunferência : " + valorFormatadoBrasil(circunferencia.calcularArea()));

        Quadrado quadrado = new Quadrado(UUID.randomUUID(), 4);
        System.out.println("Cálculo da área do Quadrado : " + valorFormatadoBrasil(quadrado.calcularArea()));

        Trapezio trapezio = new Trapezio(UUID.randomUUID(), 4, 2, 2);
        System.out.println("Cálculo da área do Trapézio : " + valorFormatadoBrasil(trapezio.calcularArea()));

        Triangulo triangulo = new Triangulo(UUID.randomUUID(), 3, 5);
        System.out.println("Cálculo da área do Triangulo : " + valorFormatadoBrasil(triangulo.calcularArea()));
    }
}
