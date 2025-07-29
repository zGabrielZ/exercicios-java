package br.com.gabrielferreira.jokenpo.factory;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.jokenpo.model.Partida;
import br.com.gabrielferreira.jokenpo.model.enumeration.Gesto;
import br.com.gabrielferreira.jokenpo.service.SolucaoPartidaService;
import br.com.gabrielferreira.jokenpo.service.impl.SolucaoPapelPartidaServiceImpl;
import br.com.gabrielferreira.jokenpo.service.impl.SolucaoPedraPartidaServiceImpl;
import br.com.gabrielferreira.jokenpo.service.impl.SolucaoTesouraPartidaServiceImpl;

public class SolucaoPartidaFactory {

    private SolucaoPartidaFactory() {}

    public static Partida criarPartida(Gesto primeiroAdversario, Gesto segundoAdversario) {
        if (primeiroAdversario == null || segundoAdversario == null) {
            throw new RegraDeNegocioException("Gesto não pode ser nulo");
        }

        Partida partida;
        SolucaoPartidaService solucaoPartidaService;
        switch (primeiroAdversario) {
            case PEDRA -> {
                solucaoPartidaService = new SolucaoPedraPartidaServiceImpl();
                partida = solucaoPartidaService.solucionarPartida(primeiroAdversario, segundoAdversario);
            }
            case PAPEL -> {
                solucaoPartidaService = new SolucaoPapelPartidaServiceImpl();
                partida = solucaoPartidaService.solucionarPartida(primeiroAdversario, segundoAdversario);
            }
            case TESOURA -> {
                solucaoPartidaService = new SolucaoTesouraPartidaServiceImpl();
                partida = solucaoPartidaService.solucionarPartida(primeiroAdversario, segundoAdversario);
            }
            default -> throw new RegraDeNegocioException("Gesto inválido: " + primeiroAdversario);
        }
        return partida;
    }
}
