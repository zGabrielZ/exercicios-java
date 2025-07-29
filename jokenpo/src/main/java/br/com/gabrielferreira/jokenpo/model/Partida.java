package br.com.gabrielferreira.jokenpo.model;

import br.com.gabrielferreira.jokenpo.model.enumeration.Resultado;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class Partida implements Serializable {

    @Serial
    private static final long serialVersionUID = 5659035377342110416L;

    private Adversario primeiroAdversario;
    private Adversario segundoAdversario;

    public String placar() {
        if (primeiroAdversario.getResultado().equals(Resultado.VITORIA)) {
            return "Primeiro Adversário venceu!";
        }

        if (segundoAdversario.getResultado().equals(Resultado.VITORIA)) {
            return "Segundo Adversário venceu!";
        }

        if (primeiroAdversario.getResultado().equals(Resultado.EMPATE)) {
            return "Empate!";
        }

        return "Partida não finalizada!";
    }
}
