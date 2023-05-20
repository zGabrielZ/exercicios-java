package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LampadaTest {

    @Test
    @DisplayName("Deveria ligar a lâmpada quando chamar o método ligar")
    void deveLigarLampada(){
        Lampada lampada = new Lampada(UUID.randomUUID(), false);

        lampada.ligar();

        assertTrue(lampada.isLigada());
    }

    @Test
    @DisplayName("Deveria desligar a lâmpada quando chamar o método desligar")
    void deveDesligarLampada(){
        Lampada lampada = new Lampada(UUID.randomUUID(), false);

        lampada.ligar();

        lampada.desligar();

        assertFalse(lampada.isLigada());
    }

    @Test
    @DisplayName("Deveria imprimir a situação da lâmpada ligada quando chamar o método imprimir")
    void deveImprimirEstadoLampadaSituacaoLigada(){
        Lampada lampada = new Lampada(UUID.randomUUID(), false);

        lampada.ligar();
        String situacao = lampada.imprimir();

        assertEquals("Lâmpada ligada", situacao);
    }

    @Test
    @DisplayName("Deveria imprimir a situação da lâmpada desligada quando chamar o método imprimir")
    void deveImprimirEstadoLampadaDesligada(){
        Lampada lampada = new Lampada(UUID.randomUUID(), false);

        lampada.desligar();
        String situacao = lampada.imprimir();

        assertEquals("Lâmpada desligada", situacao);
    }

    @Test
    @DisplayName("Deve criar lâmpada com getters e setters")
    void deveCriarLampadaComGettersSetters(){
        Lampada lampada = new Lampada();
        lampada.setId(UUID.randomUUID());
        lampada.setLigada(true);

        assertTrue(lampada.isLigada());
        assertNotNull(lampada.getId());
        assertNotNull(lampada.toString());
    }

    @Test
    @DisplayName("Deve comparar lâmpada quando não forem iguais")
    void deveCompararLampadaNaoIguais(){
        Lampada lampada1 = new Lampada(UUID.randomUUID(), false);
        Lampada lampada2 = new Lampada(UUID.randomUUID(), true);

        assertNotEquals(lampada1, lampada2);
        assertNotEquals(lampada1.hashCode(), lampada2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar aluno quando forem iguais")
    void deveCompararLampadaIguais(){
        UUID id = UUID.randomUUID();
        boolean ligada = true;
        Lampada lampada1 = new Lampada(id, ligada);
        Lampada lampada2 = new Lampada(id, ligada);

        assertEquals(lampada1, lampada2);
        assertEquals(lampada1.hashCode(), lampada2.hashCode());
    }
}
