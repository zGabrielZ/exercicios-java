package br.com.gabrielferreira.ponto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ponto2DTest {

    @Test
    @DisplayName("Deveria criar ponto 2d quando for instanciar")
    void deveCriarPonto2D(){
        Ponto2D ponto2D = new Ponto2D(UUID.randomUUID(), BigDecimal.valueOf(2.5), BigDecimal.valueOf(5.4));

        String resultado = ponto2D.toString();

        String resultadoEsperado = "Id : " + ponto2D.getId() + ", coordX : " + ponto2D.getCoordX() + ", coordY : " + ponto2D.getCoordY();
        assertEquals(resultadoEsperado, resultado);
    }

}
