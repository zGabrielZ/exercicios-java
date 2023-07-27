package br.com.gabrielferreira.main;
import br.com.gabrielferreira.model.Funcionario;
import br.com.gabrielferreira.service.FuncionarioService;
import lombok.Generated;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;
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
            System.out.println("Nome : ");
            String nome = scanner.nextLine();

            System.out.println("Salário bruto : ");
            BigDecimal salarioBruto = validarEntradaBigDecimal(scanner);

            System.out.println("Taxa : ");
            BigDecimal taxa = validarEntradaBigDecimal(scanner);

            Funcionario funcionario = funcionarioService.criarFuncionario(nome, salarioBruto, taxa);
            System.out.println(funcionarioService.imprimirFuncionario(funcionario));

            System.out.println("Qual a porcentagem para adicionar no salário do funcionário ? ");
            BigDecimal porcentagem = validarEntradaBigDecimal(scanner);

            funcionarioService.adicionarPorcentagemSalario(funcionario, porcentagem);
            System.out.println(funcionarioService.imprimirFuncionario(funcionario));

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        scanner.close();
    }
}
