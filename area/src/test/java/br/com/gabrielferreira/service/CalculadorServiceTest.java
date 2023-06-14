package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.AreaCalculavel;
import br.com.gabrielferreira.model.Quadrado;
import br.com.gabrielferreira.model.Retangulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.utils.CalculoUtils.toRetorno;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadorServiceTest {

    private CalculadorService calculadorService;

    @BeforeEach
    public void criarInstancias(){
        calculadorService = new CalculadorService();
    }

    @Test
    @DisplayName("Deve calcular a soma total de áreas quando indormar corretamente")
    void deveCalcularSomaTotalArea(){
        AreaCalculavel quadrado1 = new Quadrado(UUID.randomUUID(), 3);
        AreaCalculavel retangulo2 = new Retangulo(UUID.randomUUID(), 5, 3);

        BigDecimal resultado = calculadorService.somarCalculoAreas(Arrays.asList(quadrado1, retangulo2));

        assertEquals(toRetorno(toBigDecimal(24), 2, RoundingMode.HALF_EVEN), resultado);
    }

    @Test
    @DisplayName("Deve validar cálculo de áreas quando não informar nada")
    void deveValidarCalculoAreas(){
        List<AreaCalculavel> areas = new ArrayList<>();
        assertThrows(RegraDeNegocioException.class, () -> calculadorService.somarCalculoAreas(areas));
    }

    @Test
    @DisplayName("Deve validar cálculo de áreas quando informar nulo")
    void deveValidarCalculoAreasNulo(){
        List<AreaCalculavel> areas = new ArrayList<>();
        AreaCalculavel areaCalculavel = null;
        areas.add(areaCalculavel);
        assertThrows(RegraDeNegocioException.class, () -> calculadorService.somarCalculoAreas(areas));
    }
}
