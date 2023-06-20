package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.toBigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrianguloTest {

    @Test
    @DisplayName("Deve validar a base quando não informar ela")
    void deveValidarBase(){
        Figura triangulo = new Triangulo(UUID.randomUUID(), null, 10);
        assertThrows(RegraDeNegocioException.class, triangulo::calcularArea);
    }

    @Test
    @DisplayName("Deve validar altura quando não informar ela")
    void deveValidarAltura(){
        Figura triangulo = new Triangulo(UUID.randomUUID(), 10, null);
        assertThrows(RegraDeNegocioException.class, triangulo::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente")
    void deveCalcularArea(){
        Figura triangulo = new Triangulo(UUID.randomUUID(), 10, 5);

        BigDecimal resultado = triangulo.calcularArea();

        assertEquals(toBigDecimal(25), resultado);
    }

}
