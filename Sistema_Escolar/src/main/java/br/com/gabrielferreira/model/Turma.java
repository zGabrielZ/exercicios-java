package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Generated
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Turma implements Serializable {

    @Serial
    private static final long serialVersionUID = 7813397152218587592L;

    @EqualsAndHashCode.Include
    private UUID id;

    private String descricao;

    private List<Aluno> alunos = new ArrayList<>();

    public Double calcularMedia(){
        return (alunos.stream().mapToDouble(Aluno::calcularMedia).sum()) / alunos.size();
    }
}
