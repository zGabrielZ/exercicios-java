package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AutomovelTest {

    @Test
    @DisplayName("Deve criar automóvel")
    void deveCriarAutomovel(){
        Veiculo veiculo = new Automovel();
        veiculo.setId(UUID.randomUUID());

        assertNotNull(veiculo.getId());
        assertNotNull(veiculo.toString());
    }

    @Test
    @DisplayName("Deve ligar automóvel quando chamar o método ligado")
    void deveLigarAutomovel(){
        Veiculo veiculo = new Automovel();
        veiculo.setId(UUID.randomUUID());

        String retorno = veiculo.ligado();

        assertEquals("Automóvel ligado", retorno);
        assertTrue(veiculo.isLigado());
    }

    @Test
    @DisplayName("Deve desligar automóvel quando chamar o método desligado")
    void deveDesligarAutomovel(){
        Veiculo veiculo = new Automovel();
        veiculo.setId(UUID.randomUUID());

        String retorno = veiculo.desligado();

        assertEquals("Autómovel desligado", retorno);
        assertFalse(veiculo.isLigado());
    }
}
