package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Jogo;
import br.com.gabrielferreira.utils.NomeComparator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.*;

public class JogoService {

    public Jogo criarJogo(String nome, BigDecimal preco){
        validarNome(nome);
        validarPreco(preco);
        return Jogo.builder()
                .id(UUID.randomUUID())
                .nome(nome)
                .preco(preco)
                .build();
    }

    public BigDecimal calcularSomaTotal(List<Jogo> jogos){
        return jogos.stream().map(Jogo::getPreco).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // FIXME: DIVIDE PRO CALCULO UTILS
    public BigDecimal calcularPrecoMedio(List<Jogo> jogos){
        BigDecimal somaTotal = calcularSomaTotal(jogos);
        BigDecimal quantidadeJogos = toBigDecimal(jogos.size());
        return somaTotal.divide(quantidadeJogos, 2, RoundingMode.HALF_EVEN);
    }

    public List<String> mostrarJogosOrdemDecrescente(List<Jogo> jogos){
        return jogos.stream().map(Jogo::getNome).sorted(new NomeComparator()).toList();
    }

    public List<String> mostrarJogosOrdemDecrescenteInferiorPrecoMedio(List<Jogo> jogos){
        BigDecimal precoMedio = calcularPrecoMedio(jogos);
        return jogos.stream().filter(jogo -> jogo.getPreco().compareTo(precoMedio) <= 0)
                .map(Jogo::getNome).sorted(new NomeComparator()).toList();
    }

    public List<String> mostrarJogosOrdemDecrescenteComPrecoMaiorOuIgualInformado(List<Jogo> jogos, BigDecimal preco){
        return jogos.stream().filter(jogo -> jogo.getPreco().compareTo(preco) >= 0)
                .map(Jogo::getNome).sorted(new NomeComparator()).toList();
    }

    public BigDecimal calcularSomaTotalComLetraInformada(List<Jogo> jogos, Character letra){
        return jogos.stream().filter(jogo -> letra.equals(jogo.getNome().charAt(0)))
                .map(Jogo::getPreco).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void validarNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o nome");
        }
    }

    private void validarPreco(BigDecimal preco){
        if(preco == null){
            throw new RegraDeNegocioException("É necessário informar preço");
        }

        if(preco.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException("Preço não pode ser negativo");
        }
    }
}
