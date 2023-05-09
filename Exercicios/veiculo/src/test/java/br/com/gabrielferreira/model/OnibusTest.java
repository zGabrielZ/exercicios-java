package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnibusTest {

    @Test
    @DisplayName("Deve ligar ônibus quando chamar o método ligado")
    void deveLigarOnibus(){
        Veiculo veiculo = new Onibus();

        String retorno = veiculo.ligado();

        assertEquals("Ônibus ligado", retorno);
        assertTrue(veiculo.isLigado());
    }

    @Test
    @DisplayName("Deve desligar ônibus quando chamar o método desligado")
    void deveDesligarOnibus(){
        Veiculo veiculo = new Onibus();

        String retorno = veiculo.desligado();

        assertEquals("Ônibus desligado", retorno);
        assertFalse(veiculo.isLigado());
    }
}
