package br.com.gabrielferreira.main;


import br.com.gabrielferreira.model.enumeration.TipoAngulo;
import lombok.Generated;

import static br.com.gabrielferreira.utils.MatematicaUtils.*;

@Generated
public class AplicacaoMatematica {

    public static void main(String[] args) {
        Double anguloGrau = converterAngulo(45.0, TipoAngulo.GRAUS);
        System.out.println(anguloGrau);

        Double anguloRadiano = converterAngulo(45.0, TipoAngulo.RADIANOS);
        System.out.println(anguloRadiano);

        Integer soma = somar(10, 20, 40);
        System.out.println(soma);

        String valorParaBinario = converterDecimalParaBinario(15);
        System.out.println(valorParaBinario);

        Integer binarioParaValor = converterBinarioParaDecimal(valorParaBinario);
        System.out.println(binarioParaValor);
    }
}
