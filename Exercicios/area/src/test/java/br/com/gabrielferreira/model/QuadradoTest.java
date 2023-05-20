package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class QuadradoTest {

    @Test
    @DisplayName("Deve validar o cálculo da área quando não informar o lado")
    void deveValidarCalcularArea(){
        Quadrado quadrado = new Quadrado(UUID.randomUUID(), null);
        assertThrows(RegraDeNegocioException.class, quadrado::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular a área quando informar o lado")
    void deveCalcularArea(){
        Quadrado quadrado = new Quadrado(UUID.randomUUID(), 3);

        BigDecimal resultado = quadrado.calcularArea();

        assertEquals(BigDecimal.valueOf(9), resultado);
    }

    @Test
    @DisplayName("Deve calcular a área quando informar o lado com getters e setters")
    void deveCalcularAreaComGettersSetters(){
        Quadrado quadrado = new Quadrado();
        quadrado.setId(UUID.randomUUID());
        quadrado.setLado(3);

        BigDecimal resultado = quadrado.calcularArea();

        assertEquals(BigDecimal.valueOf(9), resultado);
        assertEquals(3, quadrado.getLado());
        assertNotNull(quadrado.getId());
        assertNotNull(quadrado.toString());
    }

    @Test
    @DisplayName("Deve comparar quadrado quando não forem iguais")
    void deveCompararQuadradoNaoIguais(){
        Quadrado quadrado1 = new Quadrado(UUID.randomUUID(), 3);
        Quadrado quadrado2 = new Quadrado(UUID.randomUUID(), 4);

        assertNotEquals(quadrado1, quadrado2);
        assertNotEquals(quadrado1.hashCode(), quadrado2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar quadrado quando forem iguais")
    void deveCompararQuadradoIguais(){
        UUID uuid = UUID.randomUUID();
        Integer lado = 5;
        Quadrado quadrado1 = new Quadrado(uuid, lado);
        Quadrado quadrado2 = new Quadrado(uuid, lado);

        assertEquals(quadrado1, quadrado2);
        assertEquals(quadrado1.hashCode(), quadrado2.hashCode());
    }
}
