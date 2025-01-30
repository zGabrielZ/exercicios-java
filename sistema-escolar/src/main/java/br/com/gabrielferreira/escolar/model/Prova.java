package br.com.gabrielferreira.escolar.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.somar;
import static br.com.gabrielferreira.escolar.validate.ValidarCalculo.validarLimteNota;
import static br.com.gabrielferreira.escolar.validate.ValidarCalculo.validarValorInformado;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Prova implements Serializable {

    @Serial
    private static final long serialVersionUID = -1449377219367520562L;

    @EqualsAndHashCode.Include
    private UUID id;

    private String disciplina;

    private BigDecimal notaParte1;

    private BigDecimal notaParte2;

    public BigDecimal calcularNotaTotal(){
        validarValorInformado(notaParte1, "É necessário informar a primeira nota");
        validarValorInformado(notaParte2, "É necessário informar a segunda nota");

        BigDecimal soma = somar(notaParte1, notaParte2);
        validarLimteNota(soma);
        return soma;
    }
}
