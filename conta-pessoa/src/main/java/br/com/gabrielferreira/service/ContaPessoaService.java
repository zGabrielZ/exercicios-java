package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.ContaPessoa;
import static br.com.gabrielferreira.utils.MascarasUtils.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;
import java.math.BigDecimal;
import java.util.UUID;

public class ContaPessoaService {

    private static final BigDecimal TAXA_SAQUE_REAL = toBigDecimal(5.0);

    public ContaPessoa criarContaPessoa(Integer numero, String nome, BigDecimal depositoInicial){
        validarNumero(numero);
        validarNome(nome);
        validarDepositoInicial(depositoInicial);
        return ContaPessoa.builder()
                .id(UUID.randomUUID())
                .numero(numero)
                .nome(nome)
                .saldo(depositoInicial)
                .build();
    }

    public String imprimirContaPessoa(ContaPessoa contaPessoa){
        validarContaPessoa(contaPessoa);
        return "Conta Pessoa \n" +
                "Número da conta " + contaPessoa.getNumero() +
                ", Nome da conta : " + contaPessoa.getNome() +
                ", Saldo : " + valorMonetarioBrasil(contaPessoa.getSaldo());
    }

    public void depositarContaPessoa(ContaPessoa contaPessoa, BigDecimal deposito){
        validarContaPessoa(contaPessoa);
        validarDepositoInicial(deposito);
        contaPessoa.setSaldo(somar(contaPessoa.getSaldo(), deposito));
    }

    public void sacarContaPessoa(ContaPessoa contaPessoa, BigDecimal deposito){
        validarContaPessoa(contaPessoa);
        validarDepositoInicial(deposito);
        validarSaque(contaPessoa.getSaldo(), deposito);
        BigDecimal saldo = subtrair(contaPessoa.getSaldo(), deposito);
        contaPessoa.setSaldo(subtrair(saldo, TAXA_SAQUE_REAL));
    }

    private void validarNumero(Integer numero){
        if(numero == null){
            throw new RegraDeNegocioException("É necessário informar o número");
        }

        if(numero < 0){
            throw new RegraDeNegocioException("O número não pode ser negativo");
        }
    }

    private void validarNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o nome");
        }
    }

    private void validarDepositoInicial(BigDecimal deposito){
        if(deposito == null){
            throw new RegraDeNegocioException("É necessário informar o depósito");
        }

        if(deposito.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException("O depósito não pode ser negativo");
        }
    }

    private void validarSaque(BigDecimal saldo, BigDecimal deposito){
        if(saldo.compareTo(deposito) < 0){
            throw new RegraDeNegocioException("O saldo não pode ser menor que o depósito informado");
        }
    }

    private void validarContaPessoa(ContaPessoa contaPessoa){
        if(contaPessoa == null){
            throw new RegraDeNegocioException("É necessário informar a conta");
        }
    }
}
