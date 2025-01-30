package br.com.gabrielferreira.conta.main;

import br.com.gabrielferreira.conta.model.ContaBancaria;
import br.com.gabrielferreira.conta.model.ContaCorrente;
import lombok.Generated;

import java.math.BigDecimal;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.commons.utils.MascarasUtils.valorMonetarioBrasil;

@Generated
public class AplicacaoContaCorrente {

    private static final String MSG = "Depositando : ";

    public static void main(String[] args) {
        ContaBancaria contaCorrente1 = new ContaCorrente();

        BigDecimal primeiroDeposito = toBigDecimal(1500.55);
        System.out.println(MSG + valorMonetarioBrasil(primeiroDeposito));
        contaCorrente1.depositar(primeiroDeposito);

        BigDecimal segundoDeposito = toBigDecimal(467.550);
        System.out.println(MSG + valorMonetarioBrasil(segundoDeposito));
        contaCorrente1.depositar(segundoDeposito);

        BigDecimal terceiroDeposito = toBigDecimal(2200.450);
        System.out.println(MSG + valorMonetarioBrasil(terceiroDeposito));
        contaCorrente1.depositar(terceiroDeposito);

        System.out.println("Saldo da conta corrente após do déposito : " + valorMonetarioBrasil(contaCorrente1.getSaldo()));

        BigDecimal saque = toBigDecimal(11.00);
        System.out.println("Sacando : " + valorMonetarioBrasil(saque));
        contaCorrente1.sacar(saque);

        System.out.println("Saldo da conta corrente após o saque : " + valorMonetarioBrasil(contaCorrente1.getSaldo()));
        System.out.println("Cálculo do saldo final da conta corrente : " + valorMonetarioBrasil(contaCorrente1.calcularSaldoFinal()));

        BigDecimal saldoTransferir = toBigDecimal(200.00);
        System.out.println("Transferindo o valor " + valorMonetarioBrasil(saldoTransferir) + " da conta corrente 1 para 2");
        ContaBancaria contaCorrente2 = new ContaCorrente();
        contaCorrente1.transferir(saldoTransferir, contaCorrente2);
        System.out.println("Saldo da conta corrente 1 : " + valorMonetarioBrasil(contaCorrente1.getSaldo()));
        System.out.println("Saldo da conta corrente 2 : " + valorMonetarioBrasil(contaCorrente2.getSaldo()));
    }
}
