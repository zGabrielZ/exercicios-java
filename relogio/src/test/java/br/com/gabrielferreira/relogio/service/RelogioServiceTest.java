package br.com.gabrielferreira.relogio.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.relogio.model.Relogio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RelogioServiceTest {

    private RelogioService relogioService;

    @BeforeEach
    public void criarInstancias(){
        relogioService = new RelogioService();
    }

    @Test
    @DisplayName("Deveria validar a hora quando não informar")
    void deveValidarHora(){
        assertThrows(RegraDeNegocioException.class, () -> relogioService.acertarRelogio(null, 10,10));
    }

    @Test
    @DisplayName("Deveria validar o minuto quando não informar")
    void deveValidarMinuto(){
        assertThrows(RegraDeNegocioException.class, () -> relogioService.acertarRelogio(10, null,10));
    }

    @Test
    @DisplayName("Deveria validar o segundo quando não informar")
    void deveValidarSegundi(){
        assertThrows(RegraDeNegocioException.class, () -> relogioService.acertarRelogio(10, 10,null));
    }

    @Test
    @DisplayName("Deveria acertar relogio quando informar")
    void deveAcertarRelogio(){
        Relogio relogio = relogioService.acertarRelogio(3, 10,20);

        assertEquals(3, relogio.lerHora());
        assertEquals(10, relogio.lerMinuto());
        assertEquals(20, relogio.lerSegundo());
        assertEquals(3, relogio.lerPosicaoHora());
        assertEquals(2, relogio.lerPosicaoMinuto());
        assertEquals(4, relogio.lerPosicaoSegundo());
    }

    @Test
    @DisplayName("Deveria validar a hora quando não encontrar")
    void deveNaoEncontrarHora(){
        Relogio relogio = new Relogio();
        assertThrows(RegraDeNegocioException.class, relogio::lerHora);
    }

    @Test
    @DisplayName("Deveria validar o minuto quando não encontrar")
    void deveNaoEncontrarMinuto(){
        Relogio relogio = new Relogio();
        assertThrows(RegraDeNegocioException.class, relogio::lerMinuto);
    }

    @Test
    @DisplayName("Deveria validar o segundo quando não encontrar")
    void deveNaoEncontrarSegundo(){
        Relogio relogio = new Relogio();
        assertThrows(RegraDeNegocioException.class, relogio::lerSegundo);
    }
}
