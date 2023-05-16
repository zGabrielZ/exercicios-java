package br.com.gabrielferreira.model;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Figura implements Serializable {

    @Serial
    private static final long serialVersionUID = 5746766629285155713L;

    public abstract BigDecimal calcularArea();
}
