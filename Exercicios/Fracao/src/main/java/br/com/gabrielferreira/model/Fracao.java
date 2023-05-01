package br.com.gabrielferreira.model;

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
public class Fracao implements Serializable {

    @Serial
    private static final long serialVersionUID = -2869293483385468926L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer numerador;

    private Integer denominador;

    public String lerFracao(){
        return String.format("%s / %s", numerador, denominador);
    }
}
