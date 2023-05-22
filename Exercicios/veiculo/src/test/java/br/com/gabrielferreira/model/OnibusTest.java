package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OnibusTest {

    @Test
    @DisplayName("Deve ligar ônibus quando chamar o método ligado")
    void deveLigarOnibus(){
        Veiculo veiculo = new Onibus();
        veiculo.setId(UUID.randomUUID());

        String retorno = veiculo.ligado();

        assertEquals("Ônibus ligado", retorno);
        assertTrue(veiculo.isLigado());
    }

    @Test
    @DisplayName("Deve desligar ônibus quando chamar o método desligado")
    void deveDesligarOnibus(){
        Veiculo veiculo = new Onibus();
        veiculo.setId(UUID.randomUUID());

        String retorno = veiculo.desligado();

        assertEquals("Ônibus desligado", retorno);
        assertFalse(veiculo.isLigado());
    }

    @Test
    @DisplayName("Deve comparar ônibus quando não forem iguais")
    void deveCompararOnibusNaoIguais(){
        Veiculo veiculo1 = new Onibus();
        veiculo1.setId(UUID.randomUUID());
        Veiculo veiculo2 = new Onibus();
        veiculo2.setId(UUID.randomUUID());

        assertNotEquals(veiculo1, veiculo2);
        assertNotEquals(veiculo1.hashCode(), veiculo2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar ônibus quando forem iguais")
    void deveCompararOnibusIguais(){
        UUID id = UUID.randomUUID();
        Veiculo veiculo1 = new Onibus();
        veiculo1.setId(id);
        Veiculo veiculo2 = new Onibus();
        veiculo2.setId(id);

        assertEquals(veiculo1, veiculo2);
        assertEquals(veiculo1.hashCode(), veiculo2.hashCode());
    }
}
