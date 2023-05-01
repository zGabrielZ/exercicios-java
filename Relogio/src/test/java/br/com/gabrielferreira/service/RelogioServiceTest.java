package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.ErroException;
import br.com.gabrielferreira.model.Relogio;
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
        assertThrows(ErroException.class, () -> relogioService.acertarRelogio(null, 10,10));
    }

    @Test
    @DisplayName("Deveria validar o minuto quando não informar")
    void deveValidarMinuto(){
        assertThrows(ErroException.class, () -> relogioService.acertarRelogio(10, null,10));
    }

    @Test
    @DisplayName("Deveria validar o segundo quando não informar")
    void deveValidarSegundi(){
        assertThrows(ErroException.class, () -> relogioService.acertarRelogio(10, 10,null));
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
        assertThrows(ErroException.class, relogio::lerHora);
    }

    @Test
    @DisplayName("Deveria validar o minuto quando não encontrar")
    void deveNaoEncontrarMinuto(){
        Relogio relogio = new Relogio();
        assertThrows(ErroException.class, relogio::lerMinuto);
    }

    @Test
    @DisplayName("Deveria validar o segundo quando não encontrar")
    void deveNaoEncontrarSegundo(){
        Relogio relogio = new Relogio();
        assertThrows(ErroException.class, relogio::lerSegundo);
    }
}
