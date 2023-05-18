package br.com.gabrielferreira.model;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
public class Ponto3D extends Ponto2D {

    @Serial
    private static final long serialVersionUID = -4540216104680662311L;

    @Getter
    private final BigDecimal coordZ;

    public Ponto3D(UUID id, BigDecimal coordX, BigDecimal coordY, BigDecimal coordZ) {
        super(id, coordX, coordY);
        this.coordZ = coordZ;
    }

    @Override
    public String toString() {
        return String.format("%s, coordZ : %s", super.toString(), coordZ);
    }
}
