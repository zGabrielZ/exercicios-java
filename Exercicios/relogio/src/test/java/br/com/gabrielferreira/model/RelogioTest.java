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

    @Test
    @DisplayName("Deve comparar relógio quando não forem iguais")
    void deveCompararRelogioNaoIguais(){
        Relogio relogio1 = new Relogio(UUID.randomUUID(),
                new Ponteiro(UUID.randomUUID(), 1),
                new Ponteiro(UUID.randomUUID(), 2),
                new Ponteiro(UUID.randomUUID(), 3));
        Relogio relogio2 = new Relogio(UUID.randomUUID(),
                new Ponteiro(UUID.randomUUID(), 5),
                new Ponteiro(UUID.randomUUID(), 6),
                new Ponteiro(UUID.randomUUID(), 7));

        assertNotEquals(relogio1, relogio2);
        assertNotEquals(relogio1.hashCode(), relogio2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar ponteiro quando forem iguais")
    void deveCompararPonteiroIguais(){
        UUID id = UUID.randomUUID();
        Ponteiro ponteiro = new Ponteiro(UUID.randomUUID(), 1);
        Relogio relogio1 = new Relogio(id,
                ponteiro,
                ponteiro,
                ponteiro);
        Relogio relogio2 = new Relogio(id,
                ponteiro,
                ponteiro,
                ponteiro);

        assertEquals(relogio1, relogio2);
        assertEquals(relogio1.hashCode(), relogio2.hashCode());
    }
}
