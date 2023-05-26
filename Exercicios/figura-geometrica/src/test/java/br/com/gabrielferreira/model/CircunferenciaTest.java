package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class CircunferenciaTest {

    @Test
    @DisplayName("Deve validar o raio quando não informar ela")
    void deveValidarRaio(){
        Circunferencia circunferencia = new Circunferencia(UUID.randomUUID(), null);
        assertThrows(RegraDeNegocioException.class, circunferencia::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente")
    void deveCalcularArea(){
        Circunferencia circunferencia = new Circunferencia(UUID.randomUUID(), 3);

        BigDecimal resultado = circunferencia.calcularArea();

        assertEquals(toBigDecimal(28.27), resultado);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente com getters e setters")
    void deveCalcularAreaComGettersSetters(){
        Circunferencia circunferencia = new Circunferencia();
        circunferencia.setId(UUID.randomUUID());
        circunferencia.setRaio(3);

        BigDecimal resultado = circunferencia.calcularArea();

        assertEquals(toBigDecimal(28.27), resultado);
        assertEquals(3, circunferencia.getRaio());
        assertNotNull(circunferencia.getId());
        assertNotNull(circunferencia.toString());
    }

    @Test
    @DisplayName("Deve comparar circunferência quando não forem iguais")
    void deveCompararCircunferenciaNaoIguais(){
        Circunferencia circunferencia1 = new Circunferencia(UUID.randomUUID(), 3);
        Circunferencia circunferencia2 = new Circunferencia(UUID.randomUUID(), 4);

        assertNotEquals(circunferencia1, circunferencia2);
        assertNotEquals(circunferencia1.hashCode(), circunferencia2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar circunferência quando forem iguais")
    void deveCompararCircunferenciaIguais(){
        UUID id = UUID.randomUUID();
        Integer raio = 3;
        Circunferencia circunferencia1 = new Circunferencia(id, raio);
        Circunferencia circunferencia2 = new Circunferencia(id, raio);

        assertEquals(circunferencia1, circunferencia2);
        assertEquals(circunferencia1.hashCode(), circunferencia2.hashCode());
    }

}
