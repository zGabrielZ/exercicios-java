package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.Aluno;
import br.com.gabrielferreira.model.Prova;
import br.com.gabrielferreira.model.Turma;
import lombok.Generated;

import java.util.Arrays;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.utils.MascarasUtils.valorFormatadoBrasil;

@Generated
public class AplicacaoSistemaEscolar {

    public static void main(String[] args) {
        System.out.println("Iniciando sistema escolar");

        Prova prova1 = new Prova(UUID.randomUUID(), "Inglês", toBigDecimal(4.0), toBigDecimal(2.5));
        Prova prova2 = new Prova(UUID.randomUUID(), "Programação", toBigDecimal(1.0), toBigDecimal(7.0));

        Prova prova3 = new Prova(UUID.randomUUID(), "Espanhol", toBigDecimal(6.5), toBigDecimal(3.5));
        Prova prova4 = new Prova(UUID.randomUUID(), "Matemática", toBigDecimal(0.0), toBigDecimal(3.0));

        Prova prova5 = new Prova(UUID.randomUUID(), "Língua Portuguesa", toBigDecimal(5.0), toBigDecimal(4.0));
        Prova prova6 = new Prova(UUID.randomUUID(), "Ciência", toBigDecimal(6.0), toBigDecimal(1.5));

        Aluno aluno1 = new Aluno(UUID.randomUUID(), "Gabriel", prova1, prova2);
        Aluno aluno2 = new Aluno(UUID.randomUUID(), "José", prova3, prova4);
        Aluno aluno3 = new Aluno(UUID.randomUUID(), "Tiago", prova5, prova6);

        Turma turma = new Turma(UUID.randomUUID(), "Turma dos Alunos bons", Arrays.asList(aluno1, aluno2, aluno3));

        System.out.println("Média da turma  : " + valorFormatadoBrasil(turma.calcularMedia()));
        System.out.println("Média do aluno 1  : " + valorFormatadoBrasil(aluno1.calcularMedia()));
        System.out.println("Média do aluno 2  : " + valorFormatadoBrasil(aluno2.calcularMedia()));
        System.out.println("Média do aluno 3  : " + valorFormatadoBrasil(aluno3.calcularMedia()));
    }
}
