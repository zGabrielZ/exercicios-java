package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.ErroInesperadoException;
import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Candidato;
import br.com.gabrielferreira.utils.VotoComparatorUtils;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static br.com.gabrielferreira.utils.LogUtils.gerarLogWarn;

@AllArgsConstructor
public class CandidatoService {

    private ArquivoService arquivoService;

    public List<Candidato> imprimirCandidatos(String entrada){
        validarEntrada(entrada);
        List<Candidato> candidatos = lerCandidatosEntrada(entrada);
        candidatos.sort(new VotoComparatorUtils());
        return candidatos;
    }

    private void validarEntrada(String entrada){
        if(entrada == null){
            throw new RegraDeNegocioException("É necessário informar a entrada");
        }

        if(!entrada.contains("csv")){
            throw new RegraDeNegocioException("Somente arquivo csv");
        }
    }

    private List<Candidato> lerCandidatosEntrada(String entrada){
        List<Candidato> candidatos = new ArrayList<>();
        Map<String, Integer> mapDados = new HashMap<>();
        InputStream inputStream = arquivoService.buscarCaminho(entrada);
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){

            String lerArquivo;

            while ((lerArquivo = bufferedReader.readLine()) != null){
                String[] valor = lerArquivo.split(",");

                String nome = valor[0];
                Integer voto = valor[1] != null ? Integer.parseInt(valor[1]) : 0;

                if(mapDados.containsKey(nome)){
                    Integer votoAnterior = mapDados.get(nome);
                    mapDados.replace(nome, votoAnterior + voto);
                } else {
                    mapDados.put(nome, voto);
                }

            }

            mapDados.forEach((nome, voto) -> candidatos.add(Candidato.builder().id(UUID.randomUUID()).nome(nome).quantidadeVotos(voto).build()));

            return candidatos;

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro ao ler o arquivo : {}", e);
            throw new ErroInesperadoException("Ocorreu erro ao ler arquivo");
        }
    }

}
