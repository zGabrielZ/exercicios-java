package br.com.gabrielferreira.veiculo.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MotocicletaTest {

    @Test
    @DisplayName("Deve ligar motocicleta quando chamar o método ligado")
    void deveLigarMotocicleta(){
        Veiculo veiculo = new Motocicleta();
        veiculo.setId(UUID.randomUUID());

        String retorno = veiculo.ligado();

        assertEquals("Motocicleta ligada", retorno);
        assertTrue(veiculo.isLigado());
    }

    @Test
    @DisplayName("Deve desligar motocicleta quando chamar o método desligado")
    void deveDesligarMotocicleta(){
        Veiculo veiculo = new Motocicleta();
        veiculo.setId(UUID.randomUUID());

        String retorno = veiculo.desligado();

        assertEquals("Motocicleta desligada", retorno);
        assertFalse(veiculo.isLigado());
    }
}
