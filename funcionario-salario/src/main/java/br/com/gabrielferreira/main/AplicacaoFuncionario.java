package br.com.gabrielferreira.main;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Funcionario;
import br.com.gabrielferreira.dto.NumeroFuncionarioCadastradoDTO;
import br.com.gabrielferreira.service.FuncionarioService;
import lombok.Generated;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static br.com.gabrielferreira.validate.ValidarEntrada.validarEntrada;
import static br.com.gabrielferreira.validate.ValidarEntrada.validarEntradaBigDecimal;
import static br.com.gabrielferreira.utils.LogUtils.*;

@Generated
public class AplicacaoFuncionario {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        FuncionarioService funcionarioService = new FuncionarioService();

        try {

            List<Funcionario> funcionarios = new ArrayList<>();
            List<NumeroFuncionarioCadastradoDTO> numerosFuncionariosCadastrados = new ArrayList<>();

            System.out.println("Quantos funcionários vai ser registrados ?, não pode ser negativo o número : ");
            int totalFuncionarios = verificarEntradaTotalFuncionarios(scanner);

            int numeroFuncionario = 1;
            for (int i = 0; i < totalFuncionarios; i++){
                System.out.println("Funcionário #" + numeroFuncionario);

                System.out.println("Número Funcionário : ");
                Integer numeroFuncionarioId = validarEntrada(scanner);

                scanner.nextLine();
                System.out.println("Nome : ");
                String nome = scanner.nextLine();

                System.out.println("Salário : ");
                BigDecimal salario = validarEntradaBigDecimal(scanner);

                numerosFuncionariosCadastrados.add(NumeroFuncionarioCadastradoDTO.builder().numeroFuncionario(numeroFuncionario)
                        .numeroFuncionarioIdentificador(numeroFuncionarioId).build());
                Funcionario funcionario = funcionarioService.criarFuncionario(numeroFuncionarioId, nome, salario, numerosFuncionariosCadastrados, numeroFuncionario);
                funcionarios.add(funcionario);

                numeroFuncionario++;
            }

            System.out.println("Digite o número do funcionário que vai ter o aumento : ");
            Integer numeroFuncionarioIdAumento = validarEntrada(scanner);

            System.out.println("Digite a porcentagem : ");
            BigDecimal porcentagemAumento = validarEntradaBigDecimal(scanner);

            funcionarioService.adicionarPorcentagemSalario(funcionarios, numeroFuncionarioIdAumento, porcentagemAumento);

            System.out.println(funcionarioService.imprimirFuncionarios(funcionarios));

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        scanner.close();
    }

    private static Integer verificarEntradaTotalFuncionarios(Scanner scanner){
        Integer totalFuncionarios = validarEntrada(scanner);
        if(totalFuncionarios < 0){
            throw new RegraDeNegocioException("Não pode informar número negativo");
        }
        return totalFuncionarios;
    }
}
