package br.com.gabrielferreira.figura.model;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.commons.utils.CalculoUtils.toRetorno;
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

        assertEquals(toRetorno(toBigDecimal(25.00), 2, RoundingMode.HALF_EVEN), resultado);
    }

}
