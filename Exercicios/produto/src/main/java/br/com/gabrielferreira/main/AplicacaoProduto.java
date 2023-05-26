package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.Produto;
import br.com.gabrielferreira.service.ProdutoService;
import lombok.Generated;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static br.com.gabrielferreira.utils.DataUtils.*;

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
    }
}
