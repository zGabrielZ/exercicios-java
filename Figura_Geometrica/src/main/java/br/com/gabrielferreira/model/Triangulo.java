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
public class Triangulo extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer base;

    private Integer altura;

    @Override
    public Double calcularArea() {

        if(base == null){
            throw new RegraDeNegocioException("É necessário informar a base");
        }

        if(altura == null){
            throw new RegraDeNegocioException("É necessário informar a altura");
        }

        return (base * altura) / 2.0;
    }
}
