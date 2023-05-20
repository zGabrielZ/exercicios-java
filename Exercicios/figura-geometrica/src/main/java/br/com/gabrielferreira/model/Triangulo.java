package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidarCalcularArea.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class Triangulo extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private UUID id;

    @Getter
    @Setter
    private Integer base;

    @Getter
    @Setter
    private Integer altura;

    @Override
    public BigDecimal calcularArea() {
        validarValorInformado(base, "É necessário informar a base");
        validarValorInformado(altura, "É necessário informar a altura");
        int resultadoBaseAltura = base * altura;
        return BigDecimal.valueOf(resultadoBaseAltura).divide(BigDecimal.valueOf(2.0), RoundingMode.HALF_EVEN);
    }
}
