package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TrapezioTest {

    @Test
    @DisplayName("Deve validar a base maior quando não informar ela")
    void deveValidarBaseMaior(){
        Trapezio trapezio = new Trapezio(UUID.randomUUID(), null, 2, 2);
        assertThrows(RegraDeNegocioException.class, trapezio::calcularArea);
    }

    @Test
    @DisplayName("Deve validar base menor quando não informar ela")
    void deveValidarBaseMenor(){
        Trapezio trapezio = new Trapezio(UUID.randomUUID(), 2, null, 2);
        assertThrows(RegraDeNegocioException.class, trapezio::calcularArea);
    }

    @Test
    @DisplayName("Deve validar altura quando não informar ela")
    void deveValidarAltura(){
        Trapezio trapezio = new Trapezio(UUID.randomUUID(), 2, 2, null);
        assertThrows(RegraDeNegocioException.class, trapezio::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente")
    void deveCalcularArea(){
        Trapezio trapezio = new Trapezio(UUID.randomUUID(), 2, 2, 5);

        BigDecimal resultado = trapezio.calcularArea();

        assertEquals(BigDecimal.valueOf(10.0), resultado);
    }

    @Test
    @DisplayName("Deve calcular área quando informar o valor corretamente com getters e setters")
    void deveCalcularAreaComGettersSetters(){
        Trapezio trapezio = new Trapezio();
        trapezio.setId(UUID.randomUUID());
        trapezio.setBaseMaior(2);
        trapezio.setBaseMenor(2);
        trapezio.setAltura(5);

        BigDecimal resultado = trapezio.calcularArea();

        assertEquals(BigDecimal.valueOf(10.0), resultado);
        assertNotNull(trapezio.getId());
        assertEquals(2, trapezio.getBaseMaior());
        assertEquals(2, trapezio.getBaseMenor());
        assertEquals(5, trapezio.getAltura());
        assertNotNull(trapezio.toString());
    }

    @Test
    @DisplayName("Deve comparar trapézio quando não forem iguais")
    void deveCompararTrapezioNaoIguais(){
        Trapezio trapezio1 = new Trapezio(UUID.randomUUID(), 2, 2, 5);
        Trapezio trapezio2 = new Trapezio(UUID.randomUUID(), 3, 3, 15);

        assertNotEquals(trapezio1, trapezio2);
        assertNotEquals(trapezio1.hashCode(), trapezio2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar trapézio quando forem iguais")
    void deveCompararTrapezioIguais(){
        UUID id = UUID.randomUUID();
        Integer baseMaior = 43;
        Integer baseMenor = 33;
        Integer altura = 13;
        Trapezio trapezio1 = new Trapezio(id, baseMaior, baseMenor, altura);
        Trapezio trapezio2 = new Trapezio(id, baseMaior, baseMenor, altura);

        assertEquals(trapezio1, trapezio2);
        assertEquals(trapezio1.hashCode(), trapezio2.hashCode());
    }

}
