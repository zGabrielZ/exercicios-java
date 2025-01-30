package br.com.gabrielferreira.conta.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.conta.model.Conta;

import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;

public class ContaService {

    public Conta criarConta(Integer numeroConta, String titular, BigDecimal balancoInicial, BigDecimal saqueLimite){
        validarNumeroConta(numeroConta);
        validarTitular(titular);
        validarBigDecimal(balancoInicial, "É necessário informar balanço inicial", "Balanço inicial não pode ser negativo");
        validarBigDecimal(saqueLimite, "É necessário informar o saque limite", "Saque limite não pode ser negativo");
        return Conta.builder()
                .id(UUID.randomUUID())
                .numeroConta(numeroConta)
                .titular(titular)
                .balancoInicial(balancoInicial)
                .saqueLimite(saqueLimite)
                .build();
    }

    public BigDecimal saque(Conta conta, BigDecimal valorSaque){
        validarBigDecimal(valorSaque, "É necessário informar o valor do saque", "O valor do saque não pode ser negativo");
        validarConta(conta);

        if(valorSaque.compareTo(conta.getSaqueLimite()) > 0){
            throw new RegraDeNegocioException("O saque limite não permite você sacar com este valor");
        }

        if(valorSaque.compareTo(conta.getBalancoInicial()) > 0){
            throw new RegraDeNegocioException("Balanço não suficiente");
        }

        conta.setBalancoInicial(subtrair(conta.getBalancoInicial(), valorSaque));
        return conta.getBalancoInicial();
    }

    private void validarConta(Conta conta){
        if(conta == null){
            throw new RegraDeNegocioException("É necessário informar a conta");
        }
    }

    private void validarNumeroConta(Integer numeroConta){
        if(numeroConta == null){
            throw new RegraDeNegocioException("É necessário informar a número conta");
        }

        if(numeroConta < 0){
            throw new RegraDeNegocioException("Número conta não pode ser negativo");
        }
    }

    private void validarTitular(String titular){
        if(titular == null || titular.isBlank()){
            throw new RegraDeNegocioException("É necessário informar titular");
        }
    }

    private void validarBigDecimal(BigDecimal valor, String msg1, String msg2){
        if(valor == null){
            throw new RegraDeNegocioException(msg1);
        }

        if(valor.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException(msg2);
        }
    }
}
