package br.com.gabrielferreira.jokenpo.model;

import br.com.gabrielferreira.jokenpo.model.enumeration.Gesto;
import br.com.gabrielferreira.jokenpo.model.enumeration.Resultado;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class Adversario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1419264788012438616L;

    private Gesto gesto;
    private Resultado resultado;
}
