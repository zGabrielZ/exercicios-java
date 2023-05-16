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
    @DisplayName("Deve validar o raio quando não informar ela")
    void deveValidarRaio(){
        Circunferencia circunferencia = new Circunferencia(UUID.randomUUID(), null);
        assertThrows(RegraDeNegocioException.class, circunferencia::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente")
    void deveCalcularArea(){
        Circunferencia circunferencia = new Circunferencia(UUID.randomUUID(), 3);

        BigDecimal resultado = circunferencia.calcularArea();

        assertEquals(BigDecimal.valueOf(28.27), resultado.setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente com getters e setters")
    void deveCalcularAreaComGettersSetters(){
        Circunferencia circunferencia = new Circunferencia();
        circunferencia.setId(UUID.randomUUID());
        circunferencia.setRaio(3);

        BigDecimal resultado = circunferencia.calcularArea();

        assertEquals(BigDecimal.valueOf(28.27), resultado.setScale(2, RoundingMode.HALF_EVEN));
        assertEquals(3, circunferencia.getRaio());
        assertNotNull(circunferencia.getId());
        assertNotNull(circunferencia.toString());
    }

}
