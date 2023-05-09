package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutomovelTest {

    @Test
    @DisplayName("Deve ligar automóvel quando chamar o método ligado")
    void deveLigarAutomovel(){
        Veiculo veiculo = new Automovel();

        String retorno = veiculo.ligado();

        assertEquals("Automóvel ligado", retorno);
        assertTrue(veiculo.isLigado());
    }

    @Test
    @DisplayName("Deve desligar automóvel quando chamar o método desligado")
    void deveDesligarAutomovel(){
        Veiculo veiculo = new Automovel();

        String retorno = veiculo.desligado();

        assertEquals("Autómovel desligado", retorno);
        assertFalse(veiculo.isLigado());
    }
}
