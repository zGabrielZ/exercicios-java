package br.com.gabrielferreira.main;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Pessoa;
import br.com.gabrielferreira.model.dto.QuartosReservadosDTO;
import br.com.gabrielferreira.service.PessoaService;
import lombok.Generated;

import java.util.*;

import static br.com.gabrielferreira.validate.ValidarEntrada.validarEntrada;
import static br.com.gabrielferreira.utils.LogUtils.*;

@Generated
public class AplicacaoAluguel {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        PessoaService pessoaService = new PessoaService();

        try {
            System.out.println("Quantos quartos vai ser alugados ?, não pode ser negativo o número : ");
            int totalQuartos = verificarEntradaTotalQuartos(scanner);

            Pessoa[] pessoas = new Pessoa[totalQuartos];

            List<QuartosReservadosDTO> quartosJaAlugados = new ArrayList<>();

            int numeroPessoa = 1;
            for (int i = 0; i < totalQuartos; i++){
                System.out.println("Alguel #" + numeroPessoa);

                scanner.nextLine();
                System.out.println("Nome : ");
                String nome = scanner.nextLine();

                System.out.println("Email : ");
                String email = scanner.nextLine();

                System.out.println("Número do quarto : ");
                Integer numeroQuarto = validarEntrada(scanner);

                quartosJaAlugados.add(QuartosReservadosDTO.builder().numeroPessoa(numeroPessoa).quartoReservado(numeroQuarto).build());

                pessoas[i] = pessoaService.criarPessoa(nome, email, numeroQuarto, quartosJaAlugados, numeroPessoa);
                numeroPessoa++;
            }

            System.out.println(pessoaService.imprimirPessoas(pessoas));

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        scanner.close();
    }

    private static Integer verificarEntradaTotalQuartos(Scanner scanner){
        Integer totalQuartos = validarEntrada(scanner);
        if(totalQuartos < 0){
            throw new RegraDeNegocioException("Não pode informar número negativo");
        }
        return totalQuartos;
    }
}
