package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Generated
public class Ponto2D implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Double coordX;
    private Double coordY;

    @Override
    public String toString() {
        return String.format("ID : %s, Coordenada X : %s, Coordenada Y : %s", id, coordX, coordY);
    }
}
