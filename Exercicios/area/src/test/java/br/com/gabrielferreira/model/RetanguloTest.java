package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RetanguloTest {

    @Test
    @DisplayName("Deve validar o cálculo da área quando não informar a base")
    void deveValidarCalcularAreaQuandoNaoInformarBase(){
        Retangulo retangulo = new Retangulo(UUID.randomUUID(), null, 5);
        assertThrows(RegraDeNegocioException.class, retangulo::calcularArea);
    }

    @Test
    @DisplayName("Deve validar o cálculo da área quando não informar a altura")
    void deveValidarCalcularAreaQuandoNaoInformarAltura(){
        Retangulo retangulo = new Retangulo(UUID.randomUUID(), 5, null);
        assertThrows(RegraDeNegocioException.class, retangulo::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular a área quando informar a base e altura")
    void deveCalcularArea(){
        Retangulo retangulo = new Retangulo(UUID.randomUUID(), 5, 7);

        Double resultado = retangulo.calcularArea();

        assertEquals(35, resultado);
    }
}
