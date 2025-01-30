package br.com.gabrielferreira.curso.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.curso.model.Aluno;
import br.com.gabrielferreira.curso.model.Curso;

import java.util.*;

public class CursoService {

    public Curso criarCurso(String tipoCurso, Integer... codigoAlunos){
        if(tipoCurso == null || tipoCurso.isBlank()){
            throw new RegraDeNegocioException("É necessário informar curso");
        }

        if(codigoAlunos == null || codigoAlunos.length == 0){
            throw new RegraDeNegocioException("É necessário ter pelo menos um aluno");
        }

        List<Aluno> alunos = new ArrayList<>();
        for (Integer codigoAluno : codigoAlunos) {

            int duplicados = Collections.frequency(Arrays.stream(codigoAlunos).toList(), codigoAluno);

            if (duplicados > 1) {
                throw new RegraDeNegocioException("Não pode repetir código de aluno");
            }

            alunos.add(Aluno.builder().id(UUID.randomUUID()).codigoAluno(codigoAluno).build());
        }

        return Curso.builder()
                .id(UUID.randomUUID())
                .tipoCurso(tipoCurso)
                .alunos(alunos)
                .build();
    }

    public Integer calcularQuantidadeAlunos(List<Curso> cursos){
        Set<Integer> codigosAlunos = new HashSet<>();
        cursos.forEach(curso -> curso.getAlunos().forEach(aluno -> codigosAlunos.add(aluno.getCodigoAluno())));
        return codigosAlunos.size();
    }
}
