package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.UUID;

class NumeroPrimoTest {

    @Test
    @DisplayName("Deve validar o número informado quando verificar se é número primo")
    void deveValidarAoVerificarSeEhNumeroPrimo(){
        NumeroPrimo numeroPrimo = new NumeroPrimo(UUID.randomUUID(), null);
        assertThrows(RegraDeNegocioException.class, numeroPrimo::isNumeroPrimo);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -31, -2, -3})
    @DisplayName("Deve verificar se o número informado é menor ou igual que zero quando verificar se é número primo")
    void deveValidarNumeroMenorOuIgualAoZero(int valor){
        NumeroPrimo numeroPrimo = new NumeroPrimo(UUID.randomUUID(), valor);
        assertThrows(RegraDeNegocioException.class, numeroPrimo::isNumeroPrimo);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43})
    @DisplayName("Deve verificar se o número informado é primo")
    void deveValidarSeEhNumeroPrimo(int valor){
        NumeroPrimo numeroPrimo = new NumeroPrimo(UUID.randomUUID(), valor);

        boolean resultado = numeroPrimo.isNumeroPrimo();

        assertTrue(resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30})
    @DisplayName("Deve verificar se o número informado não é primo")
    void deveValidarSeNaoEhNumeroPrimo(int valor){
        NumeroPrimo numeroPrimo = new NumeroPrimo(UUID.randomUUID(), valor);

        boolean resultado = numeroPrimo.isNumeroPrimo();

        assertFalse(resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43})
    @DisplayName("Deve verificar se o número informado é primo")
    void deveValidarSeEhNumeroPrimoComGettersSetters(int valor){
        NumeroPrimo numeroPrimo = new NumeroPrimo();
        numeroPrimo.setId(UUID.randomUUID());
        numeroPrimo.setValor(valor);

        boolean resultado = numeroPrimo.isNumeroPrimo();

        assertTrue(resultado);
        assertNotNull(numeroPrimo.getId());
        assertNotNull(numeroPrimo.getValor());
        assertNotNull(numeroPrimo.toString());
    }

    @Test
    @DisplayName("Deve comparar número quando não forem iguais")
    void deveCompararNumeroNaoIguais(){
        NumeroPrimo numeroPrimo1 = new NumeroPrimo(UUID.randomUUID(), 11);
        NumeroPrimo numeroPrimo2 = new NumeroPrimo(UUID.randomUUID(), 10);

        assertNotEquals(numeroPrimo1, numeroPrimo2);
        assertNotEquals(numeroPrimo1.hashCode(), numeroPrimo2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar aluno quando forem iguais")
    void deveCompararAlunoIguais(){
        UUID id = UUID.randomUUID();
        Integer numero = 10;
        NumeroPrimo numeroPrimo1 = new NumeroPrimo(id, numero);
        NumeroPrimo numeroPrimo2 = new NumeroPrimo(id, numero);

        assertEquals(numeroPrimo1, numeroPrimo2);
        assertEquals(numeroPrimo1.hashCode(), numeroPrimo2.hashCode());
    }
}
