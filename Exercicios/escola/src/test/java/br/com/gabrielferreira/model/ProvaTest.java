package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProvaTest {

    @Test
    @DisplayName("Deve criar prova")
    void deveCriarProva(){
        Prova prova = new Prova(UUID.randomUUID(), "Teste", BigDecimal.ZERO, null);
        assertNotNull(prova.getId());
        assertNotNull(prova.toString());
    }
}
