package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.ErroInesperadoException;
import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Pessoa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

import static br.com.gabrielferreira.utils.LogUtils.gerarLogWarn;
import static br.com.gabrielferreira.utils.DataUtils.*;

public class PessoaService {

    public Integer totalUsuarioLog(String entrada){
        validarEntrada(entrada);
        Set<Pessoa> pessoas = lerPessoasEntrada(entrada);
        return pessoas.size();
    }

    private void validarEntrada(String entrada){
        if(entrada == null){
            throw new RegraDeNegocioException("É necessário informar a entrada");
        }

        if(!entrada.contains("txt")){
            throw new RegraDeNegocioException("Somente arquivo txt");
        }
    }

    private Set<Pessoa> lerPessoasEntrada(String entrada){
        Set<Pessoa> pessoas = new HashSet<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(entrada, StandardCharsets.UTF_8))){

            String lerArquivo;

            while ((lerArquivo = bufferedReader.readLine()) != null){
                String[] valor = lerArquivo.split(" ");

                String nome = valor[0];

                if(nome != null && pessoas.stream().noneMatch(p -> p.getNome().equals(nome))){
                    LocalDateTime dataAcesso = valor[1] != null ? toDataPadraoISO8601(valor[1]) : null;

                    Pessoa pessoa = Pessoa.builder()
                            .id(UUID.randomUUID())
                            .nome(nome)
                            .dataAcesso(dataAcesso)
                            .build();

                    pessoas.add(pessoa);
                }
            }

            return pessoas;

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro ao ler o arquivo : {}", e);
            throw new ErroInesperadoException("Ocorreu erro ao ler arquivo");
        }
    }
}
