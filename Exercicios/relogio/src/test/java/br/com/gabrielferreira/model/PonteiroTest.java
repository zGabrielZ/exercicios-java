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

    @Test
    @DisplayName("Deve comparar ponteiro quando não forem iguais")
    void deveCompararPonteiroNaoIguais(){
        Ponteiro ponteiro1 = new Ponteiro(UUID.randomUUID(), 1);
        Ponteiro ponteiro2 = new Ponteiro(UUID.randomUUID(), 2);

        assertNotEquals(ponteiro1, ponteiro2);
        assertNotEquals(ponteiro1.hashCode(), ponteiro2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar ponteiro quando forem iguais")
    void deveCompararPonteiroIguais(){
        UUID id = UUID.randomUUID();
        Integer posicao = 1;
        Ponteiro ponteiro1 = new Ponteiro(id, posicao);
        Ponteiro ponteiro2 = new Ponteiro(id, posicao);

        assertEquals(ponteiro1, ponteiro2);
        assertEquals(ponteiro1.hashCode(), ponteiro2.hashCode());
    }
}
