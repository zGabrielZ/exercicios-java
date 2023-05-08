package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Ponto2DTest {

    @Test
    @DisplayName("Deveria criar ponto 2d quando for instanciar")
    void deveCriarPonto2D(){
        Ponto2D ponto2D = new Ponto2D(UUID.randomUUID(), 2.5, 5.4);

        String resultado = ponto2D.toString();

        String resultadoEsperado = "ID : " + ponto2D.getId() + ", Coordenada X : " + ponto2D.getCoordX() + ", Coordenada Y : " + ponto2D.getCoordY();
        assertEquals(resultadoEsperado, resultado);
    }

}
