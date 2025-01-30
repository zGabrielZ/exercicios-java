package br.com.gabrielferreira.data.validate;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;

public class ValidarData {

    private ValidarData(){}

    private static final Integer DIA_INICIO = 1;
    private static final Integer DIA_FIM = 30;
    private static final Integer MES_INICIO = 1;
    private static final Integer MES_FIM = 12;
    private static final Integer COMPRIMENTO_ANO = 4;
    private static final Integer HORA_INICIO = 0;
    private static final Integer HORA_FIM = 24;
    private static final Integer MINUTO_INICIO = 0;
    private static final Integer MINUTO_FIM = 59;
    private static final Integer SEGUNDO_INICIO = 0;
    private static final Integer SEGUNDO_FIM = 59;

    public static void validarDia(Integer dia){
        validarValorInformado(dia, "É necessário informar o dia");
        validarPeriodo(!(dia >= DIA_INICIO && dia <= DIA_FIM), "Informe o dia corretamente (1 até 30)");
    }

    public static void validarMes(Integer mes){
        validarValorInformado(mes, "É necessário informar o mês");
        validarPeriodo(!(mes >= MES_INICIO && mes <= MES_FIM), "Informe o mês corretamente (1 até 12)");
    }

    public static void validarAno(Integer ano){
        validarValorInformado(ano, "É necessário informar o ano");
        validarFormatoAno(ano);
    }

    public static void validarHora(Integer hora){
        validarValorInformado(hora, "É necessário informar a hora");
        validarPeriodo(!(hora >= HORA_INICIO && hora <= HORA_FIM), String.format("A hora deve está entre 0 e 24, o valor fornecido %s", hora));
    }

    public static void validarMinuto(Integer minuto){
        validarValorInformado(minuto, "É necessário informar o minuto");
        validarPeriodo(!(minuto >= MINUTO_INICIO && minuto <= MINUTO_FIM), String.format("O minuto deve está entre 0 e 59, o valor fornecido %s", minuto));
    }

    public static void validarSegundo(Integer segundo){
        validarValorInformado(segundo, "É necessário informar o segundo");
        validarPeriodo(!(segundo >= SEGUNDO_INICIO && segundo <= SEGUNDO_FIM), String.format("O segundo deve está entre 0 e 59, o valor fornecido %s", segundo));
    }

    private static void validarFormatoAno(Integer ano){
        String anoTamanho = String.valueOf(ano);
        if(anoTamanho.length() > COMPRIMENTO_ANO){
            throw new RegraDeNegocioException("Informe o ano corretamente");
        }
    }

    private static void validarPeriodo(boolean isPeriodoInformado, String msg){
        if(isPeriodoInformado){
            throw new RegraDeNegocioException(msg);
        }
    }

    public static void validarValorInformado(Integer valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(msg);
        }
    }
}
