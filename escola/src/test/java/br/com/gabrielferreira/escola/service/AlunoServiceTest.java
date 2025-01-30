package br.com.gabrielferreira.escola.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.escola.model.Aluno;
import br.com.gabrielferreira.escola.model.Peso;
import br.com.gabrielferreira.escola.model.Prova;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlunoServiceTest {

    private AlunoService alunoService;

    @BeforeEach
    public void criarInstancias(){
        alunoService = new AlunoService();
    }

    @Test
    @DisplayName("Deveria validar quando não informar o aluno")
    void deveValidarAlunoQuandoNaoInformar(){
        List<Aluno> alunos = new ArrayList<>();

        assertThrows(RegraDeNegocioException.class, () -> alunoService.criarAluno(alunos));
    }

    @Test
    @DisplayName("Deveria validar o aluno quando informar nulo")
    void deveValidarAlunoQuandoInformarNulo(){
        Aluno aluno = null;

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);

        assertThrows(RegraDeNegocioException.class, () -> alunoService.criarAluno(alunos));
    }

    @Test
    @DisplayName("Deveria validar o nome do aluno quando informar o nome como nulo")
    void deveValidarNomeAlunoQuandoInformarNulo(){
        Aluno aluno = gerarAluno(null);

        List<Aluno> alunos = List.of(aluno);

        assertThrows(RegraDeNegocioException.class, () -> alunoService.criarAluno(alunos));
    }

    @Test
    @DisplayName("Deveria validar o nome do aluno quando informar o nome como vazio")
    void deveValidarNomeAlunoQuandoInformarVazio(){
        Aluno aluno = gerarAluno("");

        List<Aluno> alunos = List.of(aluno);

        assertThrows(RegraDeNegocioException.class, () -> alunoService.criarAluno(alunos));
    }

    @Test
    @DisplayName("Deveria validar a prova quando informar nulo")
    void deveValidarProvaQuandoInformarNulo(){
        Aluno aluno = gerarAluno("José da Silva");
        Prova prova = null;
        aluno.getProvas().add(prova);

        List<Aluno> alunos = List.of(aluno);

        assertThrows(RegraDeNegocioException.class, () -> alunoService.criarAluno(alunos));
    }

    @Test
    @DisplayName("Deveria validar o nome da prova quando informar a prova como nulo")
    void deveValidarNomeProvaQuandoInformarNulo(){
        Aluno aluno = gerarAluno("José da Silva");
        Prova prova = gerarProva(null, toBigDecimal(10.0));

        aluno.getProvas().add(prova);

        List<Aluno> alunos = List.of(aluno);

        assertThrows(RegraDeNegocioException.class, () -> alunoService.criarAluno(alunos));
    }

    @Test
    @DisplayName("Deveria validar o nome da prova quando informar a prova como vazio")
    void deveValidarNomeProvaQuandoInformarVazio(){
        Aluno aluno = gerarAluno("José da Silva");
        Prova prova = gerarProva("", toBigDecimal(10.0));

        aluno.getProvas().add(prova);

        List<Aluno> alunos = List.of(aluno);

        assertThrows(RegraDeNegocioException.class, () -> alunoService.criarAluno(alunos));
    }

    @Test
    @DisplayName("Deveria validar a nota da prova quando informar a prova")
    void deveValidarNotaProvaQuandoInformarNulo(){
        Aluno aluno = gerarAluno("José da Silva");
        Prova prova = gerarProva("Educação Física", null);

        aluno.getProvas().add(prova);

        List<Aluno> alunos = List.of(aluno);

        assertThrows(RegraDeNegocioException.class, () -> alunoService.criarAluno(alunos));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -0.5, 11.0, 15.0, 10.5})
    @DisplayName("Deveria validar a nota da prova quando informar a nota diferente de 0 até 10")
    void deveValidarNotaProvaQuandoInformarDiferente0E10(double notas){
        Aluno aluno = gerarAluno("José da Silva");
        Prova prova = gerarProva("Educação Física", toBigDecimal(notas));

        aluno.getProvas().add(prova);

        List<Aluno> alunos = List.of(aluno);

        assertThrows(RegraDeNegocioException.class, () -> alunoService.criarAluno(alunos));
    }

    @Test
    @DisplayName("Deveria validar a prova quando informar nulo")
    void deveValidarPesoQuandoInformarNulo(){
        Aluno aluno = gerarAluno("José da Silva");
        Prova prova = gerarProva("Educação Física", toBigDecimal(5.0));
        Peso peso = null;

        prova.setPeso(peso);
        aluno.getProvas().add(prova);

        List<Aluno> alunos = List.of(aluno);

        assertThrows(RegraDeNegocioException.class, () -> alunoService.criarAluno(alunos));
    }

    @Test
    @DisplayName("Deveria validar a nota do peso quando informar o peso")
    void deveValidarNotaPesoQuandoInformarNulo(){
        Aluno aluno = gerarAluno("José da Silva");
        Prova prova = gerarProva("Educação Física", toBigDecimal(5.0));
        Peso peso = gerarPeso(null);

        prova.setPeso(peso);
        aluno.getProvas().add(prova);

        List<Aluno> alunos = List.of(aluno);

        assertThrows(RegraDeNegocioException.class, () -> alunoService.criarAluno(alunos));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 6, 7, 10, -4})
    @DisplayName("Deveria validar o peso da prova quando informar o peso diferente de 1 até 5")
    void deveValidarNotaPesoQuandoInformarDiferente1E5(int pesos){
        Aluno aluno = gerarAluno("José da Silva");
        Prova prova = gerarProva("Educação Física", toBigDecimal(10.0));
        Peso peso = gerarPeso(pesos);

        prova.setPeso(peso);
        aluno.getProvas().add(prova);

        List<Aluno> alunos = List.of(aluno);

        assertThrows(RegraDeNegocioException.class, () -> alunoService.criarAluno(alunos));
    }

    @Test
    @DisplayName("Deveria validar a soma de pesos ao informar aluno")
    void deveValidarSomaPesosAoInformarAluno(){
        Aluno aluno = gerarAluno("José da Silva");
        Prova prova1 = gerarProva("Educação Física", toBigDecimal(8.5));
        Peso peso1 = gerarPeso(5);
        prova1.setPeso(peso1);

        Prova prova2 = gerarProva("Matemática", toBigDecimal(7.5));
        Peso peso2 = gerarPeso(5);
        prova2.setPeso(peso2);

        Prova prova3 = gerarProva("Língua Portuguesa", toBigDecimal(6.0));
        Peso peso3 = gerarPeso(5);
        prova3.setPeso(peso3);

        aluno.getProvas().add(prova1);
        aluno.getProvas().add(prova2);
        aluno.getProvas().add(prova3);

        List<Aluno> alunos = List.of(aluno);

        assertThrows(RegraDeNegocioException.class, () -> alunoService.criarAluno(alunos));
    }

    @Test
    @DisplayName("Deveria criar aluno quando informar corretamente")
    void deveCriarAluno(){
        Aluno aluno = gerarAluno("José da Silva");
        Prova prova1 = gerarProva("Educação Física", toBigDecimal(8.5));
        Peso peso1 = gerarPeso(3);
        prova1.setPeso(peso1);

        Prova prova2 = gerarProva("Matemática", toBigDecimal(7.5));
        Peso peso2 = gerarPeso(2);
        prova2.setPeso(peso2);

        Prova prova3 = gerarProva("Língua Portuguesa", toBigDecimal(6.0));
        Peso peso3 = gerarPeso(5);
        prova3.setPeso(peso3);

        aluno.getProvas().add(prova1);
        aluno.getProvas().add(prova2);
        aluno.getProvas().add(prova3);

        List<Aluno> alunos = List.of(aluno);

        String descricao = alunoService.criarAluno(alunos);

        assertTrue(descricao.contains("Aluno"));
    }

    private Aluno gerarAluno(String nome){
        return Aluno.builder()
                .id(UUID.randomUUID())
                .nome(nome)
                .provas(new ArrayList<>())
                .build();
    }

    private Prova gerarProva(String nome, BigDecimal nota){
        return Prova.builder()
                .id(UUID.randomUUID())
                .nota(nota)
                .nome(nome)
                .build();
    }

    private Peso gerarPeso(Integer valor){
        return Peso.builder()
                .id(UUID.randomUUID())
                .valor(valor)
                .build();
    }

}
