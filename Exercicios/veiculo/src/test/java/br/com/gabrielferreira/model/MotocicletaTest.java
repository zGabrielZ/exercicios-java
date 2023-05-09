package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotocicletaTest {

    @Test
    @DisplayName("Deve ligar motocicleta quando chamar o método ligado")
    void deveLigarMotocicleta(){
        Veiculo veiculo = new Motocicleta();

        String retorno = veiculo.ligado();

        assertEquals("Motocicleta ligada", retorno);
        assertTrue(veiculo.isLigado());
    }

    @Test
    @DisplayName("Deve desligar motocicleta quando chamar o método desligado")
    void deveDesligarMotocicleta(){
        Veiculo veiculo = new Motocicleta();

        String retorno = veiculo.desligado();

        assertEquals("Motocicleta desligada", retorno);
        assertFalse(veiculo.isLigado());
    }
}
