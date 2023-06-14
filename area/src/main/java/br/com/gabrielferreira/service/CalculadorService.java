package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.AreaCalculavel;
import br.com.gabrielferreira.model.FiguraComplexa;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class CalculadorService implements Serializable {

    @Serial
    private static final long serialVersionUID = 6730307453958143191L;

    public BigDecimal somarCalculoAreas(List<AreaCalculavel> areas){
        validarAreas(areas);
        FiguraComplexa figuraComplexa = new FiguraComplexa(UUID.randomUUID(), areas);
        return figuraComplexa.calcularArea();
    }

    private void validarAreas(List<AreaCalculavel> areas){
        if(areas == null || areas.isEmpty()){
            throw new RegraDeNegocioException("É necessário informar pelo menos uma área");
        }

        areas.forEach(areaCalculavel -> {
            if(areaCalculavel == null){
                throw new RegraDeNegocioException("É necessário informar área");
            }
        });
    }
}
