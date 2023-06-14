package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.AreaCalculavel;
import br.com.gabrielferreira.model.Quadrado;
import br.com.gabrielferreira.model.Retangulo;
import br.com.gabrielferreira.service.CalculadorService;
import lombok.Generated;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

import static br.com.gabrielferreira.utils.MascarasUtils.valorFormatadoBrasil;

@Generated
public class AplicacaoFiguraComplexa {

    public static void main(String[] args) {
        System.out.println("Iniciando aplicação figura complexa");

        AreaCalculavel quadrado1 = new Quadrado(UUID.randomUUID(), 3);
        AreaCalculavel quadrado2 = new Quadrado(UUID.randomUUID(), 10);
        AreaCalculavel retangulo1 = new Retangulo(UUID.randomUUID(), 2, 7);
        AreaCalculavel retangulo2 = new Retangulo(UUID.randomUUID(), 5, 3);

        CalculadorService calculadorService = new CalculadorService();
        BigDecimal resultado = calculadorService.somarCalculoAreas(Arrays.asList(quadrado1, quadrado2, retangulo1, retangulo2));
        System.out.println("Resultado : " + valorFormatadoBrasil(resultado));
    }
}
