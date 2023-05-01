package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TurmaTest {

    @Test
    @DisplayName("Deve calcular média quando informar corretamente")
    void deveCalcularMedia(){
        Aluno aluno1 = Aluno.builder()
                .id(UUID.randomUUID())
                .nome("Gabriel")
                .prova1(
                        Prova.builder()
                                .id(UUID.randomUUID())
                                .disciplina("Programação")
                                .notaParte1(4.0)
                                .notaParte2(2.5)
                                .build()
                )
                .prova2(
                        Prova.builder()
                                .id(UUID.randomUUID())
                                .disciplina("Matemática")
                                .notaParte1(1.0)
                                .notaParte2(7.5)
                                .build()
                )
                .build();

        Aluno aluno2 = Aluno.builder()
                .id(UUID.randomUUID())
                .nome("José")
                .prova1(
                        Prova.builder()
                                .id(UUID.randomUUID())
                                .disciplina("Programação")
                                .notaParte1(6.5)
                                .notaParte2(3.5)
                                .build()
                )
                .prova2(
                        Prova.builder()
                                .id(UUID.randomUUID())
                                .disciplina("Matemática")
                                .notaParte1(0.0)
                                .notaParte2(3.5)
                                .build()
                )
                .build();

        Aluno aluno3 = Aluno.builder()
                .id(UUID.randomUUID())
                .nome("Marcos")
                .prova1(
                        Prova.builder()
                                .id(UUID.randomUUID())
                                .disciplina("Programação")
                                .notaParte1(5.0)
                                .notaParte2(4.0)
                                .build()
                )
                .prova2(
                        Prova.builder()
                                .id(UUID.randomUUID())
                                .disciplina("Matemática")
                                .notaParte1(6.0)
                                .notaParte2(1.5)
                                .build()
                )
                .build();

        Turma turma = Turma.builder()
                .id(UUID.randomUUID())
                .descricao("Turma dos Alunos bons")
                .alunos(Arrays.asList(aluno1, aluno2, aluno3))
                .build();

        Double resultado = turma.calcularMedia();

        assertEquals(7.5, resultado);
    }
}
