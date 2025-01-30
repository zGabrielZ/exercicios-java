package br.com.gabrielferreira.trabalhador.main;

import br.com.gabrielferreira.trabalhador.model.ContratoHora;
import br.com.gabrielferreira.trabalhador.model.Trabalhador;
import br.com.gabrielferreira.trabalhador.service.ContratoHoraService;
import br.com.gabrielferreira.trabalhador.service.TrabalhadorService;
import lombok.Generated;

import java.math.BigDecimal;
import java.util.*;

import static br.com.gabrielferreira.commons.validate.ValidarEntrada.*;
import static br.com.gabrielferreira.commons.utils.LogUtils.*;

@Generated
public class AplicacaoTrabalhador {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        TrabalhadorService trabalhadorService = new TrabalhadorService();
        ContratoHoraService contratoHoraService = new ContratoHoraService();

        try {
            System.out.println("Nome do departamento : ");
            String nomeDepartamento = scanner.nextLine();

            System.out.println("Digite os dados do trabalhador : ");
            System.out.println("Nome : ");
            String nomeTrabalhador = scanner.nextLine();

            System.out.println("Level (JUNIOR, PLENO, SENIOR): ");
            String level = scanner.nextLine();

            System.out.println("Salário base : ");
            BigDecimal salario = validarEntradaBigDecimal(scanner);

            Trabalhador trabalhador = trabalhadorService.criarTrabalhador(nomeDepartamento, nomeTrabalhador, level, salario);

            System.out.println("Quantos contratos para este trabalhador ? ");
            int qtdContratos = validarEntrada(scanner);

            int numeroTrabalhador = 1;
            for (int i = 0; i < qtdContratos; i++) {
                System.out.println("Contrato #" + numeroTrabalhador);

                scanner.nextLine();
                System.out.println("Data (DD/MM/AAAA) : ");
                String data = scanner.nextLine();

                System.out.println("Valor por hora : ");
                BigDecimal valorPorHora = validarEntradaBigDecimal(scanner);

                System.out.println("Duração (Horas) : ");
                Integer horas = validarEntrada(scanner);

                ContratoHora contratoHora = contratoHoraService.criarContratoHora(data, valorPorHora, horas);
                trabalhador.adicionarContratoHoras(contratoHora);

                numeroTrabalhador++;
            }

            scanner.nextLine();
            System.out.println("Digite o mês e o ano para calcular a renda do trabalhador (MM/AAAA) : ");
            String mesAnoRenda = scanner.nextLine();

            trabalhadorService.calcularRenda(mesAnoRenda, trabalhador);

            System.out.println(trabalhadorService.imprimirTrabalhador(trabalhador));


        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        scanner.close();
    }
}
