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
public class Retangulo implements AreaCalculavel, Serializable {

    @Serial
    private static final long serialVersionUID = 5415910110973176523L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer base;

    private Integer altura;

    @Override
    public BigDecimal calcularArea() {
        validarNumeroInformado(base, "É necessário infomar a base do retângulo");
        validarNumeroInformado(altura, "É necessário infomar a altura do retângulo");
        BigDecimal resultado = multiplicar(toBigDecimal(base), toBigDecimal(altura));
        return toRetorno(resultado, 2, RoundingMode.HALF_EVEN);
    }
}
