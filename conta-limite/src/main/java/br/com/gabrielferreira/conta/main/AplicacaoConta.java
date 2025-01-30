package br.com.gabrielferreira.conta.main;

import br.com.gabrielferreira.conta.model.Conta;
import br.com.gabrielferreira.conta.service.ContaService;
import lombok.Generated;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

import static br.com.gabrielferreira.commons.utils.LogUtils.gerarLogWarn;
import static br.com.gabrielferreira.commons.validate.ValidarEntrada.*;
import static br.com.gabrielferreira.commons.utils.MascarasUtils.*;

@Generated
public class AplicacaoConta {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        ContaService contaService = new ContaService();

        try {

            System.out.println("Digite os dados da conta : ");
            System.out.println("Número : ");
            Integer numeroConta = validarEntrada(scanner);

            scanner.nextLine();

            System.out.println("Titular : ");
            String titular = scanner.nextLine();

            System.out.println("Balanço inicial : ");
            BigDecimal balancoInicial = validarEntradaBigDecimal(scanner);

            System.out.println("Limite do saque :");
            BigDecimal limiteSaque = validarEntradaBigDecimal(scanner);

            Conta conta = contaService.criarConta(numeroConta, titular, balancoInicial, limiteSaque);

            System.out.println("Digite o valor para o saque : ");
            BigDecimal quantidadeSaque = validarEntradaBigDecimal(scanner);

            System.out.println("Novo balanço : " + valorMonetarioBrasil(contaService.saque(conta, quantidadeSaque)));

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        scanner.close();
    }
}
