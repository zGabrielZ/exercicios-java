package br.com.gabrielferreira.validate;

import br.com.gabrielferreira.exception.RegraDeNegocioException;

import java.math.BigDecimal;
import java.util.UUID;

public class ValidarCampos {

    private ValidarCampos(){}

    public static void validarId(UUID id){
        if(id == null){
            throw new RegraDeNegocioException("É necessário informar o ID");
        }
    }

    public static void validarNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o nome");
        }
    }

    public static void validarHoras(Integer horas){
        if(horas == null){
            throw new RegraDeNegocioException("É necessário informar as horas");
        }

        if(horas < 0){
            throw new RegraDeNegocioException("Horas não pode ser negativo");
        }
    }

    public static void validarValorPorHora(BigDecimal valorPorHora){
        if(valorPorHora == null){
            throw new RegraDeNegocioException("É necessário informar valor por hora");
        }

        if(valorPorHora.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException("Valor por hora não pode ser negativo");
        }
    }

    public static void validarBonus(BigDecimal bonus){
        if(bonus == null){
            throw new RegraDeNegocioException("É necessário informar bônus");
        }

        if(bonus.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException("Bônus não pode ser negativo");
        }
    }
}
