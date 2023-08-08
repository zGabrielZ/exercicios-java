package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Curso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CursoServiceTest {

    private CursoService cursoService;

    @BeforeEach
    public void criarInstancias(){
        cursoService = new CursoService();
    }

    @Test
    @DisplayName("Deve validar criação do curso quando informar o tipo nulo")
    void deveValidarCriarCursoTipoNulo(){
        String tipo = null;
        assertThrows(RegraDeNegocioException.class, () -> cursoService.criarCurso(tipo, 1, 2, 3));
    }

    @Test
    @DisplayName("Deve validar criação do curso quando informar código de aluno repetido")
    void deveValidarCriarCursoCodigoAlunoRepetido(){
        String tipo = "A";
        assertThrows(RegraDeNegocioException.class, () -> cursoService.criarCurso(tipo, 1, 1, 2, 2, 3));
    }

    @Test
    @DisplayName("Deve validar criação do curso quando não informar código de aluno")
    void deveValidarCriarCursoNenhumAluno(){
        String tipo = "A";
        assertThrows(RegraDeNegocioException.class, () -> cursoService.criarCurso(tipo, null));
    }

    @Test
    @DisplayName("Deve criar curso")
    void deveCriarCurso(){
        Curso curso = cursoService.criarCurso("A", 1, 2, 3);

        assertNotNull(curso.getId());
        assertEquals("A", curso.getTipoCurso());
        assertEquals(1, curso.getAlunos().get(0).getCodigoAluno());
        assertEquals(2, curso.getAlunos().get(1).getCodigoAluno());
        assertEquals(3, curso.getAlunos().get(2).getCodigoAluno());
    }

    @Test
    @DisplayName("Deve calcular quantidade de alunos em curso")
    void deveCalcularQuantidadeAluno(){
        Curso curso1 = cursoService.criarCurso("A", 1, 2, 3);
        Curso curso2 = cursoService.criarCurso("B", 2, 5, 6);
        Curso curso3 = cursoService.criarCurso("C", 3, 10, 11);

        Integer quantidade = cursoService.calcularQuantidadeAlunos(Arrays.asList(curso1, curso2, curso3));

        assertEquals(7, quantidade);
    }

}
