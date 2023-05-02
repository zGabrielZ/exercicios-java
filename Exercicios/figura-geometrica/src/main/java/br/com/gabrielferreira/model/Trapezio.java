package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import lombok.*;

import java.io.Serial;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Generated
@ToString
public class Trapezio extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer baseMaior;

    private Integer baseMenor;

    private Integer altura;


    @Override
    public Double calcularArea() {

        if(baseMaior == null){
            throw new RegraDeNegocioException("É necessário informar a base maior");
        }

        if(baseMenor == null){
            throw new RegraDeNegocioException("É necessário informar a base menor");
        }

        if(altura == null){
            throw new RegraDeNegocioException("É necessário informar a altura");
        }


        return ((baseMaior + baseMenor) / 2.0) * altura;
    }
}
