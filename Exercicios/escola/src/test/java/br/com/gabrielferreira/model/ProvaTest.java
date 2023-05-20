package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProvaTest {

    @Test
    @DisplayName("Deve criar prova")
    void deveCriarProva(){
        Prova prova = new Prova(UUID.randomUUID(), "Teste", BigDecimal.ZERO, null);
        assertNotNull(prova.getId());
        assertNotNull(prova.toString());
    }

    @Test
    @DisplayName("Deve comparar prova quando não forem iguais")
    void deveCompararProvaNaoIguais(){
        Prova prova1 = new Prova(UUID.randomUUID(), "Teste 1", BigDecimal.ZERO, null);
        Prova prova2 = new Prova(UUID.randomUUID(), "Teste 2", BigDecimal.TEN, null);

        assertNotEquals(prova1, prova2);
        assertNotEquals(prova1.hashCode(), prova2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar prova quando forem iguais")
    void deveCompararProvaIguais(){
        UUID id = UUID.randomUUID();
        String nome = "Teste 1";
        BigDecimal valor = BigDecimal.ZERO;
        Peso peso = new Peso();
        Prova prova1 = new Prova(id, nome, valor, peso);
        Prova prova2 = new Prova(id, nome, valor, peso);

        assertEquals(prova1, prova2);
        assertEquals(prova1.hashCode(), prova2.hashCode());
    }
}
