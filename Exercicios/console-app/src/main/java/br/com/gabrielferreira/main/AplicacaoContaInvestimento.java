package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.ContaBancaria;
import br.com.gabrielferreira.model.ContaInvestimento;
import lombok.Generated;

import java.math.BigDecimal;

import static br.com.gabrielferreira.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.utils.Mascaras.valorMonetarioBrasil;

@Generated
public class AplicacaoContaInvestimento {

    private static final String MSG = "Depositando : ";

    public static void main(String[] args) {
        System.out.println("Iniciando a conta investimento");
        ContaBancaria contaInvestimento1 = new ContaInvestimento();

        BigDecimal primeiroDeposito = toBigDecimal(3345.505);
        System.out.println(MSG + valorMonetarioBrasil(primeiroDeposito));
        contaInvestimento1.depositar(primeiroDeposito);

        BigDecimal segundoDeposito = toBigDecimal(1000.120);
        System.out.println(MSG + valorMonetarioBrasil(segundoDeposito));
        contaInvestimento1.depositar(segundoDeposito);

        BigDecimal terceiroDeposito = toBigDecimal(100.1134);
        System.out.println(MSG + valorMonetarioBrasil(terceiroDeposito));
        contaInvestimento1.depositar(terceiroDeposito);

        System.out.println("Saldo da conta investimento após do déposito : " + valorMonetarioBrasil(contaInvestimento1.getSaldo()));

        BigDecimal saque = toBigDecimal(2100.00);
        System.out.println("Sacando : " + valorMonetarioBrasil(saque));
        contaInvestimento1.sacar(saque);

        System.out.println("Saldo da conta investimento após o saque : " + valorMonetarioBrasil(contaInvestimento1.getSaldo()));
        System.out.println("Cálculo do saldo final da conta investimento : " + valorMonetarioBrasil(contaInvestimento1.calcularSaldoFinal()));

        BigDecimal saldoTransferir = toBigDecimal(200.00);
        System.out.println("Transferindo o valor " + valorMonetarioBrasil(saldoTransferir) + " da conta investimento 1 para 2");
        ContaBancaria contaInvestimento2 = new ContaInvestimento();
        contaInvestimento1.transferir(saldoTransferir, contaInvestimento2);
        System.out.println("Saldo da conta investimento 1 : " + valorMonetarioBrasil(contaInvestimento1.getSaldo()));
        System.out.println("Saldo da conta investimento 2 : " + valorMonetarioBrasil(contaInvestimento2.getSaldo()));
    }
}
