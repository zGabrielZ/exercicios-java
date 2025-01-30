package br.com.gabrielferreira.commons.utils;

public class StringUtils {

    private StringUtils(){}

    public static boolean isNumerico(String valor){
        return org.apache.commons.lang3.StringUtils.isNumeric(valor);
    }
}
