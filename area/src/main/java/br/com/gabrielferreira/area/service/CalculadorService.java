package br.com.gabrielferreira.area.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.area.model.AreaCalculavel;
import br.com.gabrielferreira.area.model.FiguraComplexa;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class CalculadorService {

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
