package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidarCalcularArea.*;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class Quadrado extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    @Getter
    @Setter
    private Integer lado;

    public Quadrado(UUID id, Integer lado){
        super(id);
        this.lado = lado;
    }

    @Override
    public BigDecimal calcularArea() {
        validarValorInformado(lado, "É necessário informar o lado");
        return BigDecimal.valueOf(Math.pow(lado, 2));
    }
}
