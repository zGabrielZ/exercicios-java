package br.com.gabrielferreira.fracao.main;

import br.com.gabrielferreira.fracao.model.Fracao;
import br.com.gabrielferreira.fracao.service.FracaoService;
import lombok.Generated;

import java.util.UUID;

@Generated
public class AplicacaoFracao {

    public static void main(String[] args) {
        System.out.println("Iniciando fração");

        Fracao fracao1 = new Fracao(UUID.randomUUID(), 4, 6);
        Fracao fracao2 = new Fracao(UUID.randomUUID(), 5, 10);
        FracaoService fracaoService = new FracaoService();
        System.out.println("Resultado da fração : " + fracaoService.multiplicarFracao(fracao1, fracao2));
    }
}
