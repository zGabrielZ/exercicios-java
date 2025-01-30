package br.com.gabrielferreira.circunferencia.main;
import lombok.Generated;
import java.util.Locale;
import java.util.Scanner;

import static br.com.gabrielferreira.commons.utils.MascarasUtils.valorFormatadoBrasil;
import static br.com.gabrielferreira.commons.validate.ValidarEntrada.validarEntradaDouble;
import static br.com.gabrielferreira.circunferencia.utils.CalcularRaioUtils.*;
import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;
import static br.com.gabrielferreira.commons.utils.LogUtils.*;

@Generated
public class AplicacaoCircunferenciaVolumePi {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        try {
            System.out.println("Digite o raio : ");
            Double valor = validarEntradaDouble(scanner);

            Double circuferencia = calcularCircunferencia(valor);
            Double volume = calcularVolume(valor);

            System.out.println("Circunferência : " + valorFormatadoBrasil(toBigDecimal(circuferencia)));
            System.out.println("Volume : " + valorFormatadoBrasil(toBigDecimal(volume)));
            System.out.println("PI : " + valorFormatadoBrasil(toBigDecimal(PI)));
        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        scanner.close();
    }
}
