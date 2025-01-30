package br.com.gabrielferreira.eleicao.model;
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
public class Candidato implements Serializable {

    @Serial
    private static final long serialVersionUID = -1083799102490754440L;

    @EqualsAndHashCode.Include
    private UUID id;

    private String nome;

    private Integer quantidadeVotos;
}
