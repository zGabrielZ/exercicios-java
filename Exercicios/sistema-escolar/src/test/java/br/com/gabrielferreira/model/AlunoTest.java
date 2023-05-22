package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AlunoTest {

    @Test
    @DisplayName("Deve validar o cálculo quando não informar a prova 1")
    void deveValidarProva1(){
        Aluno aluno = new Aluno(UUID.randomUUID(), "José", null, new Prova(UUID.randomUUID(), "Programação", BigDecimal.valueOf(4.5)
                , BigDecimal.valueOf(2.0)));
        assertThrows(RegraDeNegocioException.class, aluno::calcularMedia);
    }

    @Test
    @DisplayName("Deve validar o cálculo quando não informar a prova 2")
    void deveValidarProva2(){
        Aluno aluno = new Aluno(UUID.randomUUID(), "José", new Prova(UUID.randomUUID(), "Programação", BigDecimal.valueOf(4.5),
                BigDecimal.valueOf(2.0)), null);
        assertThrows(RegraDeNegocioException.class, aluno::calcularMedia);
    }

    @Test
    @DisplayName("Deve calcular nota quando informar corretamente")
    void deveCalcularNota(){
        Aluno aluno = new Aluno(UUID.randomUUID(), "José", new Prova(UUID.randomUUID(), "Programação", BigDecimal.valueOf(4.0), BigDecimal.valueOf(2.5)),
                new Prova(UUID.randomUUID(), "Matemática", BigDecimal.valueOf(1.0), BigDecimal.valueOf(7.0)));

        BigDecimal resultado = aluno.calcularMedia();

        assertEquals(BigDecimal.valueOf(7.2), resultado);
    }

    @Test
    @DisplayName("Deve criar aluno")
    void deveCriarAluno(){
        Aluno aluno = new Aluno();
        aluno.setId(UUID.randomUUID());
        aluno.setNome("Teste");
        aluno.setProvaParte1(new Prova(UUID.randomUUID(), null, null, null));
        aluno.setProvaParte2(new Prova(UUID.randomUUID(), null, null, null));

        assertNotNull(aluno.getId());
        assertEquals("Teste", aluno.getNome());
        assertNotNull(aluno.getProvaParte1());
        assertNotNull(aluno.getProvaParte2());
        assertNotNull(aluno.toString());
    }

    @Test
    @DisplayName("Deve comparar aluno quando não forem iguais")
    void deveCompararAlunoNaoIguais(){
        Aluno aluno1 = new Aluno(UUID.randomUUID(), "José Teste", null, null);
        Aluno aluno2 = new Aluno(UUID.randomUUID(), "José Teste 2", null, null);

        assertNotEquals(aluno1, aluno2);
        assertNotEquals(aluno1.hashCode(), aluno2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar aluno quando forem iguais")
    void deveCompararAlunoIguais(){
        UUID id = UUID.randomUUID();
        String nome = "Teste";
        Prova prova = new Prova();
        Aluno aluno1 = new Aluno(id, nome, prova, prova);
        Aluno aluno2 = new Aluno(id, nome, prova, prova);

        assertEquals(aluno1, aluno2);
        assertEquals(aluno1.hashCode(), aluno2.hashCode());
    }
}
