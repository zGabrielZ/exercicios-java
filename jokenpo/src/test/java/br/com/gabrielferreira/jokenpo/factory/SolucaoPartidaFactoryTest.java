package br.com.gabrielferreira.jokenpo.factory;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.jokenpo.model.enumeration.Gesto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolucaoPartidaFactoryTest {

    @Test
    @DisplayName("Dado primeiro adversário nulo quando criar partida então deve lançar exceção")
    void dadoPrimeiroAdversarioNulo_quandoCriarPartida_entaoDeveLancarExcecao() {
        Exception exception = assertThrows(RegraDeNegocioException.class, () -> {
            SolucaoPartidaFactory.criarPartida(null, Gesto.PAPEL);
        });
        assertEquals("Gesto não pode ser nulo", exception.getMessage());
    }

    @Test
    @DisplayName("Dado segundo adversário nulo quando criar partida então deve lançar exceção")
    void dadoSegundoAdversarioNulo_quandoCriarPartida_entaoDeveLancarExcecao() {
        Exception exception = assertThrows(RegraDeNegocioException.class, () -> {
            SolucaoPartidaFactory.criarPartida(Gesto.PAPEL, null);
        });
        assertEquals("Gesto não pode ser nulo", exception.getMessage());
    }

    @Test
    @DisplayName("Dado primeiro adversário nulo e segundo adversário nulo quando criar partida então deve lançar exceção")
    void dadoPrimeiroAdversarioNuloSegundoAdversarioNulo_quandoCriarPartida_entaoDeveLancarExcecao() {
        Exception exception = assertThrows(RegraDeNegocioException.class, () -> {
            SolucaoPartidaFactory.criarPartida(null, null);
        });
        assertEquals("Gesto não pode ser nulo", exception.getMessage());
    }

    @Test
    @DisplayName("Dado primeiro adversário pedra quando criar partida então deve retornar partida com resultado correto")
    void dadoPrimeiroAdversarioPedra_quandoCriarPartida_entaoDeveRetornarPartidaComResultadoCorreto() {
        var partida = SolucaoPartidaFactory.criarPartida(Gesto.PEDRA, Gesto.TESOURA);
        assertEquals("Primeiro Adversário venceu!", partida.placar());
    }

    @Test
    @DisplayName("Dado primeiro adversário papel quando criar partida então deve retornar partida com resultado correto")
    void dadoPrimeiroAdversarioPapel_quandoCriarPartida_entaoDeveRetornarPartidaComResultadoCorreto() {
        var partida = SolucaoPartidaFactory.criarPartida(Gesto.PAPEL, Gesto.PEDRA);
        assertEquals("Primeiro Adversário venceu!", partida.placar());
    }

    @Test
    @DisplayName("Dado primeiro adversário tesoura quando criar partida então deve retornar partida com resultado correto")
    void dadoPrimeiroAdversarioTesoura_quandoCriarPartida_entaoDeveRetornarPartidaComResultadoCorreto() {
        var partida = SolucaoPartidaFactory.criarPartida(Gesto.TESOURA, Gesto.PAPEL);
        assertEquals("Primeiro Adversário venceu!", partida.placar());
    }
}