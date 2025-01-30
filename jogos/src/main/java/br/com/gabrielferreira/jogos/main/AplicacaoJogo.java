package br.com.gabrielferreira.jogos.main;

import br.com.gabrielferreira.jogos.model.Jogo;
import br.com.gabrielferreira.jogos.service.JogoService;
import lombok.Generated;

import java.util.ArrayList;
import java.util.List;

import static br.com.gabrielferreira.commons.utils.LogUtils.gerarLogWarn;
import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;
import static br.com.gabrielferreira.commons.utils.MascarasUtils.*;

@Generated
public class AplicacaoJogo {

    public static void main(String[] args) {
        JogoService jogoService = new JogoService();

        try {
            List<Jogo> jogos = new ArrayList<>();
            jogos.add(jogoService.criarJogo("Tibia", toBigDecimal(900.00)));
            jogos.add(jogoService.criarJogo("Mario", toBigDecimal(50.00)));
            jogos.add(jogoService.criarJogo("Thief", toBigDecimal(350.50)));
            jogos.add(jogoService.criarJogo("Hot Wheels", toBigDecimal(80.90)));
            jogos.add(jogoService.criarJogo("Cars", toBigDecimal(850.00)));
            jogos.add(jogoService.criarJogo("Mario 2", toBigDecimal(290.00)));

            System.out.println("Soma total : " + jogoService.calcularSomaTotal(jogos));
            System.out.println("Preço médio : " + valorMonetarioBrasil(jogoService.calcularPrecoMedio(jogos)));

            System.out.println("Jogos abaixo ordem decrescente  : ");
            System.out.println(jogoService.mostrarJogosOrdemDecrescente(jogos));

            System.out.println("Jogos abaixo ordem decrescente inferior a preço médio : ");
            System.out.println(jogoService.mostrarJogosOrdemDecrescenteInferiorPrecoMedio(jogos));

            System.out.println("Jogos abaixo ordem decrescente maior ou igual ao preço informado : ");
            System.out.println(jogoService.mostrarJogosOrdemDecrescenteComPrecoMaiorOuIgualInformado(jogos, toBigDecimal(200.00)));

            System.out.println("Soma total dos jogos com a letra informada : " + valorMonetarioBrasil(jogoService.calcularSomaTotalComLetraInformada(jogos, 'M')));

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }
    }
}
