package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Fracao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FracaoServiceTest {

    private FracaoService fracaoService;

    @BeforeEach
    public void criarInstancias(){
        fracaoService = new FracaoService();
    }

    @Test
    @DisplayName("Deveria validar a fração quando não informar ela")
    void deveValidarFracaoNula(){

        Fracao fracao = new Fracao(UUID.randomUUID(), 4, 10);

        assertThrows(RegraDeNegocioException.class, () -> fracaoService.multiplicarFracao(null, fracao));
    }

    @Test
    @DisplayName("Deveria validar o numerador quando não informar ela")
    void deveValidarFracaoNumerador(){

        Fracao fracao = new Fracao(UUID.randomUUID(), 4, 10);
        Fracao fracao2 = new Fracao(UUID.randomUUID(), null, 10);

        assertThrows(RegraDeNegocioException.class, () -> fracaoService.multiplicarFracao(fracao, fracao2));
    }

    @Test
    @DisplayName("Deveria validar o denominador quando não informar ela")
    void deveValidarFracaoDenominador(){

        Fracao fracao = new Fracao(UUID.randomUUID(), 4, 10);
        Fracao fracao2 = new Fracao(UUID.randomUUID(), 4, null);

        assertThrows(RegraDeNegocioException.class, () -> fracaoService.multiplicarFracao(fracao, fracao2));
    }

    @Test
    @DisplayName("Deveria criar multiplicação quando informar corretamente")
    void deveMultiplicarFracao(){

        Fracao fracao = new Fracao(UUID.randomUUID(), 4, 10);
        Fracao fracao2 = new Fracao(UUID.randomUUID(), 3, 5);

        Fracao resultado = fracaoService.multiplicarFracao(fracao, fracao2);

        assertEquals(12, resultado.getNumerador());
        assertEquals(50, resultado.getDenominador());
        assertEquals("12 / 50", resultado.lerFracao());
    }
}
