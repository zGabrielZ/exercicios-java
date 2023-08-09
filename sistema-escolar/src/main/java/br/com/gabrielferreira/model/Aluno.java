package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static br.com.gabrielferreira.validate.ValidarProva.validarProvaInformada;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Aluno implements Serializable {

    @Serial
    private static final long serialVersionUID = -1083799102490754440L;

    private static final BigDecimal MEDIA_PROVA = BigDecimal.valueOf(2.0);

    @EqualsAndHashCode.Include
    private UUID id;

    private String nome;

    private Prova provaParte1;

    private Prova provaParte2;

    public BigDecimal calcularMedia(){
        validarProvaInformada(provaParte1, "É necessário informar a primeira prova do aluno");
        validarProvaInformada(provaParte2, "É necessário informar a segunda prova do aluno");
        BigDecimal somaProvas = somar(provaParte1.calcularNotaTotal(), provaParte2.calcularNotaTotal());
        return divide(somaProvas, MEDIA_PROVA, 2, RoundingMode.HALF_EVEN);
    }
}
