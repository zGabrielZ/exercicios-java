package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.Pessoa;
import br.com.gabrielferreira.model.PessoaFisica;
import br.com.gabrielferreira.model.PessoaJuridica;
import lombok.Generated;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

@Generated
public class AplicacaoPessoaFisicaJuridica {

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new PessoaFisica(UUID.randomUUID(), "Alex", toBigDecimal(50000.00), toBigDecimal(2000.00)));
        pessoas.add(new PessoaJuridica(UUID.randomUUID(), "SoftTech", toBigDecimal(400000.00), 25));
        pessoas.add(new PessoaFisica(UUID.randomUUID(), "Bob", toBigDecimal(120000.00), toBigDecimal(1000.00)));
        pessoas.add(new PessoaJuridica(UUID.randomUUID(), "SoftHouse", toBigDecimal(500000.00), 5));

        System.out.println("Taxas : ");
        pessoas.forEach(System.out::println);
    }
}
