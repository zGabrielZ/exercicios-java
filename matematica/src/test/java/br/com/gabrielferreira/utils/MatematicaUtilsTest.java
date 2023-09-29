package br.com.gabrielferreira.utils;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.enumeration.TipoAngulo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.gabrielferreira.utils.MatematicaUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatematicaUtilsTest {

    @Test
    @DisplayName("Deve validar a conversão do ângulo quando não informar o valor")
    void deveValidarConverterAnguloValorNulo(){
        assertThrows(RegraDeNegocioException.class, () -> converterAngulo(null, TipoAngulo.RADIANOS));
    }

    @Test
    @DisplayName("Deve validar a conversão do ângulo quando não informar o tipo do ângulo")
    void deveValidarConverterAnguloTipoAnguloNulo(){
        assertThrows(RegraDeNegocioException.class, () -> converterAngulo(20.0, null));
    }

    @Test
    @DisplayName("Deve converter ângulo para grau quando informar corretamente")
    void deveConverterAnguloGrau(){
        Double valor = converterAngulo(90.0, TipoAngulo.GRAUS);
        assertEquals(1.57, valor, 2);
    }

    @Test
    @DisplayName("Deve converter ângulo para radiano quando informar corretamente")
    void deveConverterAnguloRadiano(){
        Double valor = converterAngulo(45.0, TipoAngulo.RADIANOS);
        assertEquals(2578.31, valor, 2);
    }

    @Test
    @DisplayName("Deve validar a soma quando não informar o primeiro valor ")
    void deveValidarSomaPrimeiroValorNulo(){
        assertThrows(RegraDeNegocioException.class, () -> somar(null, 1, 3));
    }

    @Test
    @DisplayName("Deve validar a soma quando não informar o segundo valor ")
    void deveValidarSomaSegundoValorNulo(){
        assertThrows(RegraDeNegocioException.class, () -> somar(1, null, 3));
    }

    @Test
    @DisplayName("Deve validar a soma quando não informar o terceiro valor ")
    void deveValidarSomaTerceiroValorNulo(){
        assertThrows(RegraDeNegocioException.class, () -> somar(1, 3, null));
    }

    @Test
    @DisplayName("Deve somar quando informar corretamente")
    void deveSomar(){
        Integer valor = somar(1, 3, 5);
        assertEquals(9, valor);
    }

    @Test
    @DisplayName("Deve validar a conversão quando não informar o valor ")
    void deveValidarConversaoDecimalParaBinario(){
        assertThrows(RegraDeNegocioException.class, () -> converterDecimalParaBinario(null));
    }

    @Test
    @DisplayName("Deve realizar a conversão quando informar corretamente")
    void deveConverterDecimalParaBinario(){
        String valor = converterDecimalParaBinario(7);
        assertEquals("111", valor);
    }

    @Test
    @DisplayName("Deve validar a conversão quando não informar o valor ")
    void deveValidarConversaoBinarioParaDecimal(){
        assertThrows(RegraDeNegocioException.class, () -> converterBinarioParaDecimal(null));
    }

    @Test
    @DisplayName("Deve realizar a conversão quando informar corretamente")
    void deveConverterBinarioParaDecimal(){
        Integer valor = converterBinarioParaDecimal("0111");
        assertEquals(7, valor);
    }
}
