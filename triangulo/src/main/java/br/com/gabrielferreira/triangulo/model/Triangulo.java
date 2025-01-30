package br.com.gabrielferreira.triangulo.model;
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
public class Triangulo implements Serializable {

    @Serial
    private static final long serialVersionUID = -1083799102490754440L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Double ladoA;

    private Double ladoB;

    private Double ladoC;

    private Character tipoTriangulo;
    
    private Double resultadoFinalCalculoArea = 0.0;
}
