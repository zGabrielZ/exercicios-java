package br.com.gabrielferreira.service;

import br.com.gabrielferreira.model.Fracao;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidarFracao.*;

public class FracaoService implements Serializable {

    @Serial
    private static final long serialVersionUID = -6405625430442826735L;

    public Fracao multiplicar(Fracao primeiraFracao, Fracao segundaFracao){
        validarFracao(primeiraFracao);
        validarFracao(segundaFracao);

        Integer multiplcacaoNumerador = primeiraFracao.getNumerador() * segundaFracao.getNumerador();
        Integer multiplicacaoDenominador = primeiraFracao.getDenominador() * segundaFracao.getDenominador();

        return new Fracao(UUID.randomUUID(), multiplcacaoNumerador, multiplicacaoDenominador);
    }

    private void validarFracao(Fracao fracao){
        validarObjeto(fracao, "É necessário informar a fração");
        validarValorInformado(fracao.getNumerador(), "É necessário informar o numerador");
        validarValorInformado(fracao.getDenominador(), "É necessário informar o denominador");
    }
}
