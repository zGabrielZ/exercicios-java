package br.com.gabrielferreira.funcionario.main;

import br.com.gabrielferreira.funcionario.model.Funcionario;
import br.com.gabrielferreira.funcionario.model.FuncionarioTerceirizado;
import lombok.Generated;

import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;

@Generated
public class AplicacaoFuncionario {

    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario(UUID.randomUUID(), "Alex", 50, toBigDecimal(20.00));
        Funcionario funcionario2 = new FuncionarioTerceirizado(UUID.randomUUID(), "Bob", 100, toBigDecimal(15.00), toBigDecimal(200.00));
        Funcionario funcionario3 = new Funcionario(UUID.randomUUID(), "Maria", 60, toBigDecimal(20.00));

        System.out.println("Pagamentos : ");
        System.out.println(funcionario1);
        System.out.println(funcionario2);
        System.out.println(funcionario3);
    }
}
