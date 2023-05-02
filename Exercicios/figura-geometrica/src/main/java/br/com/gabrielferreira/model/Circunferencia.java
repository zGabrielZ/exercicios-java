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
public class Circunferencia extends Figura{

    @Serial
    private static final long serialVersionUID = -6040100702355337574L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer raio;


    @Override
    public Double calcularArea() {
        if(raio == null){
            throw new RegraDeNegocioException("É necessário informar o raio");
        }

        return Math.pow(raio, 2) * Math.PI;
    }
}
