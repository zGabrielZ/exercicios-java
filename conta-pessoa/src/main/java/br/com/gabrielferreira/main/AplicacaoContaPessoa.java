package br.com.gabrielferreira.main;
import br.com.gabrielferreira.exception.ErroInesperadoException;
import br.com.gabrielferreira.model.ContaPessoa;
import br.com.gabrielferreira.service.ContaPessoaService;
import lombok.Generated;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;
import static br.com.gabrielferreira.validate.ValidarEntrada.validarEntrada;
import static br.com.gabrielferreira.validate.ValidarEntrada.validarEntradaBigDecimal;
import static br.com.gabrielferreira.utils.LogUtils.*;

@Generated
public class AplicacaoContaPessoa {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        ContaPessoaService contaPessoaService = new ContaPessoaService();

        try {
            System.out.println("Digite o número da conta : ");
            Integer numero = validarEntrada(scanner);
            scanner.nextLine();

            System.out.println("Digite o nome da conta : ");
            String nome = scanner.nextLine();

            System.out.println("Deseja iniciar o seu saldo ? (S/N) : ");
            Character depositoInicial = scanner.next().charAt(0);
            ContaPessoa contaPessoa = verificarLetraInformada(depositoInicial, scanner, contaPessoaService, nome, numero);

            System.out.println();
            System.out.println(contaPessoaService.imprimirContaPessoa(contaPessoa));

            System.out.println();
            System.out.println("Digite um valor para depósito : ");
            BigDecimal deposito = validarEntradaBigDecimal(scanner);

            contaPessoaService.depositarContaPessoa(contaPessoa, deposito);

            System.out.println();
            System.out.println(contaPessoaService.imprimirContaPessoa(contaPessoa));

            System.out.println();
            System.out.println("Digite um valor para saque : ");
            BigDecimal saque = validarEntradaBigDecimal(scanner);

            contaPessoaService.sacarContaPessoa(contaPessoa, saque);

            System.out.println();
            System.out.println(contaPessoaService.imprimirContaPessoa(contaPessoa));


        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        scanner.close();
    }

    private static ContaPessoa verificarLetraInformada(Character letraInformada, Scanner scanner, ContaPessoaService contaPessoaService, String nome, Integer numero){
        switch (letraInformada) {
            case 'S' ->  {
                System.out.println("Digite o déposito inicial : ");
                BigDecimal depositoInicial = validarEntradaBigDecimal(scanner);
                return contaPessoaService.criarContaPessoa(numero, nome, depositoInicial);
            }
            case 'N' -> {
                return contaPessoaService.criarContaPessoa(numero, nome, BigDecimal.ZERO);
            }
            default -> throw new ErroInesperadoException("Não foi selecionada a letra correta");
        }
    }
}
