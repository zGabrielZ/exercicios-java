package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LampadaTest {

    @Test
    @DisplayName("Deveria ligar a lâmpada quando chamar o método ligar")
    void deveLigarLampada(){
        Lampada lampada = new Lampada();

        lampada.ligar();

        assertTrue(lampada.isLigada());
    }

    @Test
    @DisplayName("Deveria desligar a lâmpada quando chamar o método desligar")
    void deveDesligarLampada(){
        Lampada lampada = new Lampada();

        lampada.ligar();

        lampada.desligar();

        assertFalse(lampada.isLigada());
    }

    @Test
    @DisplayName("Deveria imprimir a situação da lâmpada quando chamar o método imprimir")
    void deveImprimirEstadoLampada(){
        Lampada lampada = new Lampada();

        String situacao = lampada.imprimir();

        assertEquals("Lâmpada desligada", situacao);
    }
}
