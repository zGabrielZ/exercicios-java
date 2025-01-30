package br.com.gabrielferreira.area.model;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.commons.utils.CalculoUtils.toRetorno;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RetanguloTest {

    @Test
    @DisplayName("Deve validar o cálculo da área quando não informar a base")
    void deveValidarCalcularAreaQuandoNaoInformarBase(){
        Retangulo retangulo = Retangulo.builder()
                .id(UUID.randomUUID())
                .base(null)
                .altura(5)
                .build();
        assertThrows(RegraDeNegocioException.class, retangulo::calcularArea);
    }

    @Test
    @DisplayName("Deve validar o cálculo da área quando não informar a altura")
    void deveValidarCalcularAreaQuandoNaoInformarAltura(){
        Retangulo retangulo = Retangulo.builder()
                .id(UUID.randomUUID())
                .base(5)
                .altura(null)
                .build();
        assertThrows(RegraDeNegocioException.class, retangulo::calcularArea);
    }

    @Test
    @DisplayName("Deve calcular a área quando informar a base e altura")
    void deveCalcularArea(){
        Retangulo retangulo = Retangulo.builder()
                .id(UUID.randomUUID())
                .base(5)
                .altura(7)
                .build();

        BigDecimal resultado = retangulo.calcularArea();

        assertEquals(toRetorno(toBigDecimal(35.00), 2, RoundingMode.HALF_EVEN), resultado);
    }
}
