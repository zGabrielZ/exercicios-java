package br.com.gabrielferreira.model;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;

import java.io.Serial;
import java.util.UUID;

@Getter
@EqualsAndHashCode(callSuper = true)
@Generated
public class Ponto3D extends Ponto2D {

    @Serial
    private static final long serialVersionUID = -4540216104680662311L;
    private final Double coordZ;

    public Ponto3D(UUID id, Double coordX, Double coordY, Double coordZ) {
        super(id, coordX, coordY);
        this.coordZ = coordZ;
    }

    @Override
    public String toString() {
        String toString = super.toString();
        return toString + ", Coordenada Z : " + coordZ;
    }
}