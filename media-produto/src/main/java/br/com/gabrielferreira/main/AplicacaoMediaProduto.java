package br.com.gabrielferreira.main;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Produto;
import br.com.gabrielferreira.service.ProdutoService;
import lombok.Generated;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;
import static br.com.gabrielferreira.utils.MascarasUtils.valorMonetarioBrasil;
import static br.com.gabrielferreira.validate.ValidarEntrada.*;
import static br.com.gabrielferreira.utils.LogUtils.*;

@Generated
public class AplicacaoMediaProduto {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        ProdutoService produtoService = new ProdutoService();

        try {
            System.out.println("Total de produtos que você deseja informar, não pode ser negativo o número : ");
            int totalProdutos = verificarEntradaTotalProdutos(scanner);

            Produto[] produtos = new Produto[totalProdutos];

            int numeroProduto = 1;
            for (int i = 0; i < totalProdutos; i++){

                System.out.println("Digite o nome do produto número #" + numeroProduto);
                scanner.nextLine();
                String nome = scanner.nextLine();

                System.out.println("Digite o preço do produto número #" + numeroProduto);
                BigDecimal preco = validarEntradaBigDecimal(scanner);

                produtos[i] = produtoService.criarProduto(nome, preco);

                numeroProduto++;
            }


            System.out.println("Média dos preços informados : " + valorMonetarioBrasil(produtoService.calcularMediaProdutoPreco(produtos)));

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        scanner.close();
    }

    private static Integer verificarEntradaTotalProdutos(Scanner scanner){
        Integer totalProduto = validarEntrada(scanner);
        if(totalProduto < 0){
            throw new RegraDeNegocioException("Não pode informar número negativo");
        }
        return totalProduto;
    }
}
