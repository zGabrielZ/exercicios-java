package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.Produto;
import br.com.gabrielferreira.service.ProdutoService;
import lombok.Generated;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.utils.DataUtils.toDataBrasil;

@Generated
public class AplicacaoProduto {

    public static void main(String[] args) {
        Produto produto1 = new Produto(UUID.randomUUID(), null, "Feijão", toBigDecimal(2.5), toDataBrasil("04/10/2020"));
        Produto produto2 = new Produto(UUID.randomUUID(), null, "Café", toBigDecimal(1.0), toDataBrasil("01/01/2022"));
        Produto produto3 = new Produto(UUID.randomUUID(), null, "Beterraba", toBigDecimal(0.9), toDataBrasil("12/11/2017"));

        List<Produto> produtos = Arrays.asList(produto1, produto2, produto3);

        ProdutoService produtoService = new ProdutoService();
        String retorno = produtoService.criarProdutos(produtos);
        System.out.println(retorno);

        System.out.println("Imprimindo produtos com peso em ordem crescente");

        List<Produto> produtosAdicionados = produtoService.imprimirProdutosOrdemCrescentePeso();
        produtosAdicionados.forEach(System.out::println);

        produtoService.limparProdutos();

        System.out.println("Criando outros produtos");

        Produto produto4 = new Produto(UUID.randomUUID(), null, "Laranja", toBigDecimal(2.5), toDataBrasil("04/10/2024"));
        Produto produto5 = new Produto(UUID.randomUUID(), null, "Maça", toBigDecimal(1.45), toDataBrasil("11/10/2030"));
        Produto produto6 = new Produto(UUID.randomUUID(), null, "Mamão", toBigDecimal(4.95), toDataBrasil("12/04/2025"));
        Produto produto7 = new Produto(UUID.randomUUID(), null, "Limão", toBigDecimal(2.30), toDataBrasil("12/11/2017"));

        String retorno2 = produtoService.criarProdutos(Arrays.asList(produto4, produto5, produto6, produto7));
        System.out.println(retorno2);

        System.out.println("Imprimindo produtos com peso em ordem crescente");
        produtosAdicionados = produtoService.imprimirProdutosOrdemCrescentePeso();
        produtosAdicionados.forEach(System.out::println);

    }
}
