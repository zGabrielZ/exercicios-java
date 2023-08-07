package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.ReservaHotel;
import lombok.Generated;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

import static br.com.gabrielferreira.utils.LogUtils.*;
import static br.com.gabrielferreira.validate.ValidarEntrada.*;
import static br.com.gabrielferreira.utils.DataUtils.*;

@Generated
public class AplicacaoReservaHotel {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        try {
            System.out.println("Número do quarto : ");
            Integer numeroQuarto = validarEntrada(scanner);

            scanner.nextLine();

            System.out.println("Check in : (DD/MM/AAAA)");
            String checkInString = scanner.nextLine();

            System.out.println("Check out : (DD/MM/AAAA)");
            String checkOutString = scanner.nextLine();

            ReservaHotel reservaHotel = new ReservaHotel(UUID.randomUUID(), numeroQuarto, toDataBrasil(checkInString), toDataBrasil(checkOutString));
            System.out.println(reservaHotel);

            System.out.println();

            System.out.println("Digite as datas para atualizar a reserva : ");
            System.out.println("Check in : (DD/MM/AAAA)");
            String checkInStringUpdate = scanner.nextLine();

            System.out.println("Check out : (DD/MM/AAAA)");
            String checkOutStringUpdate = scanner.nextLine();

            reservaHotel.updateDatas(toDataBrasil(checkInStringUpdate), toDataBrasil(checkOutStringUpdate));

            System.out.println(reservaHotel);

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }
    }
}
