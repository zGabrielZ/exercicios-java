package br.com.gabrielferreira.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Peso implements Serializable {

    @Serial
    private static final long serialVersionUID = -1998463533526511852L;

    private UUID id;

    private Integer valor;

    public Peso(){}

    public Peso(UUID id, Integer valor) {
        this.id = id;
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peso peso = (Peso) o;
        return id.equals(peso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Peso{" +
                "id=" + id +
                ", valor=" + valor +
                '}';
    }
}
