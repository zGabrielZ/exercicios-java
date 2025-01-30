package br.com.gabrielferreira.figura.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;
import static br.com.gabrielferreira.figura.validate.ValidarCalcularArea.validarValorInformado;

@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@Data
public class Circunferencia extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    private static final double PI = 3.141592653589793;

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
