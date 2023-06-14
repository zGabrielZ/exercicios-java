package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.somar;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class FiguraComplexa implements AreaCalculavel, Serializable {

    @Serial
    private static final long serialVersionUID = 5415910110973176523L;

    private static final double PI = 3.141592653589793;

    @EqualsAndHashCode.Include
    private UUID id;

    private transient List<AreaCalculavel> areas = new ArrayList<>();

    @Override
    public BigDecimal calcularArea() {
        BigDecimal soma = BigDecimal.ZERO;
        for (AreaCalculavel area : areas) {
            soma = somar(soma, area.calcularArea());
        }
        return soma;
    }
}
