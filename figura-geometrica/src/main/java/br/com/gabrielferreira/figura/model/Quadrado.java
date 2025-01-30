package br.com.gabrielferreira.figura.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.commons.utils.CalculoUtils.toRetorno;
import static br.com.gabrielferreira.figura.validate.ValidarCalcularArea.validarValorInformado;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Data
public class Quadrado extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    private Integer lado;

    public Quadrado(UUID id, Integer lado){
        super(id);
        this.lado = lado;
    }

    @Override
    public BigDecimal calcularArea() {
        validarValorInformado(lado, "É necessário informar o lado");
        BigDecimal resultado = toBigDecimal(lado).pow(2);
        return toRetorno(resultado, 2, RoundingMode.HALF_EVEN);
    }
}
