package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProcessoTest {

    @Test
    @DisplayName("Deve imprimir nulo quando informar nulo ou vazio")
    void deveImprimirNulo(){
        Processo processo = new Processo();
        String resultado = processo.processar("");
        assertNull(resultado);
    }

    @Test
    @DisplayName("Deve imprimir maiusculo quando informar palavra até 3 caracteres")
    void deveImprimirMaiusculo(){
        Processo processo = new Processo();
        String resultado = processo.processar("abc");
        assertEquals("ABC", resultado);
    }

    @Test
    @DisplayName("Deve imprimir maiusculo quando informar palavra até maior que 3 caracteres e retornar as três primeiras letras inversa")
    void deveImprimirMaiusculoTresPrimeirasLetrasInversa(){
        Processo processo = new Processo();
        String resultado = processo.processar("gabriel");
        assertEquals("BAGRIEL", resultado);
    }
}
