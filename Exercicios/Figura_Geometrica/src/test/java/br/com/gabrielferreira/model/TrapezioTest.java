package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrapezioTest {

    @Test
    @DisplayName("Deve validar a base maior quando não informar ela")
    void deveValidarBaseMaior(){
        Trapezio trapezio = new Trapezio(UUID.randomUUID(), null, 2, 2);
        assertThrows(RegraDeNegocioException.class, trapezio::calcularArea);
    }

    @Test
    @DisplayName("Deve validar base menor quando não informar ela")
    void deveValidarBaseMenor(){
        Trapezio trapezio = new Trapezio(UUID.randomUUID(), 2, null, 2);
        assertThrows(RegraDeNegocioException.class, trapezio::calcularArea);
    }

    @Test
    @DisplayName("Deve validar altura quando não informar ela")
    void deveValidarAltura(){
        Trapezio trapezio = new Trapezio(UUID.randomUUID(), 2, 2, null);
        assertThrows(RegraDeNegocioException.class, trapezio::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente")
    void deveCalcularArea(){
        Trapezio trapezio = new Trapezio(UUID.randomUUID(), 2, 2, 5);

        Double resultado = trapezio.calcularArea();

        assertEquals(10, resultado);
    }

}
