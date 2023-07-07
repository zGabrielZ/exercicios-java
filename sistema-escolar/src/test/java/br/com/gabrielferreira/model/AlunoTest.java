package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.utils.CalculoUtils.toRetorno;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AlunoTest {

    @Test
    @DisplayName("Deve validar o cálculo quando não informar a prova 1")
    void deveValidarProva1(){
        Aluno aluno = Aluno.builder()
                .id(UUID.randomUUID())
                .nome("José")
                .provaParte1(null)
                .provaParte2(Prova.builder()
                        .id(UUID.randomUUID())
                        .disciplina("Programação")
                        .notaParte1(toBigDecimal(4.5))
                        .notaParte2(toBigDecimal(2.0))
                        .build())
                .build();
        assertThrows(RegraDeNegocioException.class, aluno::calcularMedia);
    }

    @Test
    @DisplayName("Deve validar o cálculo quando não informar a prova 2")
    void deveValidarProva2(){
        Aluno aluno = Aluno.builder()
                .id(UUID.randomUUID())
                .nome("José")
                .provaParte2(null)
                .provaParte1(Prova.builder()
                        .id(UUID.randomUUID())
                        .disciplina("Programação")
                        .notaParte1(toBigDecimal(4.5))
                        .notaParte2(toBigDecimal(2.0))
                        .build())
                .build();
        assertThrows(RegraDeNegocioException.class, aluno::calcularMedia);
    }

    @Test
    @DisplayName("Deve calcular nota quando informar corretamente")
    void deveCalcularNota(){
        Aluno aluno = Aluno.builder()
                .id(UUID.randomUUID())
                .nome("José")
                .provaParte1(Prova.builder()
                        .id(UUID.randomUUID())
                        .disciplina("Programação")
                        .notaParte1(toBigDecimal(4.0))
                        .notaParte2(toBigDecimal(2.5))
                        .build())
                .provaParte2(Prova.builder()
                        .id(UUID.randomUUID())
                        .disciplina("Matemática")
                        .notaParte1(toBigDecimal(1.0))
                        .notaParte2(toBigDecimal(7.0))
                        .build())
                .build();

        BigDecimal resultado = aluno.calcularMedia();

        assertEquals(toRetorno(toBigDecimal(7.25), 2, RoundingMode.HALF_EVEN), resultado);
    }
}
