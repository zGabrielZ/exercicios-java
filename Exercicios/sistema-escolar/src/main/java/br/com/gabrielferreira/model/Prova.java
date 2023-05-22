package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidarCalculo.*;
import static br.com.gabrielferreira.utils.CalcularUtils.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Prova implements Serializable {

    @Serial
    private static final long serialVersionUID = -1449377219367520562L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private UUID id;

    @Getter
    @Setter
    private String disciplina;

    @Getter
    @Setter
    private BigDecimal notaParte1;

    @Getter
    @Setter
    private BigDecimal notaParte2;

    public BigDecimal calcularNotaTotal(){
        validarValorInformado(notaParte1, "É necessário informar a primeira nota");
        validarValorInformado(notaParte2, "É necessário informar a segunda nota");

        BigDecimal soma = somar(notaParte1, notaParte2);
        validarLimteNota(soma);
        return soma;
    }
}
