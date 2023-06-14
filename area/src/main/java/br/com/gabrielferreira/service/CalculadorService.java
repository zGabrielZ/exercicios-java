package br.com.gabrielferreira.service;

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
        FiguraComplexa figuraComplexa = new FiguraComplexa(UUID.randomUUID(), areas);
        return figuraComplexa.calcularArea();
    }
}
