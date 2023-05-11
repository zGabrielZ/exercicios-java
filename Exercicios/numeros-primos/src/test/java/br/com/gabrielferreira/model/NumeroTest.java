package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.UUID;

class NumeroTest {

    @Test
    @DisplayName("Deve validar o número informado quando verificar se é número primo")
    void deveValidarAoVerificarSeEhNumeroPrimo(){
        Numero numero = new Numero(UUID.randomUUID(), null);
        assertThrows(RegraDeNegocioException.class, numero::isNumeroPrimo);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -31, -2, -3})
    @DisplayName("Deve verificar se o número informado é menor ou igual que zero quando verificar se é número primo")
    void deveValidarNumeroMenorOuIgualAoZero(int valor){
        Numero numero = new Numero(UUID.randomUUID(), valor);
        assertThrows(RegraDeNegocioException.class, numero::isNumeroPrimo);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43})
    @DisplayName("Deve verificar se o número informado é primo")
    void deveValidarSeEhNumeroPrimo(int valor){
        Numero numero = new Numero(UUID.randomUUID(), valor);

        boolean resultado = numero.isNumeroPrimo();

        assertTrue(resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30})
    @DisplayName("Deve verificar se o número informado não é primo")
    void deveValidarSeNaoEhNumeroPrimo(int valor){
        Numero numero = new Numero(UUID.randomUUID(), valor);

        boolean resultado = numero.isNumeroPrimo();

        assertFalse(resultado);
    }
}
