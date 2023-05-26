package br.com.gabrielferreira.main;

import br.com.gabrielferreira.exception.ErroInesperadoException;
import br.com.gabrielferreira.model.Circunferencia;
import br.com.gabrielferreira.model.Quadrado;
import br.com.gabrielferreira.model.Retangulo;
import lombok.Generated;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

import static br.com.gabrielferreira.utils.MascarasUtils.*;

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
            System.out.println("Mensagem : " + e.getMessage());
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

    public static Integer validarEntrada(Scanner scanner){
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e){
            throw new ErroInesperadoException("Apenas números inteiros");
        }
    }
}
