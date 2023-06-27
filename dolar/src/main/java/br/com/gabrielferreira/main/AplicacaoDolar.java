package br.com.gabrielferreira.main;

import lombok.Generated;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

import static br.com.gabrielferreira.utils.CurrencyConverterUtils.*;
import static br.com.gabrielferreira.utils.MascarasUtils.valorMonetarioBrasil;
import static br.com.gabrielferreira.validate.ValidarEntrada.validarEntradaBigDecimal;

@Slf4j
@Generated
public class AplicacaoDolar {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        try {
            System.out.println("Quanto está o preço do dolar em real ? : ");
            BigDecimal precoDolarReal = validarEntradaBigDecimal(scanner);

            System.out.println("Quantos dólares você quer comprar ? : ");
            BigDecimal dolarComprar = validarEntradaBigDecimal(scanner);

            BigDecimal resultado = dolarToReal(dolarComprar, precoDolarReal);

            System.out.println("Valor em reais que você precisa pagar : " + valorMonetarioBrasil(resultado));
        } catch (Exception e){
            log.warn("Ocorreu erro na aplicação. Causa : {}", e.getMessage());
        }

        scanner.close();
    }
}
