package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class FracaoTest {

    @Test
    @DisplayName("Deve criar fração")
    void deveCriarFracao(){
        Fracao fracao = new Fracao();
        fracao.setId(UUID.randomUUID());
        fracao.setNumerador(10);
        fracao.setDenominador(20);

        assertEquals(10, fracao.getNumerador());
        assertEquals(20, fracao.getDenominador());
        assertNotNull(fracao.getId());
        assertNotNull(fracao.toString());
    }

    @Test
    @DisplayName("Deve comparar fração quando não forem iguais")
    void deveCompararFracaoNaoIguais(){
        Fracao fracao1 = new Fracao(UUID.randomUUID(), 10, 20);
        Fracao fracao2 = new Fracao(UUID.randomUUID(), 20, 30);

        assertNotEquals(fracao1, fracao2);
        assertNotEquals(fracao1.hashCode(), fracao2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar aluno quando forem iguais")
    void deveCompararAlunoIguais(){
        UUID id = UUID.randomUUID();
        Integer numerador = 10;
        Integer denominador = 20;
        Fracao fracao1 = new Fracao(id, numerador, denominador);
        Fracao fracao2 = new Fracao(id, numerador, denominador);

        assertEquals(fracao1, fracao2);
        assertEquals(fracao1.hashCode(), fracao2.hashCode());
    }
}
