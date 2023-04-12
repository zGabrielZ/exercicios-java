package br.com.gabrielferreira.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Prova implements Serializable {

    @Serial
    private static final long serialVersionUID = 9162731473093293178L;

    private UUID id;

    private String nome;

    private Double nota;

    private Peso peso;

    public Prova(){}

    public Prova(UUID id, String nome ,Double nota, Peso peso) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.peso = peso;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Peso getPeso() {
        return peso;
    }

    public void setPeso(Peso peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prova prova = (Prova) o;
        return id.equals(prova.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Prova{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", peso=" + peso +
                '}';
    }
}
