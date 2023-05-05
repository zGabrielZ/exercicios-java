package br.com.gabrielferreira.model;

import java.io.Serial;
import java.io.Serializable;

public abstract class Figura implements Serializable {

    @Serial
    private static final long serialVersionUID = 5746766629285155713L;

    public abstract Double calcularArea();
}