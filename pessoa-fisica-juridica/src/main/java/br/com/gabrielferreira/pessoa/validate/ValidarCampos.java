package br.com.gabrielferreira.pessoa.validate;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;

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

    public static void validarRendaAnual(BigDecimal rendaAnual){
        if(rendaAnual == null){
            throw new RegraDeNegocioException("É necessário informar renda anual");
        }

        if(rendaAnual.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException("Renda anual não pode ser negativo");
        }
    }

    public static void validarGastoSaude(BigDecimal gastoSaude){
        if(gastoSaude != null && gastoSaude.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException("Gasto com a saúde não pode ser negativo");
        }
    }

    public static void validarFuncionarios(Integer numeroFuncionarios){
        if(numeroFuncionarios == null){
            throw new RegraDeNegocioException("É necessário informar números de funcionários");
        }

        if(numeroFuncionarios < 0){
            throw new RegraDeNegocioException("Números de funcionários não pode ser negativo");
        }
    }
}
