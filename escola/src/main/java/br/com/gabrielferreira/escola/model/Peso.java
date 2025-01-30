package br.com.gabrielferreira.escola.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Peso implements Serializable {

    @Serial
    private static final long serialVersionUID = -1998463533526511852L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer valor;
}
