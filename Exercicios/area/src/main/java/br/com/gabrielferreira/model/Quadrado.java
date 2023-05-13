package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Quadrado implements AreaCalculavel, Serializable {

    @Serial
    private static final long serialVersionUID = 5415910110973176523L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer lado;

    @Override
    public BigDecimal calcularArea() {
        if(lado == null){
            throw new RegraDeNegocioException("É necessário infomar o lado do quadrado");
        }

        return BigDecimal.valueOf(lado).multiply(BigDecimal.valueOf(lado));
    }
}
