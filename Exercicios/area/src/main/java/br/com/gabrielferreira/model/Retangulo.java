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
public class Retangulo implements AreaCalculavel, Serializable {

    @Serial
    private static final long serialVersionUID = 5415910110973176523L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer base;

    private Integer altura;

    @Override
    public BigDecimal calcularArea() {
        if(base == null){
            throw new RegraDeNegocioException("É necessário infomar a base do retângulo");
        }

        if(altura == null){
            throw new RegraDeNegocioException("É necessário infomar a altura do retângulo");
        }

        return BigDecimal.valueOf(base).multiply(BigDecimal.valueOf(altura));
    }
}
