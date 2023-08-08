package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.ErroInesperadoException;
import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Produto;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.utils.LogUtils.gerarLogWarn;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

@AllArgsConstructor
public class ProdutoService {

    private ArquivoService arquivoService;

    public void gerarArquivoCsv(String entrada, String saida){
        validarEntradaSaida(entrada, "É necessário informar a entrada");
        validarEntradaSaida(saida, "É necessário informar a saída");
        List<Produto> produtos = lerProdutosEntrada(entrada);
        gerarArquivo(produtos, saida);
    }

    private void validarEntradaSaida(String valor, String msg1){
        if(valor == null){
            throw new RegraDeNegocioException(msg1);
        }

        if(!valor.contains("csv")){
            throw new RegraDeNegocioException("Somente arquivo csv");
        }
    }

    private List<Produto> lerProdutosEntrada(String entrada){
        List<Produto> produtos = new ArrayList<>();
        InputStream inputStream = arquivoService.buscarCaminho(entrada);
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){

            String lerArquivo;

            while ((lerArquivo = bufferedReader.readLine()) != null){
                String[] valor = lerArquivo.split(",");

                BigDecimal preco = valor[1] != null ? new BigDecimal(valor[1]) : BigDecimal.ZERO;
                int quantidade = valor[2] != null ? Integer.parseInt(valor[2]) : 0;

                Produto produto = Produto.builder()
                        .id(UUID.randomUUID())
                        .nome(valor[0])
                        .preco(preco)
                        .quantidade(quantidade)
                        .resultadoPreco(multiplicar(preco, toBigDecimal(quantidade)))
                        .build();

                produtos.add(produto);
            }

            return produtos;

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro ao ler o arquivo : {}", e);
            throw new ErroInesperadoException("Ocorreu erro ao ler arquivo");
        }
    }

    private void gerarArquivo(List<Produto> produtos, String saida){
        StringBuilder stringBuilder = new StringBuilder();
        produtos.forEach(produto -> stringBuilder.append(produto.getNome()).append(", ").append(produto.getResultadoPreco())
                .append("\n"));

        arquivoService.gerarArquivoEscrita(stringBuilder.toString(), System.getProperty("user.home") + "/Downloads/" + saida);
    }

}
