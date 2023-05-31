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
    @DisplayName("Deve validar o lado quando não informar ela")
    void deveValidarLado(){
        Figura quadrado = new Quadrado(UUID.randomUUID(), null);
        assertThrows(RegraDeNegocioException.class, quadrado::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente")
    void deveCalcularArea(){
        Figura quadrado = new Quadrado(UUID.randomUUID(), 6);

        BigDecimal resultado = quadrado.calcularArea();

        assertEquals(toRetorno(toBigDecimal(36.00), 2, RoundingMode.HALF_EVEN), resultado);
    }

}
