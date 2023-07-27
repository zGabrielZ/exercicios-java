package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Produto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.*;

public class ProdutoService {

    public Produto criarProduto(String nome, BigDecimal preco){
        validarNome(nome);
        validarPreco(preco);
        return Produto.builder()
                .id(UUID.randomUUID())
                .nome(nome)
                .preco(preco)
                .build();
    }

    public BigDecimal calcularMediaProdutoPreco(Produto...produtos){
        List<Produto> produtoList = Arrays.stream(produtos).toList();
        validarProduto(produtoList);
        BigDecimal[] precos = produtoList.stream().map(Produto::getPreco).
                toList().toArray(new BigDecimal[0]);
        BigDecimal soma = somar(precos);
        return toRetorno(divide(soma, toBigDecimal(produtoList.size())), 2, RoundingMode.HALF_EVEN);
    }

    private void validarProduto(List<Produto> produtos){
        produtos.forEach(produto -> {
            if(produto == null){
                throw new RegraDeNegocioException("É necessário informar o produto");
            }

            validarNome(produto.getNome());
            validarPreco(produto.getPreco());
        });
    }

    private void validarNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o nome");
        }
    }

    private void validarPreco(BigDecimal preco){
        if(preco == null){
            throw new RegraDeNegocioException("É necessário informar o preço");
        }

        if(preco.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException("O preço não pode ser negativo");
        }
    }
}
