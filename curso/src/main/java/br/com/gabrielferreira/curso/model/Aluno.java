package br.com.gabrielferreira.curso.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Aluno implements Serializable {

    @Serial
    private static final long serialVersionUID = -1083799102490754440L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer codigoAluno;
}
