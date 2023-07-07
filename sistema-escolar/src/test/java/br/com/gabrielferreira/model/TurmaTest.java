package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.utils.CalculoUtils.toRetorno;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TurmaTest {

    @Test
    @DisplayName("Deve calcular média quando informar corretamente")
    void deveCalcularMedia(){
        Aluno aluno1 = Aluno.builder()
                .id(UUID.randomUUID())
                .nome("Gabriel")
                .provaParte1(
                        Prova.builder()
                                .id(UUID.randomUUID())
                                .disciplina("Programação")
                                .notaParte1(toBigDecimal(4.0))
                                .notaParte2(toBigDecimal(2.5))
                                .build()
                )
                .provaParte2(
                        Prova.builder()
                                .id(UUID.randomUUID())
                                .disciplina("Matemática")
                                .notaParte1(toBigDecimal(1.0))
                                .notaParte2(toBigDecimal(7.5))
                                .build()
                )
                .build();

        Aluno aluno2 = Aluno.builder()
                .id(UUID.randomUUID())
                .nome("José")
                .provaParte1(
                        Prova.builder()
                                .id(UUID.randomUUID())
                                .disciplina("Programação")
                                .notaParte1(toBigDecimal(6.5))
                                .notaParte2(toBigDecimal(3.5))
                                .build()
                )
                .provaParte2(
                        Prova.builder()
                                .id(UUID.randomUUID())
                                .disciplina("Matemática")
                                .notaParte1(toBigDecimal(0.0))
                                .notaParte2(toBigDecimal(3.5))
                                .build()
                )
                .build();

        Aluno aluno3 = Aluno.builder()
                .id(UUID.randomUUID())
                .nome("Marcos")
                .provaParte1(
                        Prova.builder()
                                .id(UUID.randomUUID())
                                .disciplina("Programação")
                                .notaParte1(toBigDecimal(5.0))
                                .notaParte2(toBigDecimal(4.0))
                                .build()
                )
                .provaParte2(
                        Prova.builder()
                                .id(UUID.randomUUID())
                                .disciplina("Matemática")
                                .notaParte1(toBigDecimal(6.0))
                                .notaParte2(toBigDecimal(1.5))
                                .build()
                )
                .build();

        Turma turma = Turma.builder()
                .id(UUID.randomUUID())
                .descricao("Turma dos Alunos bons")
                .alunos(Arrays.asList(aluno1, aluno2, aluno3))
                .build();

        BigDecimal resultado = turma.calcularMedia();

        assertEquals(toRetorno(toBigDecimal(7.50), 2, RoundingMode.HALF_EVEN), resultado);
    }
}
