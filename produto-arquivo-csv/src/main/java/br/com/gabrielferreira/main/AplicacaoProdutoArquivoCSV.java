package br.com.gabrielferreira.main;

import br.com.gabrielferreira.service.ArquivoService;
import br.com.gabrielferreira.service.ProdutoService;
import lombok.Generated;

import static br.com.gabrielferreira.utils.LogUtils.gerarLogWarn;

@Generated
public class AplicacaoProdutoArquivoCSV {

    public static void main(String[] args) {

        ProdutoService produtoService = new ProdutoService(new ArquivoService());

        try {
            String caminho = "D:\\CSV\\sumario.csv";
            produtoService.gerarArquivoCsv(caminho, "sumario-resultado.csv");
        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }
    }
}
