package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class TrapezioTest {

    @Test
    @DisplayName("Deve validar a base maior quando não informar ela")
    void deveValidarBaseMaior(){
        Figura trapezio = new Trapezio(UUID.randomUUID(), null, 2, 2);
        assertThrows(RegraDeNegocioException.class, trapezio::calcularArea);
    }

    @Test
    @DisplayName("Deve validar base menor quando não informar ela")
    void deveValidarBaseMenor(){
        Figura trapezio = new Trapezio(UUID.randomUUID(), 2, null, 2);
        assertThrows(RegraDeNegocioException.class, trapezio::calcularArea);
    }

    @Test
    @DisplayName("Deve validar altura quando não informar ela")
    void deveValidarAltura(){
        Figura trapezio = new Trapezio(UUID.randomUUID(), 2, 2, null);
        assertThrows(RegraDeNegocioException.class, trapezio::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente")
    void deveCalcularArea(){
        Figura trapezio = new Trapezio(UUID.randomUUID(), 2, 2, 5);

        BigDecimal resultado = trapezio.calcularArea();

        assertEquals(toBigDecimal(10), resultado);
    }

}
