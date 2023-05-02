package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuadradoTest {

    @Test
    @DisplayName("Deve validar o lado quando não informar ela")
    void deveValidarLado(){
        Quadrado quadrado = new Quadrado(UUID.randomUUID(), null);
        assertThrows(RegraDeNegocioException.class, quadrado::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente")
    void deveCalcularArea(){
        Quadrado quadrado = new Quadrado(UUID.randomUUID(), 6);

        Double resultado = quadrado.calcularArea();

        assertEquals(36, resultado);
    }

}
