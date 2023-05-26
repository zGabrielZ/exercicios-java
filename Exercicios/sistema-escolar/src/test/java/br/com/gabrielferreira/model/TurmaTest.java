package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class TurmaTest {

    @Test
    @DisplayName("Deve calcular média quando informar corretamente")
    void deveCalcularMedia(){
        Aluno aluno1 = new Aluno(UUID.randomUUID(), "Gabriel",
                new Prova(UUID.randomUUID(), "Programação", toBigDecimal(4.0), toBigDecimal(2.5)),
                new Prova(UUID.randomUUID(), "Matemática", toBigDecimal(1.0), toBigDecimal(7.5)));

        Aluno aluno2 = new Aluno(UUID.randomUUID(), "José",
                new Prova(UUID.randomUUID(), "Programação", toBigDecimal(6.5), toBigDecimal(3.5)),
                new Prova(UUID.randomUUID(), "Matemática", toBigDecimal(0.0), toBigDecimal(3.5)));

        Aluno aluno3 = new Aluno(UUID.randomUUID(), "Marcos",
                new Prova(UUID.randomUUID(), "Programação", toBigDecimal(5.0), toBigDecimal(4.0)),
                new Prova(UUID.randomUUID(), "Matemática", toBigDecimal(6.0), toBigDecimal(1.5)));

        Turma turma = new Turma(UUID.randomUUID(), "Turma dos Alunos bons", Arrays.asList(aluno1, aluno2, aluno3));

        BigDecimal resultado = turma.calcularMedia();

        assertEquals(toBigDecimal(7.5), resultado);
    }

    @Test
    @DisplayName("Deve criar turma")
    void deveCriarTurma(){
        Turma turma = new Turma();
        turma.setId(UUID.randomUUID());
        turma.setDescricao("Teste");
        turma.setAlunos(new ArrayList<>());

        assertNotNull(turma.getId());
        assertEquals("Teste", turma.getDescricao());
        assertNotNull(turma.getAlunos());
        assertNotNull(turma.toString());
    }

    @Test
    @DisplayName("Deve comparar turma quando não forem iguais")
    void deveCompararTurmaNaoIguais(){
        Turma turma1 = new Turma(UUID.randomUUID(), "Turma dos Alunos bons", new ArrayList<>());
        Turma turma2 = new Turma(UUID.randomUUID(), "Turma dos Alunos bons 2", new ArrayList<>());

        assertNotEquals(turma1, turma2);
        assertNotEquals(turma1.hashCode(), turma2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar turma quando forem iguais")
    void deveCompararTurmaIguais(){
        UUID id = UUID.randomUUID();
        String descricao = "Teste";
        List<Aluno> alunos = new ArrayList<>();
        Turma turma1 = new Turma(id, descricao, alunos);
        Turma turma2 = new Turma(id, descricao, alunos);

        assertEquals(turma1, turma2);
        assertEquals(turma1.hashCode(), turma2.hashCode());
    }
}
