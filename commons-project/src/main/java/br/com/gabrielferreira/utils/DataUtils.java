package br.com.gabrielferreira.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    private DataUtils(){}

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_HORA_MINUTO_SEGUNDO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static LocalDate toDataBrasil(String data){
        return LocalDate.parse(data, DATE_TIME_FORMATTER);
    }

    public static String toDataBrasil(LocalDate date){
        return DATE_TIME_FORMATTER.format(date);
    }

    public static String toDataBrasil(LocalDateTime date){
        return DATE_TIME_FORMATTER_HORA_MINUTO_SEGUNDO.format(date);
    }

    public static LocalDate toDataAtualBrasil(){
        return LocalDate.now(ZoneId.of("America/Sao_Paulo"));
    }
}
