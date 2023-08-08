package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.Candidato;
import br.com.gabrielferreira.service.ArquivoService;
import br.com.gabrielferreira.service.CandidatoService;
import lombok.Generated;

import java.util.List;

import static br.com.gabrielferreira.utils.LogUtils.gerarLogWarn;

@Generated
public class AplicacaoEleicao {

    public static void main(String[] args) {

        CandidatoService candidatoService = new CandidatoService(new ArquivoService());

        try {
            List<Candidato> candidatos = candidatoService.imprimirCandidatos("candidatos.csv");
            candidatos.forEach(candidato -> System.out.println(candidato.getNome() + " : " + candidato.getQuantidadeVotos()));
        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }
    }
}
