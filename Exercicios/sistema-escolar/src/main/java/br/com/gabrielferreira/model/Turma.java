package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalcularUtils.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Turma implements Serializable {

    @Serial
    private static final long serialVersionUID = 7813397152218587592L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private UUID id;

    @Getter
    @Setter
    private String descricao;

    @Getter
    @Setter
    private List<Aluno> alunos = new ArrayList<>();

    public BigDecimal calcularMedia(){
        List<BigDecimal> valores = alunos.stream().map(Aluno::calcularMedia).toList();
        BigDecimal somaTotal = somar(valores.toArray(new BigDecimal[alunos.size()]));
        return divide(somaTotal, BigDecimal.valueOf(alunos.size()), RoundingMode.HALF_EVEN);
    }
}
