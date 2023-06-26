package br.com.gabrielferreira.utils;
import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalcularRaioUtils.*;

class CalcularRaioUtilsTest {

    @Test
    @DisplayName("Deve validar o cálculo de circunferência quando não informar o raio")
    void deveValidarCalculoCircunferencia(){
        Double raio = null;
        assertThrows(RegraDeNegocioException.class, () -> calcularCircunferencia(raio));
    }

    @Test
    @DisplayName("Deve realizar o cálculo de circunferência quando informar o raio")
    void deveCalcularCircunferencia(){
        Double calculo = calcularCircunferencia(2.0);

        assertEquals(12.56, calculo, 0.1);
    }

    @Test
    @DisplayName("Deve realizar o cálculo do volume quando informar o raio")
    void deveCalcularVolume(){
        Double calculo = calcularVolume(2.0);

        assertEquals(33.51, calculo, 0.1);
    }
}
