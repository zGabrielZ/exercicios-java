package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PesoTest {

    @Test
    @DisplayName("Deve criar peso")
    void deveCriarPeso(){
        Peso peso = new Peso(UUID.randomUUID(), 10);
        assertNotNull(peso.getId());
        assertNotNull(peso.toString());
    }
}
