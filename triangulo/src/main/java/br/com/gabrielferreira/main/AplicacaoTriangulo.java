package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.Triangulo;
import br.com.gabrielferreira.service.TrianguloService;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import static br.com.gabrielferreira.utils.MascarasUtils.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

@Slf4j
@Generated
public class AplicacaoTriangulo {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        TrianguloService trianguloService = new TrianguloService();

        System.out.println("Digite os lados (A, B, C) do triângulo x : ");
        Double ladoAx = scanner.nextDouble();
        Double ladoBx = scanner.nextDouble();
        Double ladoCx = scanner.nextDouble();

        System.out.println("Digite os lados (A, B, C) do triângulo y : ");
        Double ladoAy = scanner.nextDouble();
        Double ladoBy = scanner.nextDouble();
        Double ladoCy = scanner.nextDouble();

        try {
            Triangulo trianguloX = trianguloService.criarTriangulo(ladoAx, ladoBx, ladoCx, 'X');
            Triangulo trianguloY = trianguloService.criarTriangulo(ladoAy, ladoBy, ladoCy, 'Y');
            Character maiorTipoTriangulo = trianguloService.maiorAreaTipoTriangulo(Arrays.asList(trianguloX, trianguloY));

            System.out.println("Triângulo X : " + valorFormatadoBrasil(toBigDecimal(trianguloX.getResultadoFinalCalculoArea())));
            System.out.println("Triângulo Y : " + valorFormatadoBrasil(toBigDecimal(trianguloY.getResultadoFinalCalculoArea())));
            System.out.println("Maior Área : " + maiorTipoTriangulo);
        } catch (Exception e){
            log.warn("Ocorreu erro na aplicação. Causa : {}", e.getMessage());
        }

        scanner.close();
    }
}
