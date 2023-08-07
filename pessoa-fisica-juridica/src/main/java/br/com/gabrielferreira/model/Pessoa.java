package br.com.gabrielferreira.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.utils.MascarasUtils.*;
import static br.com.gabrielferreira.validate.ValidarCampos.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Pessoa implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @Getter
    @EqualsAndHashCode.Include
    private final UUID id;

    @Getter
    private final String nome;

    @Getter
    private final BigDecimal rendaAnual;

    protected Pessoa(UUID id, String nome, BigDecimal rendaAnual) {
        this.id = id;
        this.nome = nome;
        this.rendaAnual = rendaAnual;

        validarId(this.id);
        validarNome(this.nome);
        validarRendaAnual(this.rendaAnual);
    }

    public abstract BigDecimal getTaxaImposto();

    @Override
    public String toString() {
        return this.nome + " : " + valorMonetarioBrasil(getTaxaImposto());
    }
}
