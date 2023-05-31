package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class QuadradoTest {

    @Test
    @DisplayName("Deve validar o cálculo da área quando não informar o lado")
    void deveValidarCalcularArea(){
        Quadrado quadrado = Quadrado.builder()
                .id(UUID.randomUUID())
                .lado(null)
                .build();
        assertThrows(RegraDeNegocioException.class, quadrado::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular a área quando informar o lado")
    void deveCalcularArea(){
        Quadrado quadrado = Quadrado.builder()
                .id(UUID.randomUUID())
                .lado(3)
                .build();

        BigDecimal resultado = quadrado.calcularArea();

        assertEquals(toRetorno(toBigDecimal(9.00), 2, RoundingMode.HALF_EVEN), resultado);
    }
}
