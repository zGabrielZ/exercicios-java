package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AlunoTest {

    @Test
    @DisplayName("Deve validar o cálculo quando não informar a prova 1")
    void deveValidarProva1(){
        Aluno aluno = new Aluno(UUID.randomUUID(), "José", null, new Prova(UUID.randomUUID(), "Programação", 4.5, 2.0));
        assertThrows(RegraDeNegocioException.class, aluno::calcularMedia);
    }

    @Test
    @DisplayName("Deve validar o cálculo quando não informar a prova 2")
    void deveValidarProva2(){
        Aluno aluno = new Aluno(UUID.randomUUID(), "José", new Prova(UUID.randomUUID(), "Programação", 4.5, 2.0), null);
        assertThrows(RegraDeNegocioException.class, aluno::calcularMedia);
    }

    @Test
    @DisplayName("Deve calcular nota quando informar corretamente")
    void deveCalcularNota(){
        Aluno aluno = new Aluno(UUID.randomUUID(), "José", new Prova(UUID.randomUUID(), "Programação", 4.0, 2.5),
                new Prova(UUID.randomUUID(), "Matemática", 1.0, 7.0));

        Double resultado = aluno.calcularMedia();

        assertEquals(7.25, resultado);
    }
}
