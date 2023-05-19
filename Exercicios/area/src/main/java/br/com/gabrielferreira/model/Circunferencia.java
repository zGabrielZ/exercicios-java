package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidacaoCalculoArea.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Circunferencia implements AreaCalculavel, Serializable {

    @Serial
    private static final long serialVersionUID = 5415910110973176523L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer raio;

    @Override
    public BigDecimal calcularArea() {
        validarNumeroInformado(raio, "É necessário infomar o raio da circunferência");
        return BigDecimal.valueOf(Math.pow(raio, 2)).multiply(BigDecimal.valueOf(Math.PI));
    }
}
