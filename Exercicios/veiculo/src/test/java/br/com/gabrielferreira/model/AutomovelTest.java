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

    @Test
    @DisplayName("Deve comparar automóvel quando não forem iguais")
    void deveCompararAutomovelNaoIguais(){
        Veiculo veiculo1 = new Automovel();
        veiculo1.setId(UUID.randomUUID());
        Veiculo veiculo2 = new Automovel();
        veiculo2.setId(UUID.randomUUID());

        assertNotEquals(veiculo1, veiculo2);
        assertNotEquals(veiculo1.hashCode(), veiculo2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar automóvel quando forem iguais")
    void deveCompararAutomovelIguais(){
        UUID id = UUID.randomUUID();
        Veiculo veiculo1 = new Automovel();
        veiculo1.setId(id);
        Veiculo veiculo2 = new Automovel();
        veiculo2.setId(id);

        assertEquals(veiculo1, veiculo2);
        assertEquals(veiculo1.hashCode(), veiculo2.hashCode());
    }
}
