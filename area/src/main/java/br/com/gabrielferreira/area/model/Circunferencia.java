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
public class Circunferencia implements AreaCalculavel, Serializable {

    @Serial
    private static final long serialVersionUID = 5415910110973176523L;

    private static final double PI = 3.141592653589793;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer raio;

    @Override
    public BigDecimal calcularArea() {
        validarNumeroInformado(raio, "É necessário infomar o raio da circunferência");
        BigDecimal resultado = multiplicar(toBigDecimal(raio).pow(2), toBigDecimal(PI));
        return toRetorno(resultado, 2, RoundingMode.HALF_EVEN);
    }
}
