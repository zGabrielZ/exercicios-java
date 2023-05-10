package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircunferenciaTest {

    @Test
    @DisplayName("Deve validar o cálculo da área quando não informar o raio")
    void deveValidarCalcularArea(){
        Circunferencia circunferencia = new Circunferencia(UUID.randomUUID(), null);
        assertThrows(RegraDeNegocioException.class, circunferencia::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular a área quando informar o raio")
    void deveCalcularArea(){
        Circunferencia circunferencia = new Circunferencia(UUID.randomUUID(), 5);

        Double resultado = circunferencia.calcularArea();

        assertEquals(78.5, resultado, 0.1);
    }
}
