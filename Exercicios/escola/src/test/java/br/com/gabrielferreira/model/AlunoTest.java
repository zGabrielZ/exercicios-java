package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    @DisplayName("Deve criar aluno")
    void deveCriarAluno(){
        Aluno aluno = new Aluno(UUID.randomUUID(), "Gabriel", null);
        aluno.setProvas(new ArrayList<>());
        assertNotNull(aluno.getId());
        assertNotNull(aluno.toString());
    }

    @Test
    @DisplayName("Deve comparar aluno quando não forem iguais")
    void deveCompararAlunoNaoIguais(){
        Aluno aluno1 = new Aluno(UUID.randomUUID(), "Marcos", null);
        Aluno aluno2 = new Aluno(UUID.randomUUID(), "Gabriel", null);

        assertNotEquals(aluno1, aluno2);
        assertNotEquals(aluno1.hashCode(), aluno2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar aluno quando forem iguais")
    void deveCompararAlunoIguais(){
        UUID id = UUID.randomUUID();
        String nome = "Marcos";
        List<Prova> prova = new ArrayList<>();
        Aluno aluno1 = new Aluno(id, nome, prova);
        Aluno aluno2 = new Aluno(id, nome, prova);

        assertEquals(aluno1, aluno2);
        assertEquals(aluno1.hashCode(), aluno2.hashCode());
    }
}
