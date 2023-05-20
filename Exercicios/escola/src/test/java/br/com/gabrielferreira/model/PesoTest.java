package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PesoTest {

    @Test
    @DisplayName("Deve criar peso")
    void deveCriarPeso(){
        Peso peso = new Peso(UUID.randomUUID(), 10);
        assertNotNull(peso.getId());
        assertNotNull(peso.toString());
    }

    @Test
    @DisplayName("Deve comparar peso quando não forem iguais")
    void deveCompararPesoNaoIguais(){
        Peso peso1 = new Peso(UUID.randomUUID(), 10);
        Peso peso2 = new Peso(UUID.randomUUID(), 8);

        assertNotEquals(peso1, peso2);
        assertNotEquals(peso1.hashCode(), peso2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar peso quando forem iguais")
    void deveCompararPesoIguais(){
        UUID id = UUID.randomUUID();
        Integer peso = 10;
        Peso peso1 = new Peso(id, peso);
        Peso peso2 = new Peso(id, peso);

        assertEquals(peso1, peso2);
        assertEquals(peso1.hashCode(), peso2.hashCode());
    }
}
