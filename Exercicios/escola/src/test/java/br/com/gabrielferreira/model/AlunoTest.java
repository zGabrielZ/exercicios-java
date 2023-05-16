package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
}
