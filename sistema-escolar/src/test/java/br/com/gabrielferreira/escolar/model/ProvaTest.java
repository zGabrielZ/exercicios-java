package br.com.gabrielferreira.escolar.model;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProvaTest {

    @Test
    @DisplayName("Deve validar o cálculo quando não informar a nota parte 1")
    void deveValidarNotaParte1(){
        Prova prova = Prova.builder()
                .id(UUID.randomUUID())
                .disciplina("Programação")
                .notaParte1(null)
                .notaParte2(toBigDecimal(2.9))
                .build();
        assertThrows(RegraDeNegocioException.class, prova::calcularNotaTotal);
    }

    @Test
    @DisplayName("Deve validar o cálculo quando não informar a nota parte 2")
    void deveValidarNotaParte2(){
        Prova prova = Prova.builder()
                .id(UUID.randomUUID())
                .disciplina("Programação")
                .notaParte2(null)
                .notaParte1(toBigDecimal(3.5))
                .build();
        assertThrows(RegraDeNegocioException.class, prova::calcularNotaTotal);
    }

    @Test
    @DisplayName("Deve validar o cálculo quando ultrapassar de 10.0")
    void deveValidarNota(){
        Prova prova = Prova.builder()
                .id(UUID.randomUUID())
                .disciplina("Programação")
                .notaParte1(toBigDecimal(4.5))
                .notaParte2(toBigDecimal(6.5))
                .build();
        assertThrows(RegraDeNegocioException.class, prova::calcularNotaTotal);
    }

    @Test
    @DisplayName("Deve calcular nota quando informar corretamente")
    void deveCalcularNota(){
        Prova prova = Prova.builder()
                .id(UUID.randomUUID())
                .disciplina("Programação")
                .notaParte1(toBigDecimal(4.0))
                .notaParte2(toBigDecimal(2.5))
                .build();

        BigDecimal resultado = prova.calcularNotaTotal();

        assertEquals(toBigDecimal(6.5), resultado);
    }
}
