package br.com.gabrielferreira.escola.service;

import br.com.gabrielferreira.escola.model.Aluno;
import br.com.gabrielferreira.escola.model.Peso;
import br.com.gabrielferreira.escola.model.Prova;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;
import static br.com.gabrielferreira.commons.utils.MascarasUtils.valorFormatadoBrasil;
import static br.com.gabrielferreira.escola.validate.ValidarAluno.*;

public class AlunoService {

    public String criarAluno(List<Aluno> alunos){

        StringBuilder sb = new StringBuilder();

        validarAlunos(alunos);

        alunos.forEach(aluno -> {
            validarAluno(aluno);
            validarNomeAluno(aluno.getNome());

            BigDecimal somaProvas = BigDecimal.ZERO;
            int somaPesos = 0;

            for (Prova prova : aluno.getProvas()) {
                validarProva(prova);
                validarNomeProva(prova.getNome(), aluno.getNome());
                validarNotaProva(prova.getNota(), aluno.getNome());
                validarPeso(prova.getPeso(), aluno.getNome());

                somaProvas = somar(somaProvas, (multiplicar(prova.getNota(), toBigDecimal(prova.getPeso().getValor()))));
                somaPesos += prova.getPeso().getValor();
            }

            validarSomaPeso(somaPesos);

            BigDecimal mediaProva = divide(somaProvas, toBigDecimal(somaPesos), 2, RoundingMode.HALF_EVEN);
            BigDecimal retornoMediaProva = toRetorno(mediaProva, 2, RoundingMode.HALF_EVEN);
            sb.append("Aluno : ").append(aluno.getNome()).append(", Média : ").append(valorFormatadoBrasil(retornoMediaProva)).append("\n");
        });


        return sb.toString();
    }

    private void validarAlunos(List<Aluno> alunos){
        validarLista(alunos, "É necessário informar pelo menos um aluno");
    }

    private void validarAluno(Aluno aluno){
        validarObjeto(aluno, "É necessário informar o aluno");
    }

    private void validarNomeAluno(String nome){
        validarString(nome, "É necessário informar o nome do aluno");
    }

    private void validarProva(Prova prova){
        validarObjeto(prova, "É necessário informar a prova do aluno");
    }

    private void validarNomeProva(String nome, String nomeAluno){
        validarString(nome, String.format("É necessário informar o nome da prova do aluno %s", nomeAluno));
    }

    private void validarNotaProva(BigDecimal nota, String nomeAluno){
        validarBigDecimal(nota, String.format("É necessário informar a nota do aluno %s", nomeAluno));
        validarNotaAluno(nota, nomeAluno);
    }

    private void validarPeso(Peso peso, String nomeAluno){
        validarObjeto(peso, "É necessário informar o peso da prova do aluno");
        validarInteger(peso.getValor(), String.format("É necessário informar o peso da nota do aluno %s", nomeAluno));
        validarPeriodoPeso(peso.getValor(), nomeAluno);
    }
}
