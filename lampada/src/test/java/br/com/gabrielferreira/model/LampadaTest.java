package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LampadaTest {

    @Test
    @DisplayName("Deveria ligar a lâmpada quando chamar o método ligar")
    void deveLigarLampada(){
        Lampada lampada = Lampada.builder()
                .id(UUID.randomUUID())
                .ligada(false)
                .build();

        lampada.ligar();

        assertTrue(lampada.isLigada());
    }

    @Test
    @DisplayName("Deveria desligar a lâmpada quando chamar o método desligar")
    void deveDesligarLampada(){
        Lampada lampada = Lampada.builder()
                .id(UUID.randomUUID())
                .ligada(false)
                .build();

        lampada.ligar();

        lampada.desligar();

        assertFalse(lampada.isLigada());
    }

    @Test
    @DisplayName("Deveria imprimir a situação da lâmpada ligada quando chamar o método imprimir")
    void deveImprimirEstadoLampadaSituacaoLigada(){
        Lampada lampada = Lampada.builder()
                .id(UUID.randomUUID())
                .ligada(false)
                .build();

        lampada.ligar();
        String situacao = lampada.imprimir();

        assertEquals("Lâmpada ligada", situacao);
    }

    @Test
    @DisplayName("Deveria imprimir a situação da lâmpada desligada quando chamar o método imprimir")
    void deveImprimirEstadoLampadaDesligada(){
        Lampada lampada = Lampada.builder()
                .id(UUID.randomUUID())
                .ligada(false)
                .build();

        lampada.desligar();
        String situacao = lampada.imprimir();

        assertEquals("Lâmpada desligada", situacao);
    }
}
