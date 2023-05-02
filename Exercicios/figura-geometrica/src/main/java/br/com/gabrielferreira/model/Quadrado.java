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
public class Quadrado extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer lado;


    @Override
    public Double calcularArea() {
        if(lado == null){
            throw new RegraDeNegocioException("É necessário informar o lado");
        }

        return Math.pow(lado, 2);
    }
}
