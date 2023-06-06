package br.com.gabrielferreira.service;

import br.com.gabrielferreira.model.AreaCalculavel;
import br.com.gabrielferreira.model.Quadrado;
import br.com.gabrielferreira.model.Retangulo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class CalculadorServiceTest {

    @Test
    @DisplayName("Deve calcular a soma total de áreas quando indormar corretamente")
    void deveCalcularSomaTotalArea(){
        CalculadorService calculadorService = new CalculadorService();

        AreaCalculavel quadrado1 = new Quadrado(UUID.randomUUID(), 3);
        AreaCalculavel retangulo2 = new Retangulo(UUID.randomUUID(), 5, 3);

        BigDecimal resultado = calculadorService.somarCalculoAreas(Arrays.asList(quadrado1, retangulo2));

        assertEquals(toRetorno(toBigDecimal(24), 2, RoundingMode.HALF_EVEN), resultado);
    }
}
