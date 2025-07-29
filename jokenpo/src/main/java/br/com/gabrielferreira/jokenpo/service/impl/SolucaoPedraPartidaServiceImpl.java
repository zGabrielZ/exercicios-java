package br.com.gabrielferreira.jokenpo.service.impl;

import br.com.gabrielferreira.jokenpo.model.Adversario;
import br.com.gabrielferreira.jokenpo.model.Partida;
import br.com.gabrielferreira.jokenpo.model.enumeration.Gesto;
import br.com.gabrielferreira.jokenpo.model.enumeration.Resultado;
import br.com.gabrielferreira.jokenpo.service.SolucaoPartidaService;

public class SolucaoPedraPartidaServiceImpl implements SolucaoPartidaService {

    @Override
    public Partida solucionarPartida(Gesto primeiroGesto, Gesto segundoGesto) {
        Adversario.AdversarioBuilder primeiroAdversario = Adversario.builder()
                .gesto(primeiroGesto);
        Adversario.AdversarioBuilder segundoAdversario = Adversario.builder()
                .gesto(segundoGesto);

        // Pedra x Pedra
        if (segundoGesto.equals(Gesto.PEDRA)) {
            primeiroAdversario.resultado(Resultado.EMPATE);
            segundoAdversario.resultado(Resultado.EMPATE);
        }

        // Pedra x Papel
        if (segundoGesto.equals(Gesto.PAPEL)) {
            primeiroAdversario.resultado(Resultado.DERROTA);
            segundoAdversario.resultado(Resultado.VITORIA);
        }

        // Pedra x Tesoura
        if (segundoGesto.equals(Gesto.TESOURA)) {
            primeiroAdversario.resultado(Resultado.VITORIA);
            segundoAdversario.resultado(Resultado.DERROTA);
        }

        return Partida.builder()
                .primeiroAdversario(primeiroAdversario.build())
                .segundoAdversario(segundoAdversario.build())
                .build();
    }
}
