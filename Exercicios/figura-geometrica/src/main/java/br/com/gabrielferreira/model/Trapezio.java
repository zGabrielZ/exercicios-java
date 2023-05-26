package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidarCalcularArea.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class Trapezio extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    @Getter
    @Setter
    private Integer baseMaior;

    @Getter
    @Setter
    private Integer baseMenor;

    @Getter
    @Setter
    private Integer altura;

    public Trapezio(UUID id, Integer baseMaior, Integer baseMenor, Integer altura){
        super(id);
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
    }


    @Override
    public BigDecimal calcularArea() {
        validarValorInformado(baseMaior, "É necessário informar a base maior");
        validarValorInformado(baseMenor, "É necessário informar a base menor");
        validarValorInformado(altura, "É necessário informar a altura");
        BigDecimal resultadoSomaBaseMaiorComBaseMenor = somar(toBigDecimal(baseMaior), toBigDecimal(baseMenor));
        BigDecimal resultadoDivisao = divide(resultadoSomaBaseMaiorComBaseMenor, toBigDecimal(2.0), RoundingMode.HALF_EVEN);
        return multiplicar(resultadoDivisao, toBigDecimal(altura));
    }
}
