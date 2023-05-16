package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TrianguloTest {

    @Test
    @DisplayName("Deve validar a base quando não informar ela")
    void deveValidarBase(){
        Triangulo triangulo = new Triangulo(UUID.randomUUID(), null, 10);
        assertThrows(RegraDeNegocioException.class, triangulo::calcularArea);
    }

    @Test
    @DisplayName("Deve validar altura quando não informar ela")
    void deveValidarAltura(){
        Triangulo triangulo = new Triangulo(UUID.randomUUID(), 10, null);
        assertThrows(RegraDeNegocioException.class, triangulo::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente")
    void deveCalcularArea(){
        Triangulo triangulo = new Triangulo(UUID.randomUUID(), 10, 5);

        BigDecimal resultado = triangulo.calcularArea();

        assertEquals(BigDecimal.valueOf(25), resultado);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente com getters e setters")
    void deveCalcularAreaComGettersSetters(){
        Triangulo triangulo = new Triangulo();
        triangulo.setId(UUID.randomUUID());
        triangulo.setBase(10);
        triangulo.setAltura(5);

        BigDecimal resultado = triangulo.calcularArea();

        assertEquals(BigDecimal.valueOf(25), resultado);
        assertNotNull(triangulo.getId());
        assertEquals(10, triangulo.getBase());
        assertEquals(5, triangulo.getAltura());
        assertNotNull(triangulo.toString());
    }

}
