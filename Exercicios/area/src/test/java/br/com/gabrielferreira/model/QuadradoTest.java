package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuadradoTest {

    @Test
    @DisplayName("Deve validar o cálculo da área quando não informar o lado")
    void deveValidarCalcularArea(){
        Quadrado quadrado = new Quadrado(UUID.randomUUID(), null);
        assertThrows(RegraDeNegocioException.class, quadrado::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular a área quando informar o lado")
    void deveCalcularArea(){
        Quadrado quadrado = new Quadrado(UUID.randomUUID(), 3);

        Double resultado = quadrado.calcularArea();

        assertEquals(9, resultado);
    }
}
