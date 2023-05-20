package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Figura implements Serializable {

    @Serial
    private static final long serialVersionUID = 5746766629285155713L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private UUID id;

    public abstract BigDecimal calcularArea();
}
