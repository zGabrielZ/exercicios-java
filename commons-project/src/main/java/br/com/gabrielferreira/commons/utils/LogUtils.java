package br.com.gabrielferreira.commons.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtils {

    private LogUtils(){}

    public static void gerarLogWarn(String mensagem, Exception e){
        log.warn(mensagem, e.getMessage());
        e.printStackTrace();
    }

    public static void gerarLogErro(String mensagem, Exception e){
        log.error(mensagem, e.getMessage());
        e.printStackTrace();
    }

    public static void gerarLogInfo(String mensagem){
        log.info(mensagem);
    }
}
