package br.com.gabrielferreira.area.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;
import static br.com.gabrielferreira.area.validate.ValidacaoCalculoArea.validarNumeroInformado;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
        BigDecimal resultado = multiplicar(ladoBigDecimal, ladoBigDecimal);
        return toRetorno(resultado, 2, RoundingMode.HALF_EVEN);
    }
}
