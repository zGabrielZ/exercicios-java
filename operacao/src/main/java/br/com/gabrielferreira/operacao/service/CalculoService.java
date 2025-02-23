package br.com.gabrielferreira.operacao.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.operacao.model.enumeration.Operacao;
import java.math.BigDecimal;

public class CalculoService {

    public BigDecimal calcular(BigDecimal valorParte1, BigDecimal valorParte2, Operacao operacao){
        validarValorInformado(valorParte1, "É necessário informar o valor parte 1");
        validarValorInformado(valorParte2, "É necessário informar o valor parte 2");
        validarOperacaoInformada(operacao);
        return operacao.calcular(valorParte1, valorParte2);
    }

    private void validarValorInformado(BigDecimal valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(msg);
        }
    }

    private void validarOperacaoInformada(Operacao operacao){
        if(operacao == null){
            throw new RegraDeNegocioException("É necessário informar o tipo da operação");
        }
    }
}
