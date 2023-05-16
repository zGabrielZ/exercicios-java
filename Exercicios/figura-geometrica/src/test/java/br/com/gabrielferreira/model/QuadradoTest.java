package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class QuadradoTest {

    @Test
    @DisplayName("Deve validar o lado quando não informar ela")
    void deveValidarLado(){
        Quadrado quadrado = new Quadrado(UUID.randomUUID(), null);
        assertThrows(RegraDeNegocioException.class, quadrado::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente")
    void deveCalcularArea(){
        Quadrado quadrado = new Quadrado(UUID.randomUUID(), 6);

        BigDecimal resultado = quadrado.calcularArea();

        assertEquals(BigDecimal.valueOf(36.0), resultado);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente com getters e setters")
    void deveCalcularAreaComGettersSetters(){
        Quadrado quadrado = new Quadrado();
        quadrado.setId(UUID.randomUUID());
        quadrado.setLado(6);

        BigDecimal resultado = quadrado.calcularArea();

        assertEquals(BigDecimal.valueOf(36.0), resultado);
        assertEquals(6, quadrado.getLado());
        assertNotNull(quadrado.getId());
        assertNotNull(quadrado.toString());
    }

}
