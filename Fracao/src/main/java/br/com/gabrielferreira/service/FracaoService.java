package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Fracao;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class FracaoService implements Serializable {

    @Serial
    private static final long serialVersionUID = -6405625430442826735L;

    public Fracao multiplicar(Fracao primeiraFracao, Fracao segundaFracao){
        validarFracao(primeiraFracao);
        validarFracao(segundaFracao);

        Integer multiplcacaoNumerador = primeiraFracao.getNumerador() * segundaFracao.getNumerador();
        Integer multiplicacaoDenominador = primeiraFracao.getDenominador() * segundaFracao.getDenominador();

        return Fracao.builder()
                .id(UUID.randomUUID())
                .numerador(multiplcacaoNumerador)
                .denominador(multiplicacaoDenominador)
                .build();
    }

    private void validarFracao(Fracao fracao){
        if(fracao == null){
            throw new RegraDeNegocioException("É necessário informar a fração");
        } else if(fracao.getNumerador() == null){
            throw new RegraDeNegocioException("É necessário informar o numerador");
        } else if(fracao.getDenominador() == null){
            throw new RegraDeNegocioException("É necessário informar o denominador");
        }
    }
}
