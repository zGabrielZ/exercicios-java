package br.com.gabrielferreira.validate;

import br.com.gabrielferreira.exception.RegraDeNegocioException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static br.com.gabrielferreira.utils.DataUtils.*;

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

    public static void validarPreco(BigDecimal preco, String msg1, String msg2){
        if(preco == null){
            throw new RegraDeNegocioException(msg1);
        }

        if(preco.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException(msg2);
        }
    }

    public static void validarDataFabricada(LocalDate data){
        if(data == null){
            throw new RegraDeNegocioException("É necessário informar data");
        }

        if(data.isAfter(toDataAtualBrasil())){
            throw new RegraDeNegocioException("A data fabricada não pode ser maior que a data atual");
        }
    }
}
