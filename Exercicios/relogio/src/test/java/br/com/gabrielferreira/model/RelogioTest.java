package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RelogioTest {

    @Test
    @DisplayName("Deve criar relógio")
    void deveCriarPonteiro(){
        Relogio relogio = new Relogio();
        relogio.setId(UUID.randomUUID());
        relogio.setPonteiroHora(new Ponteiro(UUID.randomUUID(), 1));
        relogio.setPonteiroMinuto(new Ponteiro(UUID.randomUUID(), 2));
        relogio.setPonteiroSegundo(new Ponteiro(UUID.randomUUID(), 3));

        assertNotNull(relogio.getId());
        assertNotNull(relogio.toString());
        assertNotNull(relogio.getPonteiroHora());
        assertNotNull(relogio.getPonteiroMinuto());
        assertNotNull(relogio.getPonteiroSegundo());
    }
}
