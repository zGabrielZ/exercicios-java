package br.com.gabrielferreira.funcionario.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;
import static br.com.gabrielferreira.funcionario.validate.ValidarCampos.*;
import static br.com.gabrielferreira.commons.utils.MascarasUtils.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Funcionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @Getter
    @EqualsAndHashCode.Include
    private final UUID id;

    @Getter
    private final String nome;

    @Getter
    private final Integer horas;

    @Getter
    private final BigDecimal valorPorHora;

    public Funcionario(UUID id, String nome, Integer horas, BigDecimal valorPorHora) {
        this.id = id;
        this.nome = nome;
        this.horas = horas;
        this.valorPorHora = valorPorHora;

        validarId(this.id);
        validarNome(this.nome);
        validarHoras(this.horas);
        validarValorPorHora(this.valorPorHora);
    }

    public BigDecimal getPagamento(){
        return multiplicar(valorPorHora, toBigDecimal(horas));
    }

    @Override
    public String toString() {
        return nome + " - " + valorMonetarioBrasil(getPagamento());
    }
}
