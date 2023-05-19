package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class PonteiroTest {

    @Test
    @DisplayName("Deve criar ponteiro")
    void deveCriarPonteiro(){
        Ponteiro ponteiro = new Ponteiro();
        ponteiro.setId(UUID.randomUUID());
        ponteiro.setPosicao(1);

        assertEquals(1, ponteiro.getPosicao());
        assertNotNull(ponteiro.getId());
        assertNotNull(ponteiro.toString());
    }
}
