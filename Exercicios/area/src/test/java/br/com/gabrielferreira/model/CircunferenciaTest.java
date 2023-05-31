package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class CircunferenciaTest {

    @Test
    @DisplayName("Deve validar o cálculo da área quando não informar o raio")
    void deveValidarCalcularArea(){
        Circunferencia circunferencia = Circunferencia.builder()
                .id(UUID.randomUUID())
                .raio(null)
                .build();
        assertThrows(RegraDeNegocioException.class, circunferencia::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular a área quando informar o raio")
    void deveCalcularArea(){
        Circunferencia circunferencia = Circunferencia.builder()
                .id(UUID.randomUUID())
                .raio(5)
                .build();

        BigDecimal resultado = circunferencia.calcularArea();

        assertEquals(toBigDecimal(78.54), resultado);
    }
}
