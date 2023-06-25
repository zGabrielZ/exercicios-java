package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Produto;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static br.com.gabrielferreira.utils.MascarasUtils.*;

public class ProdutoService implements Serializable {

    @Serial
    private static final long serialVersionUID = -1083799102490754440L;

    public Produto criarProduto(String nome, BigDecimal preco, Integer quantidade){
        validarNome(nome);
        validarPreco(preco);
        validarQuantidade(quantidade);

        Produto produto = Produto.builder()
                .id(UUID.randomUUID())
                .nome(nome)
                .preco(preco)
                .quantidade(quantidade)
                .build();

        produto.setTotal(calcularTotal(produto));
        return produto;
    }

    public void adicionarQuantidade(Produto produto, Integer quantidade){
        verificarProduto(produto);

        produto.setQuantidade(produto.getQuantidade() + quantidade);
        produto.setTotal(calcularTotal(produto));
    }

    public void removerQuantidade(Produto produto, Integer quantidade){
        verificarProduto(produto);

        if(produto.getQuantidade() < quantidade){
            throw new RegraDeNegocioException("A quantidade do produto informada é maior a quantidade");
        }

        produto.setQuantidade(produto.getQuantidade() - quantidade);
        produto.setTotal(calcularTotal(produto));
    }

    public String imprimirProduto(Produto produto){
        verificarProduto(produto);

        return "Nome do Produto : " +
                produto.getNome() +
                ", " +
                "Preço do Produto : " +
                valorMonetarioBrasil(produto.getPreco()) +
                ", " +
                "Quantidade : " +
                produto.getQuantidade() +
                ", " +
                "Total : " +
                valorMonetarioBrasil(produto.getTotal());
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
            throw new RegraDeNegocioException("É necessário informar o preço do produto maior que zero");
        }
    }

    private void validarQuantidade(Integer quantidade){
        if(quantidade == null){
            throw new RegraDeNegocioException("É necessário informar a quantidade do produto");
        }

        if(quantidade < 0){
            throw new RegraDeNegocioException("A quantidade não pode ser negativa");
        }
    }

    private void verificarProduto(Produto produto){
        if(produto == null){
            throw new RegraDeNegocioException("É necessário ter produto");
        }
    }

    private BigDecimal calcularTotal(Produto produto){
        return multiplicar(toBigDecimal(produto.getQuantidade()), produto.getPreco());
    }
}
