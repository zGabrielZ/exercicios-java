package br.com.gabrielferreira.figura.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Figura implements Serializable {

    @Serial
    private static final long serialVersionUID = 5746766629285155713L;

    @EqualsAndHashCode.Include
    private UUID id;

    public abstract BigDecimal calcularArea();
}
