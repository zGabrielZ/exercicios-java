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
public class Aluno implements Serializable {

    @Serial
    private static final long serialVersionUID = -1083799102490754440L;

    @EqualsAndHashCode.Include
    private UUID id;

    private String nome;

    private Prova prova1;

    private Prova prova2;

    public Double calcularMedia(){
        if(prova1 == null || prova2 == null){
            throw new RegraDeNegocioException("É necessário informar as duas provas do aluno");
        }

        return (prova1.calcularNotaTotal() + prova2.calcularNotaTotal()) / 2;
    }
}
