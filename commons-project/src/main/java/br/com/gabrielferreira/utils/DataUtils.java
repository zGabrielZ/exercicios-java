package br.com.gabrielferreira.utils;

import br.com.gabrielferreira.exception.ErroInesperadoException;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Slf4j
public class DataUtils {

    private DataUtils(){}

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_MES_ANO = DateTimeFormatter.ofPattern("MM/yyyy");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_HORA_MINUTO_SEGUNDO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static LocalDate toDataBrasil(String data){
        try {
            return LocalDate.parse(data, DATE_TIME_FORMATTER);
        } catch (Exception e){
            log.error("Ocorreu um erro ao informar a data : {}", e.getMessage());
            throw new ErroInesperadoException("Ocorreu um erro ao informar a data");
        }
    }

    public static String toDataBrasil(LocalDate date){
        return DATE_TIME_FORMATTER.format(date);
    }

    public static String toDataBrasilMesAno(LocalDate date){
        return DATE_TIME_FORMATTER_MES_ANO.format(date);
    }

    public static String toDataBrasil(LocalDateTime date){
        return DATE_TIME_FORMATTER_HORA_MINUTO_SEGUNDO.format(date);
    }

    public static LocalDate toDataAtualBrasil(){
        return LocalDate.now(ZoneId.of("America/Sao_Paulo"));
    }
}
