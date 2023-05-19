package br.com.gabrielferreira.validate;

import br.com.gabrielferreira.exception.RegraDeNegocioException;

import java.math.BigDecimal;
import java.util.List;

public class ValidarAluno {

    private ValidarAluno(){}

    private static final Integer PESO_INICIO = 1;
    private static final Integer PESO_FIM = 5;
    private static final Integer SOMA_TOTAL_PESO = 10;

    public static void validarNotaAluno(BigDecimal nota, String nomeAluno){
        if(!(nota.compareTo(BigDecimal.ZERO) >= 0 && nota.compareTo(BigDecimal.TEN) <= 0)){
            throw new RegraDeNegocioException(String.format("A nota do aluno %s tem que ser de 0.0 até 10.0", nomeAluno));
        }
    }

    public static void validarPeriodoPeso(Integer peso, String nomeAluno){
        if(!(peso >= PESO_INICIO && peso <= PESO_FIM)){
            throw new RegraDeNegocioException(String.format("O peso da nota do aluno %s tem que ser de 1 até 5", nomeAluno));
        }
    }

    public static void validarSomaPeso(Integer peso){
        if(peso > SOMA_TOTAL_PESO){
            throw new RegraDeNegocioException("A nota do peso não pode ultrapassar de 10");
        }
    }

    public static void validarLista(List<?> list, String msg){
        if(list == null || list.isEmpty()){
            throw new RegraDeNegocioException(msg);
        }
    }

    public static void validarString(String string, String msg){
        if(string == null || string.isBlank()){
            throw new RegraDeNegocioException(msg);
        }
    }

    public static void validarBigDecimal(BigDecimal bigDecimal, String msg){
        if(bigDecimal == null){
            throw new RegraDeNegocioException(msg);
        }
    }

    public static void validarInteger(Integer integer, String msg){
        if(integer == null){
            throw new RegraDeNegocioException(msg);
        }
    }
}
