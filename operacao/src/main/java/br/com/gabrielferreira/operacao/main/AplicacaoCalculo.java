package br.com.gabrielferreira.operacao.main;

import br.com.gabrielferreira.operacao.model.enumeration.Operacao;
import br.com.gabrielferreira.operacao.service.CalculoService;
import lombok.Generated;

import java.math.BigDecimal;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.commons.utils.MascarasUtils.valorFormatadoBrasil;

@Generated
public class AplicacaoCalculo {

    public static void main(String[] args) {
        System.out.println("Iniciando o calculo");

        CalculoService calculoService = new CalculoService();
        System.out.println("SOMA");
        BigDecimal retornoSoma = calculoService.calcular(toBigDecimal(2), toBigDecimal(5), Operacao.SOMA);
        System.out.println("Retorno da Soma : " + valorFormatadoBrasil(retornoSoma));

        System.out.println("SUBTRAÇÃO");
        BigDecimal retornoSubtracao = calculoService.calcular(toBigDecimal(2), toBigDecimal(5), Operacao.SUBTRACAO);
        System.out.println("Retorno da Subtração : " + valorFormatadoBrasil(retornoSubtracao));

        System.out.println("MULTIPLICAÇÃO");
        BigDecimal retornoMultiplicacao = calculoService.calcular(toBigDecimal(2.5), toBigDecimal(5.5), Operacao.MULTIPLICACAO);
        System.out.println("Retorno da Multiplicação : " + valorFormatadoBrasil(retornoMultiplicacao));

        System.out.println("DIVISÃO");
        BigDecimal retornoDivisao = calculoService.calcular(toBigDecimal(12), toBigDecimal(6), Operacao.DIVISAO);
        System.out.println("Retorno da Divisão : " + valorFormatadoBrasil(retornoDivisao));
    }
}
