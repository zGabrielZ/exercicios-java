package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrianguloTest {

    @Test
    @DisplayName("Deve validar a base quando não informar ela")
    void deveValidarBase(){
        Triangulo triangulo = new Triangulo(UUID.randomUUID(), null, 10);
        assertThrows(RegraDeNegocioException.class, triangulo::calcularArea);
    }

    @Test
    @DisplayName("Deve validar altura quando não informar ela")
    void deveValidarAltura(){
        Triangulo triangulo = new Triangulo(UUID.randomUUID(), 10, null);
        assertThrows(RegraDeNegocioException.class, triangulo::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente")
    void deveCalcularArea(){
        Triangulo triangulo = new Triangulo(UUID.randomUUID(), 10, 5);

        Double resultado = triangulo.calcularArea();

        assertEquals(25, resultado);
    }

}
