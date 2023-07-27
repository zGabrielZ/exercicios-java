package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.Triangulo;
import br.com.gabrielferreira.service.TrianguloService;
import lombok.Generated;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import static br.com.gabrielferreira.utils.MascarasUtils.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static br.com.gabrielferreira.validate.ValidarEntrada.*;
import static br.com.gabrielferreira.utils.LogUtils.*;

@Generated
public class AplicacaoTriangulo {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        TrianguloService trianguloService = new TrianguloService();

        try {
            System.out.println("Digite os lados (A, B, C) do triângulo x : ");
            Double ladoAx = validarEntradaDouble(scanner);
            Double ladoBx = validarEntradaDouble(scanner);
            Double ladoCx = validarEntradaDouble(scanner);

            System.out.println("Digite os lados (A, B, C) do triângulo y : ");
            Double ladoAy = validarEntradaDouble(scanner);
            Double ladoBy = validarEntradaDouble(scanner);
            Double ladoCy = validarEntradaDouble(scanner);

            Triangulo trianguloX = trianguloService.criarTriangulo(ladoAx, ladoBx, ladoCx, 'X');
            Triangulo trianguloY = trianguloService.criarTriangulo(ladoAy, ladoBy, ladoCy, 'Y');
            Character maiorTipoTriangulo = trianguloService.maiorAreaTipoTriangulo(Arrays.asList(trianguloX, trianguloY));

            System.out.println("Triângulo X : " + valorFormatadoBrasil(toBigDecimal(trianguloX.getResultadoFinalCalculoArea())));
            System.out.println("Triângulo Y : " + valorFormatadoBrasil(toBigDecimal(trianguloY.getResultadoFinalCalculoArea())));
            System.out.println("Maior Área : " + maiorTipoTriangulo);
        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        scanner.close();
    }
}
