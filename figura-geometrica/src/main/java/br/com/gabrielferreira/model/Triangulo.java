package br.com.gabrielferreira.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static br.com.gabrielferreira.validate.ValidarCalcularArea.validarValorInformado;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Data
public class Triangulo extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    private Integer base;

    private Integer altura;

    public Triangulo(UUID id, Integer base, Integer altura){
        super(id);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public BigDecimal calcularArea() {
        validarValorInformado(base, "É necessário informar a base");
        validarValorInformado(altura, "É necessário informar a altura");
        BigDecimal baseAltura = multiplicar(toBigDecimal(base), toBigDecimal(altura));
        return divide(baseAltura, toBigDecimal(2.0), RoundingMode.HALF_EVEN);
    }
}
