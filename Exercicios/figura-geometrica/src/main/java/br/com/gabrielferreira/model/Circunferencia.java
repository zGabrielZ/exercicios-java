package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidarCalcularArea.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class Circunferencia extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private UUID id;

    @Getter
    @Setter
    private Integer raio;


    @Override
    public BigDecimal calcularArea() {
        validarValorInformado(raio, "É necessário informar o raio");
        return BigDecimal.valueOf(Math.pow(raio, 2)).multiply(BigDecimal.valueOf(Math.PI));
    }
}
