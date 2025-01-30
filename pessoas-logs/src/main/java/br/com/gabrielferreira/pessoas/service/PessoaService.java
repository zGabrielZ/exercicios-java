package br.com.gabrielferreira.pessoas.service;

import br.com.gabrielferreira.commons.exception.ErroInesperadoException;
import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.commons.service.ArquivoService;
import br.com.gabrielferreira.pessoas.model.Pessoa;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

import static br.com.gabrielferreira.commons.utils.LogUtils.gerarLogWarn;
import static br.com.gabrielferreira.commons.utils.DataUtils.*;

@AllArgsConstructor
public class PessoaService {

    private ArquivoService arquivoService;

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
        InputStream inputStream = arquivoService.buscarCaminho(entrada);

        Set<Pessoa> pessoas = new HashSet<>();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){

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
