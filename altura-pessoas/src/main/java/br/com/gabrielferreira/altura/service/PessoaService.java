package br.com.gabrielferreira.altura.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.altura.model.Pessoa;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PessoaService {

    public Pessoa criarPessoa(Double altura){
        validarAltura(altura);
        return Pessoa.builder()
                .id(UUID.randomUUID())
                .altura(altura)
                .build();
    }

    public Double calcularMediaAlturaPessoas(Pessoa...pessoas){
        List<Pessoa> pessoaList = Arrays.stream(pessoas).toList();
        validarPessoa(pessoaList);
        double soma = pessoaList.stream().mapToDouble(Pessoa::getAltura).sum();
        return soma / pessoaList.size();
    }

    private void validarPessoa(List<Pessoa> pessoas){
        pessoas.forEach(pessoa -> {
            if(pessoa == null){
                throw new RegraDeNegocioException("É necessário informar a pessoa");
            }

            validarAltura(pessoa.getAltura());
        });
    }

    private void validarAltura(Double altura){
        if(altura == null){
            throw new RegraDeNegocioException("É necessário informar a altura");
        }

        if(altura < 0){
            throw new RegraDeNegocioException("Altura não pode ser negativa");
        }
    }
}
