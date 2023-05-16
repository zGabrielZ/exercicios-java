package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Aluno;
import br.com.gabrielferreira.model.Prova;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AlunoService implements Serializable {

    @Serial
    private static final long serialVersionUID = 6730307453958143191L;

    public String criarAluno(List<Aluno> alunos){

        StringBuilder sb = new StringBuilder();

        validarAlunos(alunos);

        alunos.forEach(aluno -> {
            validarNome(aluno.getNome());

            BigDecimal somaProvas = BigDecimal.ZERO;
            int somaPesos = 0;

            for (Prova prova : aluno.getProvas()) {
                validarNomeProva(prova.getNome(), aluno.getNome());
                validarNotaProva(prova.getNota(), aluno.getNome());
                validarPeso(prova.getPeso().getValor(), aluno.getNome());

                somaProvas = somaProvas.add(prova.getNota().multiply(BigDecimal.valueOf(prova.getPeso().getValor())));
                somaPesos += prova.getPeso().getValor();
            }

            validarSomaPesos(somaPesos);

            BigDecimal mediaProva = somaProvas.divide(BigDecimal.valueOf(somaPesos), RoundingMode.HALF_EVEN);
            sb.append("Aluno : ").append(aluno.getNome()).append(", Média : ").append(mediaProva).append("\n");
        });


        return sb.toString();
    }

    private void validarAlunos(List<Aluno> alunos){
        if(alunos.isEmpty()){
            throw new RegraDeNegocioException("É necessário informar pelo menos um aluno");
        }
    }

    private void validarNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o nome do aluno");
        }
    }

    private void validarNomeProva(String nome, String nomeAluno){
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException(String.format("É necessário informar o nome da prova do aluno %s", nomeAluno));
        }
    }

    private void validarNotaProva(BigDecimal nota, String nomeAluno){
        if(nota == null){
            throw new RegraDeNegocioException(String.format("É necessário informar a nota do aluno %s", nomeAluno));
        }

        if(!(nota.compareTo(BigDecimal.ZERO) >= 0 && nota.compareTo(BigDecimal.TEN) <= 0)){
            throw new RegraDeNegocioException(String.format("A nota do aluno %s tem que ser de 0.0 até 10.0", nomeAluno));
        }

    }

    private void validarPeso(Integer peso, String nomeAluno){
        if(peso == null){
            throw new RegraDeNegocioException(String.format("É necessário informar o peso da nota do aluno %s", nomeAluno));
        }

        if(!(peso >= 1 && peso <= 5)){
            throw new RegraDeNegocioException(String.format("O peso da nota do aluno %s tem que ser de 1 até 5", nomeAluno));
        }
    }

    private void validarSomaPesos(Integer somaPesos){
        if(somaPesos > 10){
            throw new RegraDeNegocioException("A nota do peso não pode ultrapassar de 10");
        }
    }
}
