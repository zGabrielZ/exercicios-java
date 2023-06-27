package br.com.gabrielferreira.utils;
import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static br.com.gabrielferreira.utils.CurrencyConverterUtils.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterUtilsTest {

    @Test
    @DisplayName("Deve validar o preço do dolar quando está nulo")
    void deveValidarPrecoDolarNulo(){
        BigDecimal cotacaoDolar = null;
        BigDecimal dolar = toBigDecimal(100.00);
        assertThrows(RegraDeNegocioException.class, () -> dolarToReal(dolar, cotacaoDolar));
    }

    @Test
    @DisplayName("Deve validar o preço do dolar quando está negativo")
    void deveValidarPrecoDolarNegativo(){
        BigDecimal cotacaoDolar = toBigDecimal(-10);
        BigDecimal dolar = toBigDecimal(100.00);
        assertThrows(RegraDeNegocioException.class, () -> dolarToReal(dolar, cotacaoDolar));
    }

    @Test
    @DisplayName("Deve validar o dolar quando está nulo")
    void deveValidarDolarNulo(){
        BigDecimal cotacaoDolar = toBigDecimal(4.80);
        BigDecimal dolar = null;
        assertThrows(RegraDeNegocioException.class, () -> dolarToReal(dolar, cotacaoDolar));
    }

    @Test
    @DisplayName("Deve validar o dolar quando está negativo")
    void deveValidarDolarNegativo(){
        BigDecimal cotacaoDolar = toBigDecimal(4.80);
        BigDecimal dolar = toBigDecimal(-100.00);
        assertThrows(RegraDeNegocioException.class, () -> dolarToReal(dolar, cotacaoDolar));
    }

    @Test
    @DisplayName("Deve realizar dolar para real")
    void deveRealizarDolarParaReal(){
        BigDecimal resultado = dolarToReal(toBigDecimal(10.00), toBigDecimal(4.80));

        assertEquals(toBigDecimal(50.88), toRetorno(resultado, 2, RoundingMode.HALF_EVEN));
    }
}
