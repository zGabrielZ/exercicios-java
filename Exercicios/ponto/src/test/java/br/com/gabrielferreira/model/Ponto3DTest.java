package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class Ponto3DTest {

    @Test
    @DisplayName("Deveria criar ponto 3d quando for instanciar")
    void deveCriarPonto2D(){
        Ponto3D ponto3D = new Ponto3D(UUID.randomUUID(), BigDecimal.valueOf(2.5), BigDecimal.valueOf(5.4), BigDecimal.valueOf(6.0));

        String resultado = ponto3D.toString();

        String resultadoEsperado = "Id : " + ponto3D.getId() + ", coordX : " + ponto3D.getCoordX() + ", coordY : " + ponto3D.getCoordY() + ", coordZ : " + ponto3D.getCoordZ();
        assertEquals(resultadoEsperado, resultado);
    }

}
