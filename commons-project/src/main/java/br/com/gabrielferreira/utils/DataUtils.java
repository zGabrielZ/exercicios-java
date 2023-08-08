package br.com.gabrielferreira.utils;

import br.com.gabrielferreira.exception.ErroInesperadoException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static br.com.gabrielferreira.utils.LogUtils.*;

public class DataUtils {

    private DataUtils(){}

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_MES_ANO = DateTimeFormatter.ofPattern("MM/yyyy");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_HORA_MINUTO_SEGUNDO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final String ZONE_ID_SAO_PAULO = "America/Sao_Paulo";
    private static final DateTimeFormatter DATE_TIME_HORA_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_ISO_8601 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public static LocalDate toDataBrasil(String data){
        try {
            return LocalDate.parse(data, DATE_TIME_FORMATTER);
        } catch (Exception e){
            gerarLogErro("Ocorreu um erro ao informar a data : {}", e);
            throw new ErroInesperadoException("Ocorreu um erro ao informar a data");
        }
    }

    public static LocalDateTime toDataHoraBrasil(String dataHora){
        try {
            return LocalDateTime.parse(dataHora, DATE_TIME_HORA_FORMATTER);
        } catch (Exception e){
            gerarLogErro("Ocorreu um erro ao informar a data e a hora : {}", e);
            throw new ErroInesperadoException("Ocorreu um erro ao informar a data e a hora");
        }
    }

    public static LocalDateTime toDataPadraoISO8601(String dataHora){
        try {
            return LocalDateTime.parse(dataHora, DATE_TIME_FORMATTER_ISO_8601);
        } catch (Exception e){
            gerarLogErro("Ocorreu um erro ao informar a data e a hora : {}", e);
            throw new ErroInesperadoException("Ocorreu um erro ao informar a data e a hora");
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

    public static String toDataHoraBrasil(LocalDateTime date){
        return DATE_TIME_HORA_FORMATTER.format(date);
    }

    public static LocalDate toDataAtualBrasil(){
        return LocalDate.now(ZoneId.of(ZONE_ID_SAO_PAULO));
    }

    public static LocalDateTime toDataHoraAtualBrasil(){
        return LocalDateTime.now(ZoneId.of(ZONE_ID_SAO_PAULO));
    }
}
