package br.com.gabrielferreira.curso.main;

import br.com.gabrielferreira.curso.model.Curso;
import br.com.gabrielferreira.curso.service.CursoService;
import lombok.Generated;

import java.util.Arrays;

import static br.com.gabrielferreira.commons.utils.LogUtils.gerarLogWarn;

@Generated
public class AplicacaoCurso {

    public static void main(String[] args) {
        CursoService cursoService = new CursoService();

        try {
            Curso cursoA = cursoService.criarCurso("A", 21, 35, 22);
            Curso cursoB = cursoService.criarCurso("B", 21, 50);
            Curso cursoC = cursoService.criarCurso("C", 42, 35, 13);

            System.out.println("Quantidade de alunos : " + cursoService.calcularQuantidadeAlunos(Arrays.asList(cursoA, cursoB, cursoC)));

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }
    }
}
