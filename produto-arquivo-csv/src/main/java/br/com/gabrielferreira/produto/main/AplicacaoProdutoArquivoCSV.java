package br.com.gabrielferreira.produto.main;

import br.com.gabrielferreira.commons.service.ArquivoService;
import br.com.gabrielferreira.produto.service.ProdutoService;
import lombok.Generated;

import static br.com.gabrielferreira.commons.utils.LogUtils.gerarLogWarn;

@Generated
public class AplicacaoProdutoArquivoCSV {

    public static void main(String[] args) {

        ProdutoService produtoService = new ProdutoService(new ArquivoService());

        try {
            String caminho = "sumario.csv";
            produtoService.gerarArquivoCsv(caminho, "sumario-resultado.csv");
        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }
    }
}
