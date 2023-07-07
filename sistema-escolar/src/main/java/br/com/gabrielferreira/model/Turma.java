package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Turma implements Serializable {

    @Serial
    private static final long serialVersionUID = 7813397152218587592L;

    @EqualsAndHashCode.Include
    private UUID id;

    private String descricao;

    private List<Aluno> alunos = new ArrayList<>();

    public BigDecimal calcularMedia(){
        List<BigDecimal> valores = alunos.stream().map(Aluno::calcularMedia).toList();
        BigDecimal somaTotal = somar(valores.toArray(new BigDecimal[alunos.size()]));
        return toRetorno(divide(somaTotal, BigDecimal.valueOf(alunos.size())), 2, RoundingMode.HALF_EVEN);
    }
}
