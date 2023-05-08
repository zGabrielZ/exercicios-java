package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ponto3DTest {

    @Test
    @DisplayName("Deveria criar ponto 3d quando for instanciar")
    void deveCriarPonto2D(){
        Ponto3D ponto3D = new Ponto3D(UUID.randomUUID(), 2.5, 5.4, 6.0);

        String resultado = ponto3D.toString();

        String resultadoEsperado = "ID : " + ponto3D.getId() + ", Coordenada X : " + ponto3D.getCoordX() + ", Coordenada Y : " + ponto3D.getCoordY() + ", Coordenada Z : " + ponto3D.getCoordZ();
        assertEquals(resultadoEsperado, resultado);
    }

}
