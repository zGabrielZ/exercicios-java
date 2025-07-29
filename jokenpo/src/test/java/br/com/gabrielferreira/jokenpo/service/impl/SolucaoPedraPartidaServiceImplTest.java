package br.com.gabrielferreira.jokenpo.service.impl;

import br.com.gabrielferreira.jokenpo.model.enumeration.Gesto;
import br.com.gabrielferreira.jokenpo.model.enumeration.Resultado;
import br.com.gabrielferreira.jokenpo.service.SolucaoPartidaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SolucaoPedraPartidaServiceImplTest {

    private SolucaoPartidaService solucaoPartidaService;

    @BeforeEach
    void setUp() {
        solucaoPartidaService = new SolucaoPedraPartidaServiceImpl();
    }

    @Test
    @DisplayName("Dado primeiro adversário pedra e segundo adversário pedra, quando solucionar partida, então deve retornar empate para ambos")
    void dadoPrimeiroAdversarioPedraSegundoAdversarioPedra_quandoSolucionarPartida_entaoDeveRetornarEmpateParaAmbos() {
        Gesto primeiroGesto = Gesto.PEDRA;
        Gesto segundoGesto = Gesto.PEDRA;

        var partida = solucaoPartidaService.solucionarPartida(primeiroGesto, segundoGesto);
        assertNotNull(partida);
        assertEquals(primeiroGesto, partida.getPrimeiroAdversario().getGesto());
        assertEquals(segundoGesto, partida.getSegundoAdversario().getGesto());
        assertEquals(Resultado.EMPATE, partida.getPrimeiroAdversario().getResultado());
        assertEquals(Resultado.EMPATE, partida.getSegundoAdversario().getResultado());
        assertEquals("Empate!", partida.placar());
    }

    @Test
    @DisplayName("Dado primeiro adversário pedra e segundo adversário papel, quando solucionar partida, então deve retornar derrota para o primeiro adversário")
    void dadoPrimeiroAdversarioPedraSegundoAdversarioPapel_quandoSolucionarPartida_entaoDeveRetornarDerrotaParaPrimeiroAdversario() {
        Gesto primeiroGesto = Gesto.PEDRA;
        Gesto segundoGesto = Gesto.PAPEL;

        var partida = solucaoPartidaService.solucionarPartida(primeiroGesto, segundoGesto);
        assertNotNull(partida);
        assertEquals(primeiroGesto, partida.getPrimeiroAdversario().getGesto());
        assertEquals(segundoGesto, partida.getSegundoAdversario().getGesto());
        assertEquals(Resultado.DERROTA, partida.getPrimeiroAdversario().getResultado());
        assertEquals(Resultado.VITORIA, partida.getSegundoAdversario().getResultado());
        assertEquals("Segundo Adversário venceu!", partida.placar());
    }

    @Test
    @DisplayName("Dado primeiro adversário pedra e segundo adversário tesoura, quando solucionar partida, então deve retornar vitória para o primeiro adversário")
    void dadoPrimeiroAdversarioPedraSegundoAdversarioTesoura_quandoSolucionarPartida_entaoDeveRetornarVitoriaParaPrimeiroAdversario() {
        Gesto primeiroGesto = Gesto.PEDRA;
        Gesto segundoGesto = Gesto.TESOURA;

        var partida = solucaoPartidaService.solucionarPartida(primeiroGesto, segundoGesto);
        assertNotNull(partida);
        assertEquals(primeiroGesto, partida.getPrimeiroAdversario().getGesto());
        assertEquals(segundoGesto, partida.getSegundoAdversario().getGesto());
        assertEquals(Resultado.VITORIA, partida.getPrimeiroAdversario().getResultado());
        assertEquals(Resultado.DERROTA, partida.getSegundoAdversario().getResultado());
        assertEquals("Primeiro Adversário venceu!", partida.placar());
    }
}