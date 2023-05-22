package br.com.gabrielferreira.model;

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

    @Test
    @DisplayName("Deve comparar motocicleta quando não forem iguais")
    void deveCompararMotocicletaNaoIguais(){
        Veiculo veiculo1 = new Motocicleta();
        veiculo1.setId(UUID.randomUUID());
        Veiculo veiculo2 = new Motocicleta();
        veiculo2.setId(UUID.randomUUID());

        assertNotEquals(veiculo1, veiculo2);
        assertNotEquals(veiculo1.hashCode(), veiculo2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar motocicleta quando forem iguais")
    void deveCompararMotocicletaIguais(){
        UUID id = UUID.randomUUID();
        Veiculo veiculo1 = new Motocicleta();
        veiculo1.setId(id);
        Veiculo veiculo2 = new Motocicleta();
        veiculo2.setId(id);

        assertEquals(veiculo1, veiculo2);
        assertEquals(veiculo1.hashCode(), veiculo2.hashCode());
    }
}
