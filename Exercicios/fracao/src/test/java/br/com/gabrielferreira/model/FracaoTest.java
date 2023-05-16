package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class FracaoTest {

    @Test
    @DisplayName("Deve criar fração")
    void deveCriarFracao(){
        Fracao fracao = new Fracao();
        fracao.setId(UUID.randomUUID());
        fracao.setNumerador(10);
        fracao.setDenominador(20);

        assertEquals(10, fracao.getNumerador());
        assertEquals(20, fracao.getDenominador());
        assertNotNull(fracao.getId());
        assertNotNull(fracao.toString());
    }
}
