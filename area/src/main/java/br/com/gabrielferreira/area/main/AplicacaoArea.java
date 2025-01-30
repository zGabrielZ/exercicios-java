package br.com.gabrielferreira.area.main;

import br.com.gabrielferreira.commons.exception.ErroInesperadoException;
import br.com.gabrielferreira.area.model.Circunferencia;
import br.com.gabrielferreira.area.model.Quadrado;
import br.com.gabrielferreira.area.model.Retangulo;
import lombok.Generated;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.MascarasUtils.valorFormatadoBrasil;
import static br.com.gabrielferreira.commons.validate.ValidarEntrada.*;
import static br.com.gabrielferreira.commons.utils.LogUtils.*;

@Generated
public class AplicacaoArea {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        System.out.println("Cálculo de área");
        System.out.println("[A] Circunferência");
        System.out.println("[B] Quadrado");
        System.out.println("[C] Retângulo");

        Character letraInformada = scanner.next().charAt(0);
        try {
            BigDecimal resultado = verificarLetraInformada(letraInformada, scanner);
            System.out.println("Resultado : " + valorFormatadoBrasil(resultado));
        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        scanner.close();
    }

    private static BigDecimal verificarLetraInformada(Character letraInformada, Scanner scanner){
        switch (letraInformada) {
            case 'A' ->  {
                return calcularAreaCircunferencia(scanner);
            }
            case 'B' -> {
                return calcularAreaQuadrado(scanner);
            }
            case 'C' -> {
                return calcularAreaRetangulo(scanner);
            }
            default -> throw new ErroInesperadoException("Não foi selecionada a letra correta");
        }
    }

    private static BigDecimal calcularAreaCircunferencia(Scanner scanner){
        System.out.println("Informe o raio como inteiro : ");
        Integer raio = validarEntrada(scanner);
        return new Circunferencia(UUID.randomUUID(), raio).calcularArea();
    }

    private static BigDecimal calcularAreaQuadrado(Scanner scanner){
        System.out.println("Informe o lado como inteiro : ");
        Integer lado = validarEntrada(scanner);
        return new Quadrado(UUID.randomUUID(), lado).calcularArea();
    }

    private static BigDecimal calcularAreaRetangulo(Scanner scanner){
        System.out.println("Informe a base como inteiro : ");
        Integer base = validarEntrada(scanner);

        System.out.println("Informe a altura como inteiro : ");
        Integer altura = validarEntrada(scanner);
        return new Retangulo(UUID.randomUUID(), base, altura).calcularArea();
    }
}
