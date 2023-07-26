package br.com.gabrielferreira.main;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Pessoa;
import br.com.gabrielferreira.service.PessoaService;
import lombok.Generated;
import java.util.Locale;
import java.util.Scanner;
import static br.com.gabrielferreira.validate.ValidarEntrada.validarEntrada;
import static br.com.gabrielferreira.validate.ValidarEntrada.validarEntradaDouble;
import static br.com.gabrielferreira.utils.MascarasUtils.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static br.com.gabrielferreira.utils.LogUtils.*;

@Generated
public class AplicacaoAlturaPessoa {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        PessoaService pessoaService = new PessoaService();

        try {
            System.out.println("Total de pessoas que você deseja informar, não pode ser negativo o número : ");
            int totalPessoas = verificarEntradaTotalPessoas(scanner);

            Pessoa[] pessoas = new Pessoa[totalPessoas];

            int numeroPessoa = 1;
            for (int i = 0; i < totalPessoas; i++){
                System.out.println("Digite a altura da pessoa número #" + numeroPessoa++);
                Double altura = validarEntradaDouble(scanner);
                pessoas[i] = pessoaService.criarPessoa(altura);
            }


            System.out.println("Média das altura informadas : " + valorFormatadoBrasil(toBigDecimal(pessoaService.calcularMediaAlturaPessoas(pessoas))));

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        scanner.close();
    }

    private static Integer verificarEntradaTotalPessoas(Scanner scanner){
        Integer totalPessoa = validarEntrada(scanner);
        if(totalPessoa < 0){
            throw new RegraDeNegocioException("Não pode informar número negativo");
        }
        return totalPessoa;
    }
}
