package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

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

        BigDecimal resultado = circunferencia.calcularArea();

        assertEquals(BigDecimal.valueOf(78.54), resultado.setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    @DisplayName("Deve calcular a área quando informar o raio com getters e setters")
    void deveCalcularAreaComGettersSetters(){
        Circunferencia circunferencia = new Circunferencia();
        circunferencia.setId(UUID.randomUUID());
        circunferencia.setRaio(5);

        BigDecimal resultado = circunferencia.calcularArea();

        assertEquals(BigDecimal.valueOf(78.54), resultado.setScale(2, RoundingMode.HALF_EVEN));
        assertEquals(5, circunferencia.getRaio());
        assertNotNull(circunferencia.getId());
        assertNotNull(circunferencia.toString());
    }
}
