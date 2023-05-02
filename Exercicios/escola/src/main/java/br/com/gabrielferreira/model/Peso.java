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
public class Peso implements Serializable {

    @Serial
    private static final long serialVersionUID = -1998463533526511852L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer valor;
}
