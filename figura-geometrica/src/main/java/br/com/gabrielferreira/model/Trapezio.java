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
public class Trapezio extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    private Integer baseMaior;

    private Integer baseMenor;

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
        BigDecimal resultadoDivisao = divide(resultadoSomaBaseMaiorComBaseMenor, toBigDecimal(2.0));
        return toRetorno(multiplicar(resultadoDivisao, toBigDecimal(altura)), 2, RoundingMode.HALF_EVEN);
    }
}
