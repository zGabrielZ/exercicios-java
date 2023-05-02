package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProvaTest {

    @Test
    @DisplayName("Deve validar o cálculo quando não informar a nota parte 1")
    void deveValidarNotaParte1(){
        Prova prova = new Prova(UUID.randomUUID(), "Programação", null, 2.9);
        assertThrows(RegraDeNegocioException.class, prova::calcularNotaTotal);
    }

    @Test
    @DisplayName("Deve validar o cálculo quando não informar a nota parte 2")
    void deveValidarNotaParte2(){
        Prova prova = new Prova(UUID.randomUUID(), "Programação", 3.5, null);
        assertThrows(RegraDeNegocioException.class, prova::calcularNotaTotal);
    }

    @Test
    @DisplayName("Deve validar o cálculo quando ultrapassar de 10.0")
    void deveValidarNota(){
        Prova prova = new Prova(UUID.randomUUID(), "Programação", 4.5, 6.5);
        assertThrows(RegraDeNegocioException.class, prova::calcularNotaTotal);
    }

    @Test
    @DisplayName("Deve calcular nota quando informar corretamente")
    void deveCalcularNota(){
        Prova prova = new Prova(UUID.randomUUID(), "Programação", 4.0, 2.5);

        Double resultado = prova.calcularNotaTotal();

        assertEquals(6.5, resultado);
    }
}
