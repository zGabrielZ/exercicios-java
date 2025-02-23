package br.com.gabrielferreira.trabalhador.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.trabalhador.model.ContratoHora;
import java.math.BigDecimal;
import java.util.UUID;
import static br.com.gabrielferreira.commons.utils.DataUtils.*;

public class ContratoHoraService {

    public ContratoHora criarContratoHora(String data, BigDecimal valorPorHora, Integer horas){
        validarData(data);
        validarValorPorHora(valorPorHora);
        validarHoras(horas);

        return ContratoHora.builder()
                .id(UUID.randomUUID())
                .data(toDataBrasil(data))
                .valorPorHora(valorPorHora)
                .horas(horas)
                .build();
    }

    private void validarData(String data){
        if(data == null){
            throw new RegraDeNegocioException("É necessário informar a data");
        }
    }

    private void validarValorPorHora(BigDecimal valorPorHora){
        if(valorPorHora == null){
            throw new RegraDeNegocioException("É necessário informar o valor por hora");
        }

        if(valorPorHora.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException("Valor por hora não pode ser negativo");
        }
    }

    private void validarHoras(Integer horas){
        if(horas == null){
            throw new RegraDeNegocioException("É necessário informar as horas");
        }

        if(horas < 0){
            throw new RegraDeNegocioException("Horas não pode ser negativa");
        }
    }
}
