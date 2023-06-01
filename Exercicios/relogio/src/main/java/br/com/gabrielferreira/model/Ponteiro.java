package br.com.gabrielferreira.model;

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
public class Ponteiro implements Serializable {

    @Serial
    private static final long serialVersionUID = -4233310079399156590L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer posicao;
}
