package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidarCalcularArea.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
public class Circunferencia extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    private static final double PI = 3.141592653589793;

    @Getter
    @Setter
    private Integer raio;

    public Circunferencia(UUID id, Integer raio){
        super(id);
        this.raio = raio;
    }

    @Override
    public BigDecimal calcularArea() {
        validarValorInformado(raio, "É necessário informar o raio");
        BigDecimal resultado = multiplicar(toBigDecimal(raio).pow(2), toBigDecimal(PI));
        return toRetorno(resultado, 2, RoundingMode.HALF_EVEN);
    }
}
