package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class ProvaTest {

    @Test
    @DisplayName("Deve validar o cálculo quando não informar a nota parte 1")
    void deveValidarNotaParte1(){
        Prova prova = new Prova(UUID.randomUUID(), "Programação", null, toBigDecimal(2.9));
        assertThrows(RegraDeNegocioException.class, prova::calcularNotaTotal);
    }

    @Test
    @DisplayName("Deve validar o cálculo quando não informar a nota parte 2")
    void deveValidarNotaParte2(){
        Prova prova = new Prova(UUID.randomUUID(), "Programação", toBigDecimal(3.5), null);
        assertThrows(RegraDeNegocioException.class, prova::calcularNotaTotal);
    }

    @Test
    @DisplayName("Deve validar o cálculo quando ultrapassar de 10.0")
    void deveValidarNota(){
        Prova prova = new Prova(UUID.randomUUID(), "Programação", toBigDecimal(4.5), toBigDecimal(6.5));
        assertThrows(RegraDeNegocioException.class, prova::calcularNotaTotal);
    }

    @Test
    @DisplayName("Deve calcular nota quando informar corretamente")
    void deveCalcularNota(){
        Prova prova = new Prova(UUID.randomUUID(), "Programação", toBigDecimal(4.0), toBigDecimal(2.5));

        BigDecimal resultado = prova.calcularNotaTotal();

        assertEquals(toBigDecimal(6.5), resultado);
    }

    @Test
    @DisplayName("Deve criar prova")
    void deveCriarProva(){
        Prova prova = new Prova();
        prova.setId(UUID.randomUUID());
        prova.setDisciplina("Programação");
        prova.setNotaParte1(toBigDecimal(2.0));
        prova.setNotaParte2(toBigDecimal(1.0));

        assertNotNull(prova.getId());
        assertEquals("Programação", prova.getDisciplina());
        assertEquals(toBigDecimal(2.0), prova.getNotaParte1());
        assertEquals(toBigDecimal(1.0), prova.getNotaParte2());
        assertNotNull(prova.toString());
    }

    @Test
    @DisplayName("Deve comparar prova quando não forem iguais")
    void deveCompararProvaNaoIguais(){
        Prova prova1 = new Prova(UUID.randomUUID(), "Programação 1", toBigDecimal(3.0), toBigDecimal(2.5));
        Prova prova2 = new Prova(UUID.randomUUID(), "Programação 2", toBigDecimal(1.0), toBigDecimal(2.5));

        assertNotEquals(prova1, prova2);
        assertNotEquals(prova1.hashCode(), prova2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar prova quando forem iguais")
    void deveCompararProvaIguais(){
        UUID id = UUID.randomUUID();
        String disciplina = "Programação";
        BigDecimal valor1 = toBigDecimal(3.0);
        BigDecimal valor2 = toBigDecimal(2.5);
        Prova prova1 = new Prova(id, disciplina, valor1, valor2);
        Prova prova2 = new Prova(id, disciplina, valor1, valor2);

        assertEquals(prova1, prova2);
        assertEquals(prova1.hashCode(), prova2.hashCode());
    }
}
