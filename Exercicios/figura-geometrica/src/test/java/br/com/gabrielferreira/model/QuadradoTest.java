package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

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

        assertEquals(toRetorno(toBigDecimal(36.00), 2, RoundingMode.HALF_EVEN), resultado);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente com getters e setters")
    void deveCalcularAreaComGettersSetters(){
        Quadrado quadrado = new Quadrado();
        quadrado.setId(UUID.randomUUID());
        quadrado.setLado(6);

        BigDecimal resultado = quadrado.calcularArea();

        assertEquals(toRetorno(toBigDecimal(36.00), 2, RoundingMode.HALF_EVEN), resultado);
        assertEquals(6, quadrado.getLado());
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
        UUID id = UUID.randomUUID();
        Integer lado = 3;
        Quadrado quadrado1 = new Quadrado(id, lado);
        Quadrado quadrado2 = new Quadrado(id, lado);

        assertEquals(quadrado1, quadrado2);
        assertEquals(quadrado1.hashCode(), quadrado2.hashCode());
    }

}
