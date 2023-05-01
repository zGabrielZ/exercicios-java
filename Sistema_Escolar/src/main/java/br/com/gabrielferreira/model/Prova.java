package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Generated
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Prova implements Serializable {

    @Serial
    private static final long serialVersionUID = -1449377219367520562L;

    @EqualsAndHashCode.Include
    private UUID id;

    private String disciplina;

    private Double notaParte1;

    private Double notaParte2;

    public Double calcularNotaTotal(){
        if(notaParte1 == null || notaParte2 == null){
            throw new RegraDeNegocioException("É necessário informar as duas notas");
        }

        double soma = notaParte1 + notaParte2;
        if(soma > 10.0){
            throw new RegraDeNegocioException("A soma das duas notas não pode ultrapassar de 10.0");
        }
        return soma;
    }
}
