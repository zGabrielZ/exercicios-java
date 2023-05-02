package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Generated
@ToString
public class Prova implements Serializable {

    @Serial
    private static final long serialVersionUID = 9162731473093293178L;

    @EqualsAndHashCode.Include
    private UUID id;

    private String nome;

    private Double nota;

    private Peso peso;
}
