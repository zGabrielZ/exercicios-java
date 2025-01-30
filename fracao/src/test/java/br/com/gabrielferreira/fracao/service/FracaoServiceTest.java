package br.com.gabrielferreira.fracao.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.fracao.model.Fracao;
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

        Fracao fracao =  Fracao.builder()
                .id(UUID.randomUUID())
                .numerador(4)
                .denominador(10)
                .build();

        assertThrows(RegraDeNegocioException.class, () -> fracaoService.multiplicarFracao(null, fracao));
    }

    @Test
    @DisplayName("Deveria validar o numerador quando não informar ela")
    void deveValidarFracaoNumerador(){

        Fracao fracao = Fracao.builder()
                .id(UUID.randomUUID())
                .numerador(4)
                .denominador(10)
                .build();

        Fracao fracao2 = Fracao.builder()
                .id(UUID.randomUUID())
                .numerador(null)
                .denominador(10)
                .build();

        assertThrows(RegraDeNegocioException.class, () -> fracaoService.multiplicarFracao(fracao, fracao2));
    }

    @Test
    @DisplayName("Deveria validar o denominador quando não informar ela")
    void deveValidarFracaoDenominador(){

        Fracao fracao = Fracao.builder()
                .id(UUID.randomUUID())
                .numerador(4)
                .denominador(10)
                .build();

        Fracao fracao2 = Fracao.builder()
                .id(UUID.randomUUID())
                .numerador(4)
                .denominador(null)
                .build();

        assertThrows(RegraDeNegocioException.class, () -> fracaoService.multiplicarFracao(fracao, fracao2));
    }

    @Test
    @DisplayName("Deveria criar multiplicação quando informar corretamente")
    void deveMultiplicarFracao(){

        Fracao fracao = Fracao.builder()
                .id(UUID.randomUUID())
                .numerador(4)
                .denominador(10)
                .build();

        Fracao fracao2 = Fracao.builder()
                .id(UUID.randomUUID())
                .numerador(3)
                .denominador(5)
                .build();

        Fracao resultado = fracaoService.multiplicarFracao(fracao, fracao2);

        assertEquals(12, resultado.getNumerador());
        assertEquals(50, resultado.getDenominador());
        assertEquals("12 / 50", resultado.lerFracao());
    }
}
