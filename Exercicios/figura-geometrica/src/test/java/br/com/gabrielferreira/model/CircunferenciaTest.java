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
    @DisplayName("Deve validar o raio quando não informar ela")
    void deveValidarRaio(){
        Figura circunferencia = new Circunferencia(UUID.randomUUID(), null);
        assertThrows(RegraDeNegocioException.class, circunferencia::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente")
    void deveCalcularArea(){
        Figura circunferencia = new Circunferencia(UUID.randomUUID(), 3);

        BigDecimal resultado = circunferencia.calcularArea();

        assertEquals(toBigDecimal(28.27), resultado);
    }

}
