package br.com.gabrielferreira.curso.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(exclude = {"alunos"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Curso implements Serializable {

    @Serial
    private static final long serialVersionUID = -1083799102490754440L;

    @EqualsAndHashCode.Include
    private UUID id;

    private String tipoCurso;

    private List<Aluno> alunos = new ArrayList<>();
}
