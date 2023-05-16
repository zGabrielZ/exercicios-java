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
public class Trapezio extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private UUID id;

    @Getter
    @Setter
    private Integer baseMaior;

    @Getter
    @Setter
    private Integer baseMenor;

    @Getter
    @Setter
    private Integer altura;


    @Override
    public BigDecimal calcularArea() {

        if(baseMaior == null){
            throw new RegraDeNegocioException("É necessário informar a base maior");
        }

        if(baseMenor == null){
            throw new RegraDeNegocioException("É necessário informar a base menor");
        }

        if(altura == null){
            throw new RegraDeNegocioException("É necessário informar a altura");
        }


        return BigDecimal.valueOf(((baseMaior + baseMenor) / 2.0) * altura);
    }
}
