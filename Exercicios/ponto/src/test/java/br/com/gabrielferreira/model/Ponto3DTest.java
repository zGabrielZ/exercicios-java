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

    @Test
    @DisplayName("Deve comparar Ponto3D quando não forem iguais")
    void deveCompararPonto3DNaoIguais(){
        Ponto3D ponto1 = new Ponto3D(UUID.randomUUID(), BigDecimal.valueOf(2.5), BigDecimal.valueOf(5.4), BigDecimal.valueOf(10.0));
        Ponto3D ponto2 = new Ponto3D(UUID.randomUUID(), BigDecimal.valueOf(2.6), BigDecimal.valueOf(5.7), BigDecimal.valueOf(30.0));

        assertNotEquals(ponto1, ponto2);
        assertNotEquals(ponto1.hashCode(), ponto2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar Ponto3D quando forem iguais")
    void deveCompararPonto3DIguais(){
        UUID id = UUID.randomUUID();
        BigDecimal x = BigDecimal.ONE;
        BigDecimal y = BigDecimal.TEN;
        BigDecimal z = BigDecimal.ZERO;
        Ponto3D ponto1 = new Ponto3D(id, x, y, z);
        Ponto3D ponto2 = new Ponto3D(id, x, y, z);

        assertEquals(ponto1, ponto2);
        assertEquals(ponto1.hashCode(), ponto2.hashCode());
    }

}
