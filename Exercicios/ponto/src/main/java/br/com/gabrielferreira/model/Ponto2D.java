package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ponto2D implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @Getter
    @EqualsAndHashCode.Include
    private UUID id;

    @Getter
    private BigDecimal coordX;

    @Getter
    private BigDecimal coordY;

    @Override
    public String toString() {
        return String.format("Id : %s, coordX : %s, coordY : %s", id, coordX, coordY);
    }
}
