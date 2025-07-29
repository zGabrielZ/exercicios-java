package br.com.gabrielferreira.jokenpo.main;

import br.com.gabrielferreira.jokenpo.factory.SolucaoPartidaFactory;
import br.com.gabrielferreira.jokenpo.model.Partida;
import br.com.gabrielferreira.jokenpo.model.enumeration.Gesto;

public class Jogo {

    public static void main(String[] args) {
        Gesto primeiroAdversario = Gesto.PEDRA;
        Gesto segundoAdversario = Gesto.TESOURA;

        Partida partida = SolucaoPartidaFactory.criarPartida(primeiroAdversario, segundoAdversario);
        System.out.println(partida);
        System.out.println(partida.placar());
    }
}
