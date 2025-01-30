package br.com.gabrielferreira.escola.main;

import br.com.gabrielferreira.escola.model.Aluno;
import br.com.gabrielferreira.escola.model.Peso;
import br.com.gabrielferreira.escola.model.Prova;
import br.com.gabrielferreira.escola.service.AlunoService;
import lombok.Generated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;

@Generated
public class AplicacaoEscola {

    public static void main(String[] args) {
        System.out.println("Iniciando a escola");

        System.out.println("Criando aluno 1");
        Aluno aluno1 = new Aluno(UUID.randomUUID(), "Gabriel Ferreira", new ArrayList<>());
        System.out.println(aluno1.getNome());

        System.out.println("Criando provas para o aluno 1");
        List<Prova> provas1 = new ArrayList<>();
        provas1.add(new Prova(UUID.randomUUID(), "Física", toBigDecimal(8.5), new Peso(UUID.randomUUID(), 3)));
        provas1.add(new Prova(UUID.randomUUID(), "Matemática", toBigDecimal(7.5), new Peso(UUID.randomUUID(), 2)));
        provas1.add(new Prova(UUID.randomUUID(), "Inglês", toBigDecimal(6.0), new Peso(UUID.randomUUID(), 5)));
        aluno1.setProvas(provas1);

        System.out.println("Criando aluno 2");
        Aluno aluno2 = new Aluno(UUID.randomUUID(), "José Ferreira", new ArrayList<>());
        System.out.println(aluno2.getNome());

        System.out.println("Criando provas para o aluno 2");
        List<Prova> provas2 = new ArrayList<>();
        provas2.add(new Prova(UUID.randomUUID(), "Programação", toBigDecimal(8.5), new Peso(UUID.randomUUID(), 3)));
        provas2.add(new Prova(UUID.randomUUID(), "Espanhol", toBigDecimal(7.5), new Peso(UUID.randomUUID(), 2)));
        aluno2.setProvas(provas2);

        System.out.println("Verificando a média dos alunos");
        AlunoService alunoService = new AlunoService();
        System.out.println(alunoService.criarAluno(Arrays.asList(aluno1, aluno2)));
    }
}
