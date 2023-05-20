package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class Ponto2DTest {

    @Test
    @DisplayName("Deveria criar ponto 2d quando for instanciar")
    void deveCriarPonto2D(){
        Ponto2D ponto2D = new Ponto2D(UUID.randomUUID(), BigDecimal.valueOf(2.5), BigDecimal.valueOf(5.4));

        String resultado = ponto2D.toString();

        String resultadoEsperado = "Id : " + ponto2D.getId() + ", coordX : " + ponto2D.getCoordX() + ", coordY : " + ponto2D.getCoordY();
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    @DisplayName("Deve comparar Ponto2D quando não forem iguais")
    void deveCompararPonto2DNaoIguais(){
        Ponto2D ponto1 = new Ponto2D(UUID.randomUUID(), BigDecimal.valueOf(2.5), BigDecimal.valueOf(5.4));
        Ponto2D ponto2 = new Ponto2D(UUID.randomUUID(), BigDecimal.valueOf(2.6), BigDecimal.valueOf(5.7));

        assertNotEquals(ponto1, ponto2);
        assertNotEquals(ponto1.hashCode(), ponto2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar Ponto2D quando forem iguais")
    void deveCompararPonto2DIguais(){
        UUID id = UUID.randomUUID();
        BigDecimal x = BigDecimal.ONE;
        BigDecimal y = BigDecimal.TEN;
        Ponto2D ponto1 = new Ponto2D(id, x, y);
        Ponto2D ponto2 = new Ponto2D(id, x, y);

        assertEquals(ponto1, ponto2);
        assertEquals(ponto1.hashCode(), ponto2.hashCode());
    }

}
