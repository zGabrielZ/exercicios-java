package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RetanguloTest {

    @Test
    @DisplayName("Deve validar o cálculo da área quando não informar a base")
    void deveValidarCalcularAreaQuandoNaoInformarBase(){
        Retangulo retangulo = new Retangulo(UUID.randomUUID(), null, 5);
        assertThrows(RegraDeNegocioException.class, retangulo::calcularArea);
    }

    @Test
    @DisplayName("Deve validar o cálculo da área quando não informar a altura")
    void deveValidarCalcularAreaQuandoNaoInformarAltura(){
        Retangulo retangulo = new Retangulo(UUID.randomUUID(), 5, null);
        assertThrows(RegraDeNegocioException.class, retangulo::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular a área quando informar a base e altura")
    void deveCalcularArea(){
        Retangulo retangulo = new Retangulo(UUID.randomUUID(), 5, 7);

        BigDecimal resultado = retangulo.calcularArea();

        assertEquals(BigDecimal.valueOf(35), resultado);
    }

    @Test
    @DisplayName("Deve calcular a área quando informar a base e altura com setters e getters")
    void deveCalcularAreaComGetterSetters(){
        Retangulo retangulo = new Retangulo();
        retangulo.setId(UUID.randomUUID());
        retangulo.setAltura(7);
        retangulo.setBase(5);

        BigDecimal resultado = retangulo.calcularArea();

        assertEquals(BigDecimal.valueOf(35), resultado);
        assertEquals(5, retangulo.getBase());
        assertEquals(7, retangulo.getAltura());
        assertNotNull(retangulo.getId());
        assertNotNull(retangulo.toString());
    }
}
