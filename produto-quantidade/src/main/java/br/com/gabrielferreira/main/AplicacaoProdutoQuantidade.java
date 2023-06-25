package br.com.gabrielferreira.main;
import br.com.gabrielferreira.model.Produto;
import br.com.gabrielferreira.service.ProdutoService;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

import static br.com.gabrielferreira.validate.ValidarEntrada.*;

@Slf4j
@Generated
public class AplicacaoProdutoQuantidade {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        ProdutoService produtoService = new ProdutoService();

        try {
            System.out.println("Digite as informações do produto : ");
            System.out.println("Nome : ");
            String nome = scanner.nextLine();

            System.out.println("Preço : ");
            BigDecimal preco = validarEntradaBigDecimal(scanner);

            System.out.println("Quantidade : ");
            Integer quantidade = validarEntrada(scanner);

            Produto produto = produtoService.criarProduto(nome, preco, quantidade);

            System.out.println(produtoService.imprimirProduto(produto));

            System.out.println("Digite um número inteiro para adicionar no estoque do produto " + produto.getNome());
            Integer novaQuantidade = validarEntrada(scanner);

            produtoService.adicionarQuantidade(produto, novaQuantidade);
            System.out.println(produtoService.imprimirProduto(produto));

            System.out.println("Digite um número inteiro para remover no estoque do produto " + produto.getNome());
            Integer novaQuantidadeRemover = validarEntrada(scanner);

            produtoService.removerQuantidade(produto, novaQuantidadeRemover);
            System.out.println(produtoService.imprimirProduto(produto));

        } catch (Exception e){
            log.warn("Ocorreu erro na aplicação. Causa : {}", e.getMessage());
        }

        scanner.close();
    }
}
