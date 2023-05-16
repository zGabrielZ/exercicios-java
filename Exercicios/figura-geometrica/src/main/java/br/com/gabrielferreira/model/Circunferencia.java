package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import lombok.*;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.UUID;

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
        if(raio == null){
            throw new RegraDeNegocioException("É necessário informar o raio");
        }

        return BigDecimal.valueOf(Math.pow(raio, 2)).multiply(BigDecimal.valueOf(Math.PI));
    }
}
