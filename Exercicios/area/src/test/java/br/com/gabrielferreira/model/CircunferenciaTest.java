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
    @DisplayName("Deve validar o cálculo da área quando não informar o raio")
    void deveValidarCalcularArea(){
        Circunferencia circunferencia = new Circunferencia(UUID.randomUUID(), null);
        assertThrows(RegraDeNegocioException.class, circunferencia::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular a área quando informar o raio")
    void deveCalcularArea(){
        Circunferencia circunferencia = new Circunferencia(UUID.randomUUID(), 5);

        BigDecimal resultado = circunferencia.calcularArea();

        assertEquals(toBigDecimal(78.54), resultado);
    }

    @Test
    @DisplayName("Deve calcular a área quando informar o raio com getters e setters")
    void deveCalcularAreaComGettersSetters(){
        Circunferencia circunferencia = new Circunferencia();
        circunferencia.setId(UUID.randomUUID());
        circunferencia.setRaio(5);

        BigDecimal resultado = circunferencia.calcularArea();

        assertEquals(toBigDecimal(78.54), resultado);
        assertEquals(5, circunferencia.getRaio());
        assertNotNull(circunferencia.getId());
        assertNotNull(circunferencia.toString());
    }

    @Test
    @DisplayName("Deve comparar circunferência quando não forem iguais")
    void deveCompararCircunferenciaNaoIguais(){
        Circunferencia circunferencia1 = new Circunferencia(UUID.randomUUID(), 5);
        Circunferencia circunferencia2 = new Circunferencia(UUID.randomUUID(), 6);

        assertNotEquals(circunferencia1, circunferencia2);
        assertNotEquals(circunferencia1.hashCode(), circunferencia2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar circunferência quando forem iguais")
    void deveCompararCircunferenciaIguais(){
        UUID uuid = UUID.randomUUID();
        Integer raio = 5;
        Circunferencia circunferencia1 = new Circunferencia(uuid, raio);
        Circunferencia circunferencia2 = new Circunferencia(uuid, raio);

        assertEquals(circunferencia1, circunferencia2);
        assertEquals(circunferencia1.hashCode(), circunferencia2.hashCode());
    }
}
