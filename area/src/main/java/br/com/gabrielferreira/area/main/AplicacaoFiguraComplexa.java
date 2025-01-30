package br.com.gabrielferreira.area.main;

import br.com.gabrielferreira.area.model.AreaCalculavel;
import br.com.gabrielferreira.area.model.Quadrado;
import br.com.gabrielferreira.area.model.Retangulo;
import br.com.gabrielferreira.area.service.CalculadorService;
import lombok.Generated;

import java.math.BigDecimal;
import java.util.*;

import static br.com.gabrielferreira.commons.utils.MascarasUtils.valorFormatadoBrasil;
import static br.com.gabrielferreira.commons.validate.ValidarEntrada.*;
import static br.com.gabrielferreira.commons.utils.LogUtils.*;

@Generated
public class AplicacaoFiguraComplexa {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        CalculadorService calculadorService = new CalculadorService();
        List<AreaCalculavel> areas = new ArrayList<>();

        System.out.println("Informe o lado como inteiro do primeiro quadrado : ");
        Integer lado1 = validarEntrada(scanner);
        areas.add(new Quadrado(UUID.randomUUID(), lado1));

        System.out.println("Informe o lado como inteiro do segundo quadrado : ");
        Integer lado2 = validarEntrada(scanner);
        areas.add(new Quadrado(UUID.randomUUID(), lado2));

        System.out.println("Informe a base como inteiro do primeiro retângulo : ");
        Integer base1 = validarEntrada(scanner);

        System.out.println("Informe a altura como inteiro do primeiro retângulo : ");
        Integer altura1 = validarEntrada(scanner);
        areas.add(new Retangulo(UUID.randomUUID(), base1, altura1));

        System.out.println("Informe a base como inteiro do segundo retângulo : ");
        Integer base2 = validarEntrada(scanner);

        System.out.println("Informe a altura como inteiro do segundo retângulo : ");
        Integer altura2 = validarEntrada(scanner);
        areas.add(new Retangulo(UUID.randomUUID(), base2, altura2));

        try {
            BigDecimal resultado = calculadorService.somarCalculoAreas(areas);
            System.out.println("Resultado : " + valorFormatadoBrasil(resultado));
        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        scanner.close();
    }
}
