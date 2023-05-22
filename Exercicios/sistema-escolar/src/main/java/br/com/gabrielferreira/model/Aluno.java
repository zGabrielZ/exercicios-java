package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidarProva.*;
import static br.com.gabrielferreira.utils.CalcularUtils.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Aluno implements Serializable {

    @Serial
    private static final long serialVersionUID = -1083799102490754440L;

    private static final BigDecimal MEDIA_PROVA = BigDecimal.valueOf(2.0);

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private UUID id;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private Prova provaParte1;

    @Getter
    @Setter
    private Prova provaParte2;

    public BigDecimal calcularMedia(){
        validarProvaInformada(provaParte1, "É necessário informar a primeira prova do aluno");
        validarProvaInformada(provaParte2, "É necessário informar a segunda prova do aluno");
        BigDecimal somaProvas = somar(provaParte1.calcularNotaTotal(), provaParte2.calcularNotaTotal());
        return divide(somaProvas, MEDIA_PROVA, RoundingMode.HALF_EVEN);
    }
}
