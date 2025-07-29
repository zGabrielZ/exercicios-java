package br.com.gabrielferreira.jokenpo.service;

import br.com.gabrielferreira.jokenpo.model.Partida;
import br.com.gabrielferreira.jokenpo.model.enumeration.Gesto;

public interface SolucaoPartidaService {

    Partida solucionarPartida(Gesto primeiroGesto, Gesto segundoGesto);
}
