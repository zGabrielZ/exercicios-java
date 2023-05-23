package br.com.gabrielferreira.model;

import lombok.*;
import static br.com.gabrielferreira.validate.ValidacaoCalculoArea.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
        validarNumeroInformado(lado, "É necessário infomar o lado do quadrado");
        BigDecimal ladoBigDecimal = toBigDecimal(lado);
        return multiplicar(ladoBigDecimal, ladoBigDecimal, 2, RoundingMode.HALF_EVEN);
    }
}
