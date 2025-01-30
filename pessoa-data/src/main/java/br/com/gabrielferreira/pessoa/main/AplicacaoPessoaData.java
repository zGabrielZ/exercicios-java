package br.com.gabrielferreira.pessoa.main;

import br.com.gabrielferreira.pessoa.model.Pessoa;
import lombok.Generated;

import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.DataUtils.toDataBrasil;

@Generated
public class AplicacaoPessoaData {

    public static void main(String[] args) {
        System.out.println("Iniciando pessoa data");
        Pessoa pessoa = new Pessoa(UUID.randomUUID(), toDataBrasil("26/12/1997"));

        System.out.println("Calcular anos");
        System.out.println(pessoa.calcularAnos());

        System.out.println("Calcular meses");
        System.out.println(pessoa.calcularMeses());

        System.out.println("Calcular dias");
        System.out.println(pessoa.calcularDias());
    }
}
