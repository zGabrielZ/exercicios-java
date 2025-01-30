package br.com.gabrielferreira.data.main;

import br.com.gabrielferreira.data.model.Data;
import lombok.Generated;

import java.util.UUID;

import static br.com.gabrielferreira.data.model.Constantes.FORMATO_12H;
import static br.com.gabrielferreira.data.model.Constantes.FORMATO_24H;

@Generated
public class AplicacaoData {

    public static void main(String[] args) {
        System.out.println("Imprimindo em formato 12 horas apenas dia, mês e ano");
        Data data1 = new Data(UUID.randomUUID(), 24, 5, 2023);
        System.out.println(data1.imprimir(FORMATO_12H));

        System.out.println("Imprimindo em formato 12 horas com horário meia noite");
        Data data2 = new Data(UUID.randomUUID(), 24, 5, 2023, 0, 17, 0);
        System.out.println(data2.imprimir(FORMATO_12H));

        System.out.println("Imprimindo em formato 12 horas com horário após meia noite");
        Data data3 = new Data(UUID.randomUUID(), 24, 5, 2023, 4, 17, 0);
        System.out.println(data3.imprimir(FORMATO_12H));

        System.out.println("Imprimindo em formato 12 horas com horário após meio dia");
        Data data4 = new Data(UUID.randomUUID(), 24, 5, 2023, 13, 17, 0);
        System.out.println(data4.imprimir(FORMATO_12H));

        System.out.println("Imprimindo em formato 24 horas apenas dia, mês e ano");
        Data data5 = new Data(UUID.randomUUID(), 20, 4, 2022);
        System.out.println(data5.imprimir(FORMATO_24H));

        System.out.println("Imprimindo em formato 24 horas com horário meia noite");
        Data data6 = new Data(UUID.randomUUID(), 24, 5, 2023, 0, 17, 0);
        System.out.println(data6.imprimir(FORMATO_24H));

        System.out.println("Imprimindo em formato 24 horas com horário após meia noite");
        Data data7 = new Data(UUID.randomUUID(), 24, 5, 2023, 4, 17, 0);
        System.out.println(data7.imprimir(FORMATO_24H));

        System.out.println("Imprimindo em formato 24 horas com horário após meio dia");
        Data data8 = new Data(UUID.randomUUID(), 24, 5, 2023, 13, 17, 0);
        System.out.println(data8.imprimir(FORMATO_24H));

    }
}
