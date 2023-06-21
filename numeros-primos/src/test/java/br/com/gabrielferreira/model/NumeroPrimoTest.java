package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class NumeroPrimoTest {

    @Test
    @DisplayName("Deve validar o número informado quando verificar se é número primo")
    void deveValidarAoVerificarSeEhNumeroPrimo(){
        NumeroPrimo numeroPrimo = NumeroPrimo.builder()
                .id(UUID.randomUUID())
                .valor(null)
                .build();
        assertThrows(RegraDeNegocioException.class, numeroPrimo::isNumeroPrimo);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -31, -2, -3})
    @DisplayName("Deve verificar se o número informado é menor ou igual que zero quando verificar se é número primo")
    void deveValidarNumeroMenorOuIgualAoZero(int valor){
        NumeroPrimo numeroPrimo = NumeroPrimo.builder()
                .id(UUID.randomUUID())
                .valor(valor)
                .build();
        assertThrows(RegraDeNegocioException.class, numeroPrimo::isNumeroPrimo);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43})
    @DisplayName("Deve verificar se o número informado é primo")
    void deveValidarSeEhNumeroPrimo(int valor){
        NumeroPrimo numeroPrimo = NumeroPrimo.builder()
                .id(UUID.randomUUID())
                .valor(valor)
                .build();

        boolean resultado = numeroPrimo.isNumeroPrimo();

        assertTrue(resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30})
    @DisplayName("Deve verificar se o número informado não é primo")
    void deveValidarSeNaoEhNumeroPrimo(int valor){
        NumeroPrimo numeroPrimo = NumeroPrimo.builder()
                .id(UUID.randomUUID())
                .valor(valor)
                .build();

        boolean resultado = numeroPrimo.isNumeroPrimo();

        assertFalse(resultado);
    }
}
